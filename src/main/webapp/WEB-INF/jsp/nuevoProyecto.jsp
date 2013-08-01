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
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet"/>
	<link media="screen" type="text/css" href="${pageContext.request.contextPath}/web-resources/css/application.css" rel="stylesheet"/>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-collapse.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/js/application.js"></script>
</head>
<body>		
	<div class="container" > 
		<div class="detalleProyecto">
			<h2>Nuevo proyecto a evaluar</h2>			
			<form:form method="post" modelAttribute="formProyecto" enctype="multipart/form-data">
				<c:if test="${message != null}">
					<div class="alert alert-success">
						<button type="button" class="close" data-dismiss="alert">&times;</button>							
						<p>${message}</p>
					</div>
				</c:if>	
				<div class="control-group">
					<div class="row-fluid">
						<div class="span6">
							<label>Nombre del Proyecto</label>
							<spring:hasBindErrors name="formProyecto">								
								<span class="label label-info">
									<form:errors path="nombre" />
								</span>
							</spring:hasBindErrors>
							<form:input path="nombre" placeholder="Nombre del Proyecto"/>														
						</div>
						<div class="span6">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail" style="width: 50px; height: 50px;"><img src="${pageContext.request.contextPath}/web-resources/img/cincuenta.gif" /></div>
								<div class="fileupload-preview fileupload-exists thumbnail" style="width: 50px; height: 50px;"></div>
								<span class="btn btn-file"><span class="fileupload-new"><i  class=" icon-picture"></i>Logo</span><span class="fileupload-exists">Cambiar</span>
									<form:input type="file" path="logo"/>									
								</span>
								<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Eliminar</a>
							</div>
					    </div>
					</div>    
					<div class="row-fluid">
						<div class="span6">
							<label>Lider de Proyecto</label>
							<spring:hasBindErrors name="formProyecto">								
								<span class="label label-info">
									<form:errors path="lider" />
								</span>
							</spring:hasBindErrors>
							<form:input path="lider" placeholder="Lider de proyecto"/><br>															
						</div>
						<div class="span6">
							<label>Categor&iacutea</label>
							<spring:hasBindErrors name="formProyecto">								
								<span class="label label-info">
									<form:errors path="idCategoria" />
								</span>
							</spring:hasBindErrors>
								<form:select path="idCategoria" cssClass="lista">
									<form:option value="0">Selecciona una opcion...</form:option>								
									<form:options items="${categorias}" itemLabel="descripcion" />									
								</form:select>																
						</div>
					</div>

					<div class="row-fluid">
						<div class="span6">
							<label>Integrantes</label>
							<spring:hasBindErrors name="formProyecto">								
								<span class="label label-info">
									<form:errors path="integrantes" />
								</span>
							</spring:hasBindErrors>
							<form:input path="integrantes" placeholder="Integrantes"/><br>					   								
						</div>
						<div class="span6">	
							<div class="form-group">
									<label>
									 Exposicion por:
									</label>
									<label class="checkbox-inline">
									  <form:checkbox value="1" path="noPresentacion"/> Presentaci&oacuten									  
									</label>
									<label class="checkbox-inline">
									  <form:checkbox value="2" path="noCategoria"/> Categoria									  
									</label>
							</div>						
						</div>
					</div>
					<div class="row-fluid">
					   <div class="span6">
							<div class="fileupload fileupload-new " data-provides="fileupload">
								  <div class="input-append lista">
									    <div class="uneditable-input span3 lista">
									    	<i class="icon-file fileupload-exists"></i> 
									    	<span class="fileupload-preview"></span>
									    </div>
								  </div>
								  <span class="btn btn-file">
							    		<i class="icon-file"></i>
							    		<span class="fileupload-new">A. Presentaci&oacuten</span>
							    		<span class="fileupload-exists">Cambiar</span>
							    		<form:input type="file" path="filePdf"/>							    		
							    	</span>
							    	
								    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Eliminar</a>
							</div>
						</div>
						<div class="span6">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail" style="width: 50px; height: 50px;"><img src="${pageContext.request.contextPath}/web-resources/img/cincuenta.gif" /></div>
								<div class="fileupload-preview fileupload-exists thumbnail" style="width: 50px; height: 50px;"></div>
								<span class="btn btn-file"><span class="fileupload-new"><i  class=" icon-picture"></i>Foto del Equipo</span><span class="fileupload-exists">Cambiar</span>
									<form:input type="file" path="fotoEquipo"/>									
								</span>
								<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Eliminar</a>
							 </div>
						</div>
						
					</div> 
					
					<div class="row-fluid">						
						<div class="span12" style="text-align:center; margin-top:2em">
							<button class="btn btn-success" type="submit">Guardar</button>	
							<a class="btn btn-danger" href="${pageContext.request.contextPath}/resolver/evaluacion/${evaluacion.idEvaluacion}/proyectos">CANCELAR</a>			
						</div>
					</div> 					
				</div>
			</form:form>	           
		</div>
	</div>
</body>
</html>