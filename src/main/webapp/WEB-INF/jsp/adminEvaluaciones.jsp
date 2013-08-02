<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div class="detalleProyecto">
			<span class="titulo-ventana">Evaluaciones</span>
			<div class="control-group">
				<div class="row-fluid">
			    	<div class="span12">
						<a class="btn btn-primary nav pull-right"href="${pageContext.request.contextPath}/resolver/evaluacion/form"><i class="icon-plus-sign icon-white"></i> Nuevo</a>
					</div>  
				</div>
		       <section id="proyectos">
		       		</br>
		       		<c:forEach var="evaluacion" items="${evaluaciones}">
		       			<div class="row-fluid">
			       			<div class="span6">
				       			<span>${evaluacion.descripcion}</span>
				       	 	</div>
				       	 	<div class="span3">
				       			
					       			<a href="${pageContext.request.contextPath}/resolver/evaluacion/${evaluacion.idEvaluacion}/proyectos">
					       				<i class="icon-list-alt"></i>proyectos
					       			</a>
				       			
				       	 	</div>  
				       	 	<div class="span3">
				       		
					       			<a href="${pageContext.request.contextPath}/resolver/evaluacion/evaluadores/">
					       				<i class=" icon-user"></i>evaluadores
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