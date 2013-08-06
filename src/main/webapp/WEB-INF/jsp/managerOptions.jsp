<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Latin1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-tooltip.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resolver/js/global"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
</head>
<body>	
		
	<div class="container" >
			<div class="masthead">
			  <ul class="nav nav-pills pull-right">
			    <li class="active"><a href="#">Home</a></li>
			    <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Salir</a></li>
			  </ul>
			  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
			</div>
			<div class="proyectoEvaluar">
				<div class="row-fluid">
				    <div class="span12 show-grid">
				    	<span class="titulo-ventana">Opciones de Resultados</span>
			       		<br/><br/>
			       		<div class="alert alert-info">
			       			Estimado manager, en esta secci&oacuten podr&aacute
			       			entrar a seleccionar el tipo de monitoreo ya sea por
			       			exposici&oacuten, por categoria y/o ranking de proyectos 
			       			por favor click en -<b>cualquiera de las opciones</b>- Gracias!
			       		</div>
		       			<br>
				    </div>
				</div> 
		        <div class="control-group">
			        <div class="row-fluid">			        	
					    <div class="span4">
							<a class="btn btn-danger btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/exposicion/${idEvalaucion}">Exposicion</a>
					    </div>
					    <div class="span4">
						 	<a class="btn btn-primary btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/categoria/${idEvalaucion}">Categoria</a>
					    </div>
					    <div class="span4">
						 	<a class="btn btn-success btn-large btn-block" href="${pageContext.request.contextPath}/resolver/manager/resultados/finales/${idEvalaucion}">Ranking</a>
					    </div>
					</div> 										
			        
		        </div>  
			</div>

	</div>
</body>
</html>