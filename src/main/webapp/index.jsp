<html>
<body>
<h2>Greeting Test</h2>
  <a href="addEmployee.jsp">Add Employee</a><br />
  <a href="rs/employee-service/getEmployee/2">Get Employee</a><br />
  <a href="rs/employee-service/getEmployees">Get All Employees</a><br />
  <a href="rs/employee-service/getEmployeesByName/sarf">Find by Employee Name "sarf"</a><br />
  Employee Id <input name="id" id="id" ><a href="" onclick="deleteEmployee()">Delete Employee</a><br />
  <a href="rs/employee-service/download">Download</a><br />
  <a href="rs/employee-service/get_audit_trail">Audit Trail</a><br />
  <a href="rs/employee-service/get_employee_by_page/1">Employee By Page</a><br />
  <script type="text/javascript">
  function deleteEmployee()
  {
	  var ajaxRequest = new XMLHttpRequest();
	  var queryString = document.getElementById("id").value;
	  queryString = "rs/employee-service/deleteEmployee/"+queryString;
	  ajaxRequest.open("DELETE", queryString, true);
	  ajaxRequest.send(null); 
  }
  
  </script>
</body>
</html>
