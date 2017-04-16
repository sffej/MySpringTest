<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<fieldset style="width: 400px; height: 220px">
		<legend>Login</legend>
		
		
		<form class="form-horizontal"
			action="<c:url value='/login'/>" method="post"
			id="frmLogin" name="frmLogin">

			User ID : <input type="text" class="form-control" id="username"
				name="username">

			<br /> Password: <input type="password" class="form-control"
				id="password" name="password"/> <br />

			<button type="submit" id="login">Login</button>
			
			
			
		</form>
		<div>
		User Id : admin
		<br>
		Password: pass
		</div>
		
	</fieldset>


</body>
</html>

