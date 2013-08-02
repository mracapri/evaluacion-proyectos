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
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
</head>
<body>		
	<div class="container" >
		<div class="proyectoEvaluar">
			<div class="row-fluid">
			    <div class="span12 show-grid">
			    	<span class="titulo-ventana">Evaluaci&oacuten de Proyectos Categoria</span>	
			    </div>
			</div> 
			<div class="control-group">
				<div class="row-fluid">

			    	<div class="span1">
			    		<b>1.-</b>
			    	</div>
			    	
					<div class="span9">
						Implementacion de dise&ntilde;o en casacada segun lo marca la w3e y el  estandar de programadores
						
						<div id="demo" class="collapse">
							<div class="alert alert-info">
								<p class="text-info">El proyecto aplica de manera clara los conocimientos sobre modelado y va de acuerdo con su categoria</p>
							</div>
						</div>	
					</div>
					
					<div class="span1">
						<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo">
							<i class="icon-info-sign icon-white"></i>
						</a>
					</div>	
					<div class="span1">
					 	<select id="escala">
					 		<option>1</option>
					 		<option>2</option>
					 		<option>3</option>
					 	</select>
				 	</div>
				</div> 
			</div>
			<div class="row-fluid">
				<div class="span6">                       					
					<a class="btn btn-success fileinput-button" href="${pageContext.request.contextPath}/resolver/evaluacion/all"><i class="icon-file icon-white"></i>GUARDAR</a>
				</div>
			</div>  
		</div>
	</div>
</body>
</html>