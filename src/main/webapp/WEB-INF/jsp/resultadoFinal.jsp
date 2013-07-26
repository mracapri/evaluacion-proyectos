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
			
		<div class="contenedor">
			<div class="row-fluid">
				<div class="span12 show-grid">
					<h2>TABLA DE POSICIONES</h2>
				</div>
			</div> 
			<div class="control-group">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th><h3>POSICION</h3></th>
							<th><h3>LOGO</h3></th>
							<th><h3>PROYECTO</h3></th>
							<th><h3>PUNTAJE</h3></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<h3>1</h3>
							</td>
							<td>
								<div class="fileupload-new thumbnail logo"><img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg"/></div>
							</td>
							<td><span class="tdResultados">DESARROLLO DE APLICACIONES MOBILES PARA ESTUDIANTES</span></td>
							<td><h2>9</h2></td>
						</tr>
						<tr>
							<td>
								<h3>2</h3>
							</td>
							<td>
								<div class="fileupload-new thumbnail logo"><img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg"/></div>
							</td>
							<td><span class="tdResultados">DESARROLLO DE MODULOS DE TURISMO PARA EL VALLE DEL MEZQUITAL</span></td>
							<td><h2>10</h2></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
</body>
</html>