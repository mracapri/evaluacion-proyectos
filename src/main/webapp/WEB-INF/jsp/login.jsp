<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
</head>
<body>		
	<div class="container" >
		
			<form class="form-login" action="${pageContext.request.contextPath}/j_spring_security_check">
				<h2 class="form-signin-heading">Login...</h2>
	            <div class="control-group">
	              <label for="usuario" class="control-label">Usuario</label>
	              <div class="controls">
	                <input type="text" placeholder="Email" id="usuario" name="j_username">
	              </div>
	            </div>
	            <div class="control-group">
	              <label for="password" class="control-label">Contraseña</label>
	              <div class="controls">
	                <input type="password" placeholder="Password" id="password" name="j_password">
	              </div>
	            </div>
	            <div class="control-group">
	              <div class="controls">
	                <label class="checkbox">
	                  <input type="checkbox"> Recordarme
	                </label>
	                <button class="btn btn-large btn-primary" type="submit">Entrar</button>
	              </div>
	            </div>
	       </form>
		
	</div>
</body>
</html>