package com.sarf.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable{
	String code;
	List<EmployeeDTO> list;

	public List<EmployeeDTO> getList() {
		return list;
	}

	public void setList(List<EmployeeDTO> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	

}
