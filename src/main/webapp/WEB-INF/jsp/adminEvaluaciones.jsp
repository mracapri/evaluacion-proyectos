<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<span class="titulo-ventana">Evaluaciones</span>
			<div class="control-group">
				<div class="row-fluid">
			    	<div class="span12">
						<a class="btn btn-primary nav pull-right"href="${pageContext.request.contextPath}/resolver/evaluacion/form"><i class="icon-plus-sign icon-white"></i> Nuevo</a>
					</div>  
				</div>
		       <section id="proyectos">
		       
		       		<div id="alert-for-delete" class="collapse">
						<div class="alert">
		       				<b>Atenci&oacuten:</b> 
		       				eliminar implica, desaparecer todos los datos capturados
		       				a la evaluaci&oacuten, como lo son: evaluadores, proyectos
		       				calificaciones y toda informaci&oacuten se perder&aacute!
		       			</div>		
		       		</div>
		       		
		       		</br>
		       		<c:forEach var="evaluacion" items="${evaluaciones}" varStatus="row">
		       			<div class="row-fluid">
			       			<div class="span6">
				       			<span><b>${evaluacion.descripcion}</b></span>
								<a data-toggle="collapse" 
									data-target="#delete-evaluacion-${row.count}, #alert-for-delete"
									href="#">
					       			<i class="icon-trash"></i> eliminar
					       		</a>
					       		<div id="delete-evaluacion-${row.count}" class="collapse">
									<a class="btn btn-mini btn-danger" 
										href="${pageContext.request.contextPath}/resolver/evaluacion/delete/${evaluacion.idEvaluacion}">Aceptar</a>
									<a class="btn btn-mini btn-info" data-toggle="collapse" 
										data-target="#delete-evaluacion-${row.count}, #alert-for-delete"
										href="#">Cancelar</a>
					       		</div>
				       	 	</div>
				       	 	<div class="span3">
				       			
					       			<a href="${pageContext.request.contextPath}/resolver/evaluacion/${evaluacion.idEvaluacion}/proyectos">
					       				<i class="icon-list-alt"></i> proyectos
					       			</a>
				       			
				       	 	</div>  
				       	 	<div class="span3">
				       		
					       			<a href="${pageContext.request.contextPath}/resolver/evaluacion/evaluadores/${evaluacion.idEvaluacion}">
					       				<i class=" icon-user"></i> evaluadores
					       			</a>
				       			
				       	 	</div>  
						</div> 
		       		</c:forEach>
		       </section>
			</div>
	   </div>
	</div>
</body>
</html>