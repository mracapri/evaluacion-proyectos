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
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/resultadoFinal.js"></script>
	
</head>
<body ng-app="myApp">
	
		<div class="container" ng-controller="MyCtrl">
			
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
						<tr ng-repeat="item in items | orderBy:predicate:reverse" fadey=1500>
							<td>
								<h3>{{$index + 1}}valor{{data.name}}</h3>
							</td>
							<td>
								<div class="fileupload-new thumbnail logo"><img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg"/></div>
							</td>
							<td >
							<span class="tdResultados ">{{item.name}}</span>
										
							</td>
							<td><h2 class="show-grid">{{item.cal}}</h2></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
</body>
</html>