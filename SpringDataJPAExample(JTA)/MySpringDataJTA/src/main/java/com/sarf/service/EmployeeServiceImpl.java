/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.sarf.domain.AuditTrail;
import com.sarf.domain.Employee;
import com.sarf.dto.EmployeeDTO;
import com.sarf.dto.ResponseDTO;
import com.sarf.repository.AuditTrailRepository;
import com.sarf.repository.EmployeeRepository;
import com.sarf.util.MapperUtil;

/**
 * @author mokhan
 * 
 */
// @Component("employeeService")
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AuditTrailRepository auditTrailRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private TransactionTemplate txTemplate;

	private Mapper mapper = MapperUtil.getMapper();

	/** {@inheritDoc} */
	public void addEmployee(final String employeeName) {
		final Employee e = new Employee();
		e.setStrEmployeeName(employeeName);
		this.employeeRepository.saveAndFlush(e);
	}

	/** {@inheritDoc} */
	public EmployeeDTO getEmployee(final Integer nEmplId) {
		try {

			final Employee employee = this.employeeRepository.findOne(nEmplId);
			EmployeeDTO employeeDTO;
			employeeDTO = mapper.map(employee, EmployeeDTO.class);
			return employeeDTO;
		} catch (Exception e) {
			System.out
					.println("Exception occurred while finding the employee : "
							+ e.getCause());
		} finally {
			auditTrail();
		}
		return null;
	}

	public List<EmployeeDTO> getEmployees() {
		// final List<Employee> listEmployees =
		// this.employeeRepository.findAll();
		String query = "select e.* from employee e";
		Query query2 = entityManager.createNativeQuery(query, Employee.class);
		final List<Employee> listEmployees = query2.getResultList();
		final List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO;
		for (final Employee employee : listEmployees) {
			employeeDTO = mapper.map(employee, EmployeeDTO.class);
			listEmployeeDTO.add(employeeDTO);
		}
		return listEmployeeDTO;
	}

	public List<EmployeeDTO> getEmployeesByName(final String strEmployeeName) {
		final List<Employee> listEmployees = this.employeeRepository
				.findByEmployeeName(strEmployeeName);
		final List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO;
		for (final Employee employee : listEmployees) {
			employeeDTO = mapper.map(employee, EmployeeDTO.class);
			listEmployeeDTO.add(employeeDTO);
		}
		return listEmployeeDTO;
	}

	public void deleteEmployee(final String strEmplId) {
		try {
			final Employee employee = new Employee();
			final int id = Integer.parseInt(strEmplId);
			employee.setnEmployeeId(id);
			this.employeeRepository.delete(employee);
		} catch (Exception e) {
			System.out
					.println("Exception occured while deleteing the employee");
		}
	}

	public List<AuditTrail> getAuditTrail() {
		List<AuditTrail> auditTrailList = this.auditTrailRepository.findAll();
		return auditTrailList;
	}

	private void auditTrail() {
		txTemplate
				.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		txTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				AuditTrail auditTrail = new AuditTrail();
				auditTrail.setAuditDesc("Find Employee");
				auditTrail.setAuditDate(Calendar.getInstance().getTime());
				auditTrailRepository.save(auditTrail);
			}
		});
	}

	public ResponseDTO getEmployeeByPage(String page) {
		int pageSize = 3;

		PageRequest pageRequest = new PageRequest(Integer.valueOf(page) - 1,
				pageSize, Sort.Direction.ASC, "nEmployeeId");
		Page<Employee> emplPage = this.employeeRepository.findAll(pageRequest);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(emplPage.getTotalPages() + "");

		final List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO;
		for (final Employee employee : emplPage.getContent()) {
			employeeDTO = mapper.map(employee, EmployeeDTO.class);
			listEmployeeDTO.add(employeeDTO);
		}
		responseDTO.setList(listEmployeeDTO);
		;
		return responseDTO;
	}

}
