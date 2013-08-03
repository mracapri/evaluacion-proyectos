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
						<c:forEach var="evaluador" items="${evaluadores}">
							<div class="row-fluid">
			       				<div class="span10">
			       					<b>${evaluador.nombre}</b>
			       					<div id="demo" class="collapse">
										<div class="alert ">
											<div class="row-fluid">
				       							<div class="span5">
													<span>Especialidad:</span>
					       							<span class="label label-info">${evaluador.especialidad}</span>
					       						</div>
					       						<div class="span5">
													<span>Password:</span>
					       							<span class="label label-info">${evaluador.clave}</span>
					       						</div>
					       					</div>	
										</div>
									</div>	
				       	 		</div>
				       	 		<div class="span2">
				       	 			<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo">
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