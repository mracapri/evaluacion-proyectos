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
				<h2 >Proyectos a Evaluar</h2>
				<div class="control-group">
					<div class="controls">
						<a class="btn btn-primary nav pull-right" data-toggle="modal" href="#nuevoProyecto"><i class="icon-plus-sign icon-white"></i> Nuevo</a>
					</div>
	            </div>
	            <div class="control-group">
		            <section id="proyectos">
		            	<ul class="the-icons clearfix" id="lstProyectos">
		            		<li>
		            			Ejemplo de Proyecto 1
							</li>
		            	</ul>
		            </section>
	            </div>  
	       </div>
	       
	       <div id="detalle" class="modal hide fade in" style="display: none;">
			    <div class="modal-header">
			        <a data-dismiss="modal" class="close">x</a>
			        <h3>Detalles del Proyecto</h3>
			     </div>
			     
			     <div class="modal-body">
			       <div class="row-fluid">
			            <div class="span6">
			              	<div class="thumbnail">
						      <img src="${pageContext.request.contextPath}/web-resources/img/logo.jpg" alt="">
						      <h5>Proyecto de desarrollo de software a evaluar X</h5>
						    </div>
			            </div>
			            <div class="span6">
							<h5>Categor�a.</h5>
							<span> Desarrollo de aplicaciones m�viles</span>
							<h5>L�der de proyecto.</h5>
							<span> Juan Alonso Mendoza Aguilar</span>
			            </div>
						<div class="span6">
							<h5>Descripci�n.</h5>
							<p>
							 	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae mi lectus.
							 	Fusce eu faucibus libero, sit amet auctor lacus. Praesent nec hendrerit sapien, 
							 	ac consectetur augue. Praesent sit amet cursus lacus.
							 </p>
							 <span><a href="#">Presentaci�n PDF<i class="icon-folder-open"></i></a></span>
						</div>
			       </div>           
			    </div>
			    
			    <div class="modal-footer">
			        <a href="#" data-dismiss="modal" class="btn">Cerrar</a>
			    </div>
			</div>
			
			
			<div id="nuevoProyecto" class="modal hide fade in" style="display: none;">
			    <div class="modal-header">
			        <a data-dismiss="modal" class="close">�</a>
			        <h3>Nuevo Proyecto</h3>
			     </div>
			     
			     <div class="modal-body">
			       <div class="row-fluid">
			            <div class="span6">
							<label>
								Nombre del Proyecto
							</label>
							
							<input id="surname" type="text"  placeholder="Nombre del Proyecto">
			            </div>
			            <div class="span6">
			            	
			            	<div class="fileupload fileupload-new" data-provides="fileupload">
							  <div class="fileupload-new thumbnail" style="width: 50px; height: 50px;"><img src="http://www.placehold.it/50x50/EFEFEF/AAAAAA" /></div>
							  <div class="fileupload-preview fileupload-exists thumbnail" style="width: 50px; height: 50px;"></div>
							  <span class="btn btn-file"><span class="fileupload-new"><i  class=" icon-picture"></i>Logo</span><span class="fileupload-exists">Cambiar</span><input type="file" /></span>
							  <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Eliminar</a>
							</div>
			            	
			            </div>
			        </div>    
			        <div class="row-fluid">
			            <div class="span6">
							<label>Lider de Proyecto</label>
							<input id="liderProyecto" type="text"  placeholder="Lider de proyecto">
			            </div>
			            <div class="span6">
			                <label>Categor�a</label>
							<select>
							  <option>Desarrollo Web</option>
							  <option>Escritorio</option>
							  <option>Desarrollo M�vil</option>
							  <option>Multimedia</option>
							</select>
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
			            	<label>Descripci�n</label>
							<textarea rows="2"></textarea>
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