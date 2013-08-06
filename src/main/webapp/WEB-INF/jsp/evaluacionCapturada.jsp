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
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
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
			<div class="proyectoEvaluar">
				<div class="row-fluid">
				    <div class="span12 show-grid">
				    	<span class="titulo-ventana">
				    		Evaluaci&oacuten de Proyectos
				    	</span>
			       		<br/>
			       		<br/>
			       		<div class="alert alert-info">
			       			Estimado evaluador, esta evaluaci&oacuten ya ha sido registrada,
			       			le pedimos de favor dar click en el boton -<b>Regresar</b>- Gracias!
			       		</div>
						<a class="btn btn-danger" href="${pageContext.request.contextPath}/resolver/evaluador/proyectos">Regresar</a>
				    </div>
				</div> 
			</div>

	</div>
</body>
</html>