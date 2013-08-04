<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		    <li><a href="#">Salir</a></li>
		  </ul>
		  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
		</div>
		<div class="detalleProyecto">
			<span class="titulo-ventana">Proyectos a Evaluar</span>
			<div class="control-group">
				<div class="controls">
				<div class="row-fluid">
			    	<div class="span12">										
						<a class="btn btn-primary pull-right"
							href="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/form"><i
							class="icon-plus-sign icon-white"></i> Nuevo </a> 
						
						<a class="btn btn-success nav pull-right"
							href="${pageContext.request.contextPath}/resolver/evaluacion/all"><i
							class="icon-list-alt icon-white"></i>Evaluaciones</a>
						</div>
				</div>				
			</div>
			<div class="control-group">
				<section id="proyectos">

					<c:forEach var="proyecto" items="${proyectos}">
						<div class="row-fluid">
			    			<div class="span11">
								<span>${proyecto.value.nombre}</span>
							</div>
							<div class="span1">
								<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#detalle-${proyecto.value.idProyecto}"><i class="icon-question-sign icon-white"></i></a>
							</div>
						</div>
						
						<!-- Detalles del proyecto -->
						<div id="detalle-${proyecto.value.idProyecto}" class="collapse">
							<div>
								<div class="row-fluid">
									<div class="span6">
										<div class="thumbnail">
											<img width="100px" height="100px" src="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/logo/${proyecto.value.idProyecto}" alt="${proyecto.value.nombre}">
											<h5>${proyecto.value.nombre}</h5>
										</div>
									</div>
									<div class="span6">
										<h5>Categor&iacutea.</h5>
										<span> ${proyecto.value.categoria.descripcion}</span>
										<h5>L&iacuteder de proyecto.</h5>
										<span> ${proyecto.value.responsable}</span>
											<div>										
												<a href="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/presentacion/${proyecto.value.idProyecto}" target="_blank">
													Presentaci&oacuten PDF
													<i class="icon-folder-open"></i>
												</a>
											</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Detalles del proyecto -->
						
					</c:forEach>
				</section>
			</div>
		</div>
	</div>
</body>
</html>