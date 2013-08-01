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
			<span class="titulo-ventana">Evaluadores </span>
			<div class="control-group">
				<div class="controls">
					<a class="btn btn-primary pull-right"
						href="${pageContext.request.contextPath}/resolver/evaluacion/evaluadores/form"><i
						class="icon-plus-sign icon-white"></i> Nuevo</a><br><br>
					<a class="btn btn-primary nav pull-right"
						href="${pageContext.request.contextPath}/resolver/evaluacion/proyecto/form"><i
						class="icon-list-alt icon-white"></i>Proyectos</a>
				</div>
			</div>
			<div class="control-group">												
				<section id="evaluadores">
					<ul class="list-group">
						<c:forEach var="evaluador" items="${evaluadores}">
							<li class="list-group-item">${evaluador.nombre} - ${evaluador.especialidad}</li>						
						</c:forEach>
					</ul>
				</section>
			</div>
		</div>
	</div>
</body>
</html>