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
				<span class="titulo-ventana">Proyectos a Evaluar</span>
				<div class="control-group">
					<div class="controls">
						<a class="btn btn-primary nav pull-right"href="${pageContext.request.contextPath}/jsp/nuevoProyecto.jsp"><i class="icon-plus-sign icon-white"></i> Nuevo</a>
					</div>
				</div>
				<div class="control-group">
			       <section id="proyectos">

		       			<span>DESARROLLO DE APLICACIONES MOBILES PARA ESTUDIANTES</span>
		       			<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#detalle"><i class="icon-question-sign icon-white"></i></a>
					
			       </section>
				</div>
				
				<div id="detalle" class="collapse">
				     <div >
				       <div class="row-fluid">
				            <div class="span6">
				              	<div class="thumbnail">
							      <img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg" alt="">
							      <h5>Proyecto de desarrollo de software a evaluar X</h5>
							    </div>
				            </div>
				            <div class="span6">
								<h5>Categor&iacutea.</h5>
								<span> Desarrollo de aplicaciones m&oacuteviles</span>
								<h5>L&iacuteder de proyecto.</h5>
								<span> Juan Alonso Mendoza Aguilar</span>
				            </div>
							<div class="span6">
								<h5>Descripci&oacuten.</h5>
								<p>
								 	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae mi lectus.
								 	Fusce eu faucibus libero, sit amet auctor lacus. Praesent nec hendrerit sapien, 
								 	ac consectetur augue. Praesent sit amet cursus lacus.
								 </p>
								 <span><a href="#">Presentaci&oacuten PDF<i class="icon-folder-open"></i></a></span>
							</div>
				       </div>           
				    </div>
				</div>
		             
		    </div>
	</div>
</body>
</html>