<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/datepicker/css/datepicker.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
</head>
<body>
		
	<div class="container" >
		<div class="proyectoEvaluar">
			<div class="control-group">
				<div class="row-fluid">
					<div class="span12 show-grid ">
						<h4>Alta de evaluaci&oacuten</h4>
					</div>
				</div>    
				<div class="row-fluid">
					<div class="span6">
						<label>Descripci&oacuten</label>
						<input id="descripcion" type="text"  placeholder="Descripcion...">
					</div>
					<div class="span6">
						<label>Proyectos</label>
						<select class="lista">
					  		<option>Desarrollo Web</option>
					  		<option>Escritorio</option>
					  		<option>Desarrollo M&oacutevil</option>
					  		<option>Multimedia</option>
						</select>
					</div>
				</div>    
				<div class="row-fluid">
					<div class="span6">
						<label>Fecha</label>
						<input id="fechaEvaluacion" class="input-small" type="date"  placeholder="Fecha">
						<span><i class="icon-calendar"></i></span>
					</div>
				    <div class="span6">
				        <label>Evaluador</label>
						<select class="lista">
						  <option>Desarrollo Web</option>
						  <option>Escritorio</option>
						  <option>Desarrollo M&oacutevil</option>
						  <option>Multimedia</option>
						</select>
				    </div>
				</div>
				<div class="row-fluid">
					<div class="span6">                       					
						<label>Descripci&oacuten Detallada</label>
						<textarea class="textArea" rows="2" placeholder="Descripcion detallada..."></textarea>
					</div>
					<div class="span6">                       					
						<span class="btn  btn-success fileinput-button">
							<i class="icon-file icon-white"></i>
							<span>GUARDAR</span>
						</span>
						<span class="btn btn-danger fileinput-button">
						    <span>CANCELAR</span>
						</span>
					</div>
				</div>                     
			</div>
		</div>
	</div>
</body>
</html>