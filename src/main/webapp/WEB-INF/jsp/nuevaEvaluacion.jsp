<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<!-- Encabezado menu Logout -->
		<div class="masthead">
		  <ul class="nav nav-pills pull-right">
		    <li class="active"><a href="#">Home</a></li>
		    <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Salir</a></li>
		  </ul>
		  <h3 class="muted">Evaluaci&oacuten de proyectos</h3>
		</div>
		<div class="proyectoEvaluar">
			<div class="control-group">
				<form:form method="post" modelAttribute="formEvaluacion">												
																			
					<div class="row-fluid">
						<div class="span12 show-grid ">
							<h4>Alta de evaluaci&oacuten</h4>
						</div>
					</div>    
					<div class="row-fluid">
						<div class="span6">
							<label>Descripci&oacuten</label>
							<spring:hasBindErrors name="formEvaluacion">								
								<span class="label label-info">
									<form:errors path="descripcion" />
								</span>
							</spring:hasBindErrors>
							<form:input path="descripcion" placeholder="Descripcion..."/>													
						</div>
						 <div class="span6">	
							<div class="form-group">
									<label>
									 Exposicion por:
									</label>									
									<label class="checkbox-inline">
									  <form:radiobutton value="1" path="exposicion_por"/> Presentaci&oacuten									  
									</label>
									<label class="checkbox-inline">
									  <form:radiobutton value="2" path="exposicion_por"/> Categoria									  
									</label>
									<label class="checkbox-inline">
									  <form:radiobutton value="3" path="exposicion_por"/> Ambos									  
									</label>
									<spring:hasBindErrors name="formEvaluacion">								
										<span class="label label-info">
											<form:errors path="exposicion_por" />
										</span>
									</spring:hasBindErrors>
							</div>						
						</div>
					</div>   					
					<div class="row-fluid">
						<div class="span6">                       					
							<label>Descripci&oacuten Detallada</label>
							<spring:hasBindErrors name="formEvaluacion">
								<span class="label label-info">
									<form:errors path="descripcionDetallada" />
								</span>
							</spring:hasBindErrors>	
							<form:textarea path="descripcionDetallada" class="textArea" rows="2" placeholder="Descripcion detallada..."/>													
						</div>
						<div class="span6">
							<button class="btn btn-success fileinput-button" type="submit"><i class="icon-file icon-white"></i>GUARDAR</button>                       																	
							<a class="btn btn-danger fileinput-button" href="${pageContext.request.contextPath}/resolver/evaluacion/all">CANCELAR</a>							
						</div>
					</div> 
				</form:form>					                   
			</div>
		</div>
	</div>
</body>
</html>