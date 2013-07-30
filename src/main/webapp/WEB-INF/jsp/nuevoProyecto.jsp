<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
</head>
<body>		
	<div class="container" > 
		<div class="detalleProyecto">
			<h2>Nuevo proyecto a evaluar</h2>			
			<form:form method="post" modelAttribute="formProyecto">
				<div class="control-group">
					<div class="row-fluid">
						<div class="span6">
							<label>Nombre del Proyecto</label>
							<form:input path="nombre" placeholder="Nombre del Proyecto"/>
							<!-- <input id="surname" type="text"  placeholder="Nombre del Proyecto"> -->
						</div>
						<div class="span6">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail" style="width: 50px; height: 50px;"><img src="http://www.placehold.it/50x50/EFEFEF/AAAAAA" /></div>
								<div class="fileupload-preview fileupload-exists thumbnail" style="width: 50px; height: 50px;"></div>
								<span class="btn btn-file"><span class="fileupload-new"><i  class=" icon-picture"></i>Logo</span><span class="fileupload-exists">Cambiar</span><input type="file"  name="logo" /></span>
								<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Eliminar</a>
							</div>
					    </div>
					</div>    
					<div class="row-fluid">
						<div class="span6">
							<label>Lider de Proyecto</label>
							<form:input path="lider" placeholder="Lider de proyecto"/>
							<!-- <input id="liderProyecto" type="text"  placeholder="Lider de proyecto"> -->
						</div>
						<div class="span6">
							<label>Categor&iacutea</label>
								<form:select path="idCategoria">								
									<form:options items="${categorias}" itemLabel="descripcion"/>									
								</form:select>							
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<label>Integrantes</label>
						   	<input id="integrantes" type="text"  placeholder="Integrantes">   					
							<span class="btn  btn-success fileinput-button">
						    	<i class="icon-file icon-white"></i>
						        <span>Add PDF...</span>
						     </span>
						     <span class="btn btn-primary fileinput-button">
						         <i class="icon-plus icon-white"></i>
						         <span>Fotos...</span>
						     </span>
						</div>
						<div class="span6">
							<label>Descripci&oacuten</label>
							<form:textarea path="descripcion" rows="2" class="textArea"/>							
						</div>
					</div> 
				</div>
				<div>
					<button class="btn succes" type="submit">Guardar</button>
				</div>
			</form:form>	           
		</div>
	</div>
</body>
</html>