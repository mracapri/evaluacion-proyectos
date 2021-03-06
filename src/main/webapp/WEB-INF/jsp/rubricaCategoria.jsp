<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Latin1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-collapse.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
	
</head>
<body>		
	<div class="container" >
	<!-- Encabezado menu Logout -->
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
			    	<span class="titulo-ventana">Evaluaci&oacuten de Proyectos Categoria</span>	
			    </div>
			</div> 

			<!--<div class="control-group">
				<div class="row-fluid">

			    	<div class="span1">
			    		<b>1.-</b>
			    	</div>
			    	
					<div class="span9">
						Implementacion de dise&ntilde;o en casacada segun lo marca la w3e y el  estandar de programadores
						
						<div id="demo" class="collapse">-->
			
			
			<div class="control-group">											
				<c:forEach items="${rubrica.items}" var="itemRubrica" varStatus="row">
				<div class="row-fluid">	
				    <div class="span10">
						<div class="row">
					    	<div class="span1">
					    		<b>${row.count}</b>
					    	</div>
					    	
							<div class="span10">
								${itemRubrica.descripcionCorta}
							</div>
							
							<div class="span1">
								<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo-${itemRubrica.idItemRubrica}">
									<i class="icon-question-sign icon-white"></i>
								</a>
							</div>	
													
						</div>
						<div id="demo-${itemRubrica.idItemRubrica}" class="collapse">

							<div class="alert alert-info">
								<p class="text-info">
									${itemRubrica.descripcionLarga}
								</p>
							</div>
						</div>	

					</div>
					
					<!--  <div class="span1">
						<a class="btn btn-mini btn-info" data-toggle="collapse" data-target="#demo">
							<i class="icon-info-sign icon-white"></i>
						</a>
					</div>
					<div class="span1">
					 	<select id="escala">

				    </div>-->	
				    <div class="span2">
					 	<select id="escala-${itemRubrica.idItemRubrica}">
					 		<option>1</option>
					 		<option>2</option>
					 		<option>3</option>
					 	</select>
				 	</div>
				</div> 
				</c:forEach>
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