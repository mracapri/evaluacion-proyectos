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
		<div class="encabezado">
			<div class="row-fluid">
				<div class="span2">
					<div class="logoUTVM">
						<img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg" alt="">
					</div>
				</div>
				<div class="span9 show-grid">
					<h3>UNIVERSIDAD TECNOLOGICA DEL VALLE DEL MEZQUITAL</h3>
				</div>
			</div>
		</div> 
		<div class="contenedor">
			<div class="proyectoEvaluar">
				
				<div class="row-fluid">
				    <div class="span12 show-grid">
				    	<span class="titulo-ventana">Evaluaci&oacuten de Proyectos</span>	
				    </div>
				</div> 
				<div class="control-group">
					<div class="row-fluid">
	
					    <div class="span10">
					    	<b>1.-</b>
							<span>Manejo del escenario clara y conocimiento del proyecto
								<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo"><i class="icon-question-sign icon-white"></i></a>
							</span>
							<div id="demo" class="collapse">
								<div class="alert alert-info">
									<p class="text-info">Este punto califica la menera en que la persona que expone se comunica con la audiencia, asi como las gesticulaciones que realiza para convencer</p>
								</div>
							</div>	
					    </div>
					    <div class="span2">
						 	<select id="escala">
						 		<option>1</option>
						 		<option>2</option>
						 		<option>3</option>
						 	</select>
					    </div>
					</div> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>