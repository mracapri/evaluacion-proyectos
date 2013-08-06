<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		<div class="proyectoEvaluar">
			<form id="formProyectoEvaluar" action="${pageContext.request.contextPath}/resolver/evaluador/evaluacion/rubrica/save" method="post">
				<div class="row-fluid">
				    <div class="span12 show-grid">
				    	<span class="titulo-ventana">
							<c:choose>
							    <c:when test="${tipoRubrica == 'porPresentacion'}">
							    	Evaluaci&oacuten de proyecto por presentaci&oacuten
							    </c:when>
							    <c:when test="${tipoRubrica == 'porCategoria'}">
									Evaluaci&oacuten de proyecto por categoria
							    </c:when>
							</c:choose>
				    	</span>
				    </div>
				</div> 
				<div class="row-fluid">
				    <div class="span12">
					    <table class="table table-condensed">
						    <tbody>
							    <tr>
								    <td>0 - 50</td>
								    <td>Deficiente</td>
							    </tr>
							    <tr>
								    <td>51 - 70</td>
								    <td>No aceptable</td>
							    </tr>
							    <tr>
								    <td>71 - 80</td>
								    <td>Regular</td>
							    </tr>
							    <tr>
								    <td>81 - 90</td>
								    <td>Satisfactorio</td>
							    </tr>
							    <tr>
								    <td>91 - 100</td>
								    <td>Excelente</td>
							    </tr>
						    </tbody>
					    </table>
				    </div>
				</div> 
				<div class="control-group">
					<c:forEach items="${rubrica.items}" var="itemRubrica" varStatus="row">
					<div class="row-fluid">
						<div class="span1"></div>	
					    <div class="span9">
							<div class="row">
							
								<div class="span11">
									<b>${row.count}.- </b>${itemRubrica.descripcionCorta}
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
					    <div class="span2">
						 	<select name="escala-${row.count}" class="input-mini">
								<c:forEach var="escala" begin="${itemRubrica.escala.inicio}" end="${itemRubrica.escala.fin}">
									<option value="${escala}">${escala}</option>
								</c:forEach>
						 	</select>
					    </div>
					</div> 
					</c:forEach>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<button data-toggle="collapse" data-target="#confirmacion" id="bnt-enviar-evaluacion" class="btn btn-success fileinput-button" type="button"><i class="icon-file icon-white"></i>GUARDAR</button>
						<a class="btn btn-danger fileinput-button" href="${pageContext.request.contextPath}/resolver/evaluador/proyectos"><i class="icon-file icon-white"></i>REGRESAR</a>
						
						<br/><br/>
						<div id="confirmacion" class="collapse">
							<div class="alert">
								<p class="text-info">
									Esta seguro de guardar la evaluaci&oacuten?
									<button type="submit" id="si-guardar" class="btn btn-mini btn-success" href="#">Si</button>
									<a class="btn btn-mini btn-danger" data-toggle="collapse" data-target="#confirmacion" href="#">No</a>
								</p>
							</div>
						</div>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</body>
</html>