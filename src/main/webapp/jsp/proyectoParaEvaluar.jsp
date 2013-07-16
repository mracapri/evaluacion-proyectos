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
		
			<div class="proyectoEvaluar">
				<h2 >Evaluacion de Proyectos</h2>
	            <div class="control-group">
		           <table class="table table-striped">
		              <thead>
		                <tr>
		                  <th>Nombre Proyecto</th>
		                  <th>Rubrica Exposición</th>
		                  <th>Rubrica categoria</th>
		                </tr>
		              </thead>
		              <tbody>
		                <tr>
		                  <td>Ejemplo proyecto a evaluar 1</td>
		                  <td><a class="btn btn-mini btn-primary" data-toggle="modal" href="#rubricaExpo"><i class="icon-comment icon-white"></i> Exposición</a></td>
		                  <td><a class="btn btn-mini btn-primary" data-toggle="modal" href="#rubricaCategoria"><i class="icon-list-alt icon-white"></i>Categoria</a></td>
		                </tr>
		             </tbody>
		            </table>
	            </div>  
	       </div>
	       
	       <div id="rubricaExpo" class="modal hide fade in" style="display: none;">
			    <div class="modal-header">
			        <a data-dismiss="modal" class="close">x</a>
			        <h3>Detalles del Proyecto</h3>
			     </div>
			     
			     <div class="modal-body">
			       <div class="row-fluid">
			          <div class="span1">
						<label>1</label>
			          </div>
			          <div class="span9">
			          	 <span>Ejemplo de Proyecto
						 	<i class="icon-question-sign" data-toggle="tooltip" data-placement="top" title="" data-original-title="Tooltip on top"></i>							  
						 </span>
			          </div>
			          <div class="span2">
					  	<select id="escala">
					  		<option>1</option>
					  		<option>2</option>
					  		<option>3</option>
					  	</select>
			          </div>
			       </div>           
			    </div>
			    
			    <div class="modal-footer">
			        <a href="#" data-dismiss="modal" class="btn">Cerrar</a>
			    </div>
			</div>
			
			
			<div id="rubricaCategoria" class="modal hide fade in" style="display: none;">
			    <div class="modal-header">
			        <a data-dismiss="modal" class="close">ï¿½</a>
			        <h3>Nuevo Proyecto</h3>
			     </div>
			     
			   <div class="modal-body">
			       <div class="row-fluid">
			          <div class="span1">
						<label>1</label>
			          </div>
			          <div class="span9">
			          	 <span>Ejemplo de Proyecto
						 	<i class="icon-question-sign" data-toggle="tooltip" data-placement="top" title="" data-original-title="Tooltip on top"></i>							  
						 </span>
			          </div>
			          <div class="span2">
					  	<select id="escala">
					  		<option>1</option>
					  		<option>2</option>
					  		<option>3</option>
					  	</select>
			          </div>
			       </div>           
			    </div>
			    
			    <div class="modal-footer">
			        <a href="index.html" class="btn btn-success">Guardar</a>
			        <a href="#" data-dismiss="modal" class="btn">Cerrar</a>
			    </div>
			</div>
		
	</div>
</body>
</html>