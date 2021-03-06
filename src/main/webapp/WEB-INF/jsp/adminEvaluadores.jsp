<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Latin1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link media="screen" type="text/css"
	href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" />
<link media="screen" type="text/css"
	href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet" />
<link media="screen" type="text/css"
	href="${pageContext.request.contextPath}/web-resources/css/application.css"
	rel="stylesheet" />


<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-collapse.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-fileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
</head>
<body>
	<div class="container">
		<!-- Encabezado menu Logout -->
		<div class="masthead">
		  <ul class="nav nav-pills pull-right">
		    <li class="active"><a href="#">Home</a></li>
		    <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Salir</a></li>
		  </ul>
		  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
		</div>
		<div class="detalleProyecto">
			<span class="titulo-ventana">Evaluadores </span>
			<div class="row-fluid">
		    	<div class="span12">
					<a class="btn btn-primary pull-right"
						href="${pageContext.request.contextPath}/resolver/evaluacion/evaluadores/form"><i
						class="icon-plus-sign icon-white"></i> Nuevo</a>
					<a class="btn btn-success nav pull-right"
						href="${pageContext.request.contextPath}/resolver/evaluacion/all"><i
						class="icon-list-alt icon-white"></i>Evaluaciones</a>
				</div>
			</div>
			<div class="control-group">												
				<section id="evaluadores">
						<div id="alert-for-delete" class="collapse">
							<div class="alert">
			       				<b>Atenci&oacuten:</b> 
			       				eliminar implica, desaparecer todos los datos capturados
			       				referente a evaluadores, como los resultados y calificaciones 
			       				de los proyectos que participaron y toda 
			       				informaci&oacuten se perder&aacute!
			       			</div>		
			       		</div>
						<c:forEach var="evaluador" items="${evaluadores}" varStatus="row">
								<div class="row-fluid">
				       				<div class="span10">
										<span><b>${evaluador.value.nombre}</b></span>
									<a data-toggle="collapse" 
										data-target="#delete-evaluador-${row.count}, #alert-for-delete"
										href="#">
						       			<i class="icon-trash"></i> eliminar
						       		</a>
						       		<div id="delete-evaluador-${row.count}" class="collapse">
										<a class="btn btn-mini btn-danger" 
											href="${pageContext.request.contextPath}/resolver/evaluacion/delete/evaluador/${evaluador.value.idEvaluador}">Aceptar</a>
										<a class="btn btn-mini btn-info" data-toggle="collapse" 
											data-target="#delete-evaluador-${row.count}, #alert-for-delete"
											href="#">Cancelar</a>
										<br/><br/>
						       		</div>

			       					<div id="demo-${row.count}" class="collapse">
										<div class="alert ">
											<div class="row-fluid">																       							
					       						<div class="span3">
													<span>Usuario:</span>
					       							<span class="label label-info">${evaluador.value.usuario}</span>
					       						</div>
					       						<div class="span3">
													<span>Password:</span>
					       							<span class="label label-info">${evaluador.value.clave}</span>
					       						</div>
					       						<div class="span3">
													<span>Especialidad:</span>
					       							<span class="label label-info">${evaluador.value.especialidad}</span>
					       						</div>
					       					</div>	
										</div>
									</div>	
				       	 		</div>
				       	 		<div class="span2">
				       	 			<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo-${row.count}">
										<i class="icon-info-sign icon-white"></i>
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