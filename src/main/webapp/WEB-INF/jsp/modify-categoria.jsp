<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">
<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=Latin1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-collapse.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
</head>
<body>		
	<div class="container" >
		<!-- Encabezado menu Logout -->
		<div class="masthead">
		  <ul class="nav nav-pills pull-right">
		    <li class="active"><a href="#">Home</a></li>
		    <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Salir</a></li>
		  </ul>
		  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
		</div>
		<div class="detalleProyecto">
		
			<div><h2>Nueva categor&iacutea para proyectos</h2></div>
			
			<form:form action="${pageContext.request.contextPath}/resolver/categoria/modify" method="post" modelAttribute="formCategoria">
				<div class="control-group">
				
					<div class="row-fluid">
						<div class="span6">
							<label>
								<b>Descripci&oacuten:</b>
								<p>
									Alimentos derivados del campo, Software para moviles, Apoyo social, etc.
								</p> 
							</label>
							<spring:hasBindErrors name="formCategoria">								
								<span class="label label-info">
									<form:errors path="descripcion" />
								</span>
							</spring:hasBindErrors>
							<form:input path="descripcion"/>
																					
						</div>
					</div>
					<div class="row-fluid">						
						<div class="span12" style="text-align:center; margin-top:2em">
							<button class="btn btn-success" type="submit">Guardar</button>	
							<a class="btn btn-danger" href="${pageContext.request.contextPath}/resolver/categoria/all">Cancelar</a>			
						</div>
					</div>

				</div>
			</form:form>
	   </div>
	</div>
</body>
</html>