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

		<div class="detalleProyecto">
			<span class="titulo-ventana">Proyectos a Evaluar</span>
			<div class="control-group">
				<div class="controls">										
					<a class="btn btn-primary pull-right"
						href="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/form"><i
						class="icon-plus-sign icon-white"></i> Nuevo</a><br><br>
					<a class="btn btn-info nav pull-right" href="${pageContext.request.contextPath}/resolver/evaluacion/all"><i class="icon-list-alt icon-white"></i>Evaluaciones</a>											
				</div>				
			</div>
			<div class="control-group">
				<section id="proyectos">

					<c:forEach var="proyecto" items="${proyectos}">
						
						<span>${proyecto.nombre}</span>
						<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#detalle-${proyecto.idProyecto}"><i class="icon-question-sign icon-white"></i></a>

						<!-- Detalles del proyecto -->
						<div id="detalle-${proyecto.idProyecto}" class="collapse">
							<div>
								<div class="row-fluid">
									<div class="span6">
										<div class="thumbnail">
											<img width="100px" height="100px" src="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/logo/${proyecto.idProyecto}" alt="${proyecto.nombre}">
											<h5>${proyecto.nombre}</h5>
										</div>
									</div>
									<div class="span6">
										<h5>Categor&iacutea.</h5>
										<span> ${proyecto.categoria.descripcion}</span>
										<h5>L&iacuteder de proyecto.</h5>
										<span> ${proyecto.responsable}</span>
									</div>
									<div class="span6">										
										<span>
											<a href="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/presentacion/${proyecto.idProyecto}" target="_blank">
												Presentaci&oacuten PDF
												<i class="icon-folder-open"></i>
											</a>
										</span>
									</div>
								</div>
							</div>
						</div>
						<!-- End Detalles del proyecto -->
						</br>
					</c:forEach>

					<!--  <span>DESARROLLO DE APLICACIONES MOBILES PARA ESTUDIANTES</span>
		       			<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#detalle"><i class="icon-question-sign icon-white"></i></a>
						-->
				</section>
			</div>
		</div>
	</div>
</body>
</html>