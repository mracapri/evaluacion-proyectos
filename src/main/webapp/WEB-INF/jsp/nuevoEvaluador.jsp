<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div class="proyectoEvaluar">
			<div class="control-group">
				<form:form method="post" modelAttribute="formEvaluador">
					<c:if test="${message != null}">
						<div class="alert alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>							
							<p>${message}</p>
						</div>
					</c:if>	
				
					<div class="row-fluid">
						<div class="span12 show-grid ">
							<h4>Alta de evaluador</h4>
						</div>
					</div>    
					<div class="row-fluid">
						<div class="span6">
							<label>Nombre</label>
							<spring:hasBindErrors name="formEvaluador">								
								<span class="label label-info">
									<form:errors path="nombre" />
								</span>
							</spring:hasBindErrors>
							<form:input path="nombre" placeholder="Nombre..."/>							
						</div>
						<div class="span6">
							<label>Especialidad</label>
							<spring:hasBindErrors name="formEvaluador">								
								<span class="label label-info">
									<form:errors path="especialidad" />
								</span>
							</spring:hasBindErrors>
							<form:input path="especialidad" placeholder="Descripcion..."/>							
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<br>
							<label>Usuario</label>
							<spring:hasBindErrors name="formEvaluador">								
								<span class="label label-info">
									<form:errors path="usuario" />
								</span>
							</spring:hasBindErrors>
							<form:input path="usuario" placeholder="Usuario..."/>							
						</div>
						<div class="span6">
							<br>
							<label>Password</label>
							<spring:hasBindErrors name="formEvaluador">								
								<span class="label label-info">
									<form:errors path="password" />
								</span>
							</spring:hasBindErrors>
							<form:password path="password" placeholder="Descripcion..."/>							
						</div>
					</div>    				
					<div class="row-fluid">
						<div class="span12" style="text-align:center; margin-top:2em">                       	
							<button class="btn btn-success fileinput-button" type="submit"><i class="icon-file icon-white"></i>Guardar</button>							
							<a class="btn btn-danger fileinput-button" href="${pageContext.request.contextPath}/resolver/evaluacion/evaluadores">CANCELAR</a>							
						</div>
					</div> 
				 </form:form>                   
			</div>
		</div>
	</div>
</body>
</html>