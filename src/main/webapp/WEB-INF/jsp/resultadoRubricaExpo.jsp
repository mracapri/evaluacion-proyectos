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
			<a data-toggle="collapse" data-target="#activarProyecto"><i class=" icon-chevron-down"></i></a>
			<div id="activarProyecto" class="row  collapse">
				<div  class="span12">
					<select>
						<option>Proyecto de evaluacion</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<h3>DESARROLLO DE APLICACIONES MOBILES PARA ESTUDIANTES</h3>
				</div>
			</div>
			<div class="control-group">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th><h3>Nombre del Evaluador</h3></th>
							<th><h3>Criterio 1</h3></th>
							<th><h3>Criterio 2</h3></th>
							<th><h3>Criterio 3</h3></th>
							<th><h3>Criterio 4</h3></th>
							<th><h3>Criterio 5</h3></th>
							<th><h3>Total</h3></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span class="tdResultados">MARIA LEDESMA VALERA</span></td>
							<td><span class="tdResultados">8</span></td>
							<td><span class="tdResultados">9</span></td>
							<td><span class="tdResultados">10</span></td>
							<td><span class="tdResultados">9</span></td>
							<td><span class="tdResultados">10</span></td>
							<td><span class="tdResultados">9.5</span></td>
						</tr>
						<tr>
							<td><span class="tdResultados">JOSE DE JESUS VELASQUEZ AGUILAR</span></td>
							<td><span class="tdResultados">8</span></td>
							<td><span class="tdResultados">9</span></td>
							<td><span class="tdResultados">10</span></td>
							<td><span class="tdResultados">9</span></td>
							<td><span class="tdResultados">10</span></td>
							<td><span class="tdResultados">9.5</span></td>
						</tr>
						<tr>
							<td colspan="6"><h3>CALIFICACI&OacuteN TOTAL</h3></td>
							<td><h3>9.5</h3></td>
						</tr>
					</tbody>
				</table>            
			</div>
		</div>
		
	</div>
</body>
</html>