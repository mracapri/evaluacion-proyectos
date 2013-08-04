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
		    <li><a href="#">Salir</a></li>
		  </ul>
		  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
		</div>
		<div class="detalleProyecto">
			<span class="titulo-ventana">Evaluaciones</span>
			<div class="control-group">
				<div class="controls">
					<a class="btn btn-primary nav pull-right"href="${pageContext.request.contextPath}/jsp/nuevaEvaluacion.jsp"><i class="icon-plus-sign icon-white"></i> Nuevo</a>
				</div>
			</div>
			<div class="control-group">
		       <section id="proyectos">
	       			<span>Evaluacion numero1</span>				
		       </section>
			</div>
	   </div>
	</div>
</body>
</html>