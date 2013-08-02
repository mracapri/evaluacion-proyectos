<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-tooltip.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
</head>
<body>		
	<div class="container" >


			<div class="proyectoEvaluar">
				<div class="row-fluid">
				    <div class="span12 show-grid">
				    	<span class="titulo-ventana">Evaluaci&oacuten de Proyectos</span>
				    </div>
				</div> 
		        <div class="control-group">
			        <div class="row-fluid">
					    <div class="span8">
							<h5 class="hidden-phone">
								Nombre de proyecto
							</h5>
					    </div>
					    <div class="span2">
						 	<h5 class="hidden-phone">
								Rubrica Exposicion
							</h5>
					    </div>
					    <div class="span2">
						 	<h5 class="hidden-phone">
								Rubrica Categoria
							</h5>
					    </div>
					</div> 
					<c:forEach var="proyecto" items="${evaluacion.proyectos}" varStatus="row">
						<div class="row-fluid  show-grid">
						    <div class="span8">
								<b>${row.count}</b>
								<span>
									${proyecto.value.nombre}
								</span>
						    </div>
						    <div class="span2">
								<a class="btn btn-mini btn-primary"  href="${pageContext.request.contextPath}/resolver/evaluador/evaluacion/mostrar/rubrica/categoria/${proyecto.value.idProyecto}"><i class="icon-comment icon-white"></i> Exposición</a>
				               	
						    </div>
						    <div class="span2">
								<a class="btn btn-mini btn-primary"href="${pageContext.request.contextPath}/jsp/rubricaCategoria.jsp"><i class="icon-list-alt icon-white"></i>Categoria</a>
						    </div>
						</div> 
					</c:forEach>
			        
		        </div>  
			</div>

	</div>
</body>
</html>