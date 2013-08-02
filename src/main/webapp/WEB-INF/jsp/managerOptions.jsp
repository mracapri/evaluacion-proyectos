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
				    	<span class="titulo-ventana">Opciones de Resultados</span>
				    </div>
				</div> 
		        <div class="control-group">
			        <div class="row-fluid">			        	
					    <div class="span4">
							<a class="btn btn-danger btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/exposicion">Exposicion</a>
					    </div>
					    <div class="span4">
						 	<a class="btn btn-primary btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/categoria">Categoria</a>
					    </div>
					    <div class="span4">
						 	<a class="btn btn-success btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/finales">Ranking</a>
					    </div>
					</div> 										
			        
		        </div>  
			</div>

	</div>
</body>
</html>