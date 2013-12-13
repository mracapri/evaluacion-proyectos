<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web-resources/angular/js/angular.js"></script>
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
		<div class="detalleProyecto">
			<span class="titulo-ventana">Categorias</span>
			<div class="control-group">
				<div class="row-fluid">
			    	<div class="span12">
						<a class="btn btn-primary nav pull-right" 
							href="${pageContext.request.contextPath}/resolver/evaluacion/all"> 
							Regresar
						</a>
						<a class="btn btn-primary nav pull-right" 
							href="${pageContext.request.contextPath}/resolver/categoria/new">
							<i class="icon-plus-sign icon-white"></i> 
							Nueva
						</a>
					</div>  
				</div>
		       <section id="proyectos">
		       
		       		<c:if test="${mensajeError != null}">
					    <div class="alert">
					    	<button type="button" class="close" data-dismiss="alert">&times;</button>
					    	<strong>Atenci&oacuten!</strong> ${mensajeError} 
					    </div>
		       		</c:if>
		       
		       		<c:forEach var="categoria" items="${categorias}" varStatus="row">
		       			<div class="row-fluid">
			       			<div class="span12">
				       			<span class="label-info-col">
				       				<b>${categoria.descripcion}</b>
				       			</span>
				       			
			       				<span style="font-size: 12px;">
			       					<fmt:formatDate pattern="yyyy-MM-dd" value="${categoria.fechaCreacion}"/>
			       				</span>
			       				
								<a data-toggle="collapse" 
									data-target="#delete-evaluacion-${row.count}, #alert-for-delete"
									href="#">
					       			<i class="icon-trash"></i> eliminar
					       		</a>
								<a href="${pageContext.request.contextPath}/resolver/categoria/modify/${categoria.idCategoria}">
					       			<i class="icon-trash"></i> modificar
					       		</a>
					       		
					       		<div id="delete-evaluacion-${row.count}" class="collapse">
									<a class="btn btn-mini btn-danger" 
										href="${pageContext.request.contextPath}/resolver/categoria/delete/${categoria.idCategoria}">Aceptar</a>
										
									<a class="btn btn-mini btn-info" data-toggle="collapse" 
										data-target="#delete-evaluacion-${row.count}, #alert-for-delete"
										href="#">Cancelar</a>
					       		</div>
				       	 	</div>
						</div> 
		       		</c:forEach>
		       </section>
			</div>
	   </div>
	</div>
</body>
</html>