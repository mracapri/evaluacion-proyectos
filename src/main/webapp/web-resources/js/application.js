var DEMO = {
		//declaracion de variables globales
		i:0,		
		idEvalucacionEncabezado:self.location.href.match( /\/([^/]+)$/ )[1],
		rubricaCategoria:'',
	main : function(){
		this.init();
		//carga el primer block de la animacion categoria
		$(".slider .block:first").fadeIn(3000);
	},
	init: function(){
		$this = this;
		var nombrePagina = self.location.href.split("/")[7];
		switch (nombrePagina){
			case 'categoria':
				$this.updateResultadosCategoria();
				$this.changeSlider();
				$this.controlDeTiempo();
				break;
			case 'exposicion':
				$this.cargaTablaResultadosPresentacion();
				break;
			case 'finales':
				$this.cargaTablaRankinPosiciones();
				setInterval(function(){	
					$this.cargaTablaRankinPosiciones();
				}, 9000);
				break;
			default:
				$this.formsFunction();
				break;
		}
				
	},
	
	//Carga tablas resultados rubrica categoria
	cargaTablaResultadosCategoria: function (){
		$.ajax({
			type: "GET",
			dataType: "JSON",
			url:URL_APP_SERVICE + "/manager/resultados-categoria/"+$this.idEvalucacionEncabezado+".json",
			success: function(data){
				htmll='';
				$.each(data.proyectos, function (key, value) {
					htmll=htmll+'<article class="block"><div class="row"><div class="span12"><h1>'+value.nombre+'</h1></div></div>';
					htmll=htmll+'<table class="table table-bordered table-striped"><thead>';
					htmll=htmll+'<tr><th rowspan="2"><h1>Nombre del Evaluador</h1></th><th colspan="5"><h1>Criterios</h1></th><th rowspan="2"><h1>Total</h1></th></tr>';
				
					htmll=htmll+'<tr><th><h1>1</h1></th><th><h1>2</h1></th>';
					htmll=htmll+'<th><h1> 3 </h1></th><th><h1> 4 </h1></th><th><h1> 5 </h1></th>';
					htmll=htmll+'</tr></thead><tbody>';					
						 $.each(value.resultado, function (llave, valor) {
							 $.each(valor, function (cle, val) {								 
								 var rubricaCategoria= val.rubrica.categoria;
								 if (rubricaCategoria != undefined){
									
									 htmll=htmll+'<tr><td><span class="tdResultados">'+val.evaluador.nombre+'</span></td>';
									 
									 $.each(val.resultadoPorItem, function (llave, valoritem) { 										
	   									 htmll=htmll+'<td><span class="tdResultados">'+valoritem+'</span></td>';							 
	   			   					});									 
									htmll=htmll+'<td><span class="tdResultados">'+val.totalRubrica+'</span></td></tr>';
								 }
	
		  					});
							 
						 });
						 
						 htmll=htmll+'<tr><td colspan="6"><h3>CALIFICACI&OacuteN TOTAL</h3></td><td><h3>'+value.resultado.calificacionPorCategoria+'</h3></td>';
						 htmll=htmll+'</tr></tbody></table></article>';
							
						 $("#seccion1").html(htmll);
					});
				
					$(".slider .block:first").fadeIn(3000);
			}
			 
		});					
	},
	
	//**********************************Carga Ranking de posiciones**********************************************////
	cargaTablaRankinPosiciones: function (){
	
			htmll='';
			$.ajax({
				type: "GET",
				dataType: "JSON",
				url:URL_APP_SERVICE + "/manager/resultados-ranking/"+$this.idEvalucacionEncabezado+".json",
				success: function(data){								
					htmll=htmll+'<table class="table table-bordered table-striped">'+
					'<thead><tr><th><h3>POSICION</h3></th><th><h3>LOGO</h3></th><th><h3>PROYECTO</h3></th><th><h3>PUNTAJE</h3></th>'+
					'</tr></thead>';
					var posicion = 0;
					$.each(data, function (key, value) {
						posicion = key + 1;
						// Obtengo el nombre
						htmll = htmll + '<tbody><tr><td>'+posicion+'</td>';
						htmll=htmll+'<td><div class="logo"><img src="'+URL_APP_SERVICE+'/evaluacion/proyecto/logo/'+value.idProyecto+'" width /></div></td>';
						htmll = htmll + '<td>' + value.nombre + '</td><td><h3>'+value.resultado.calificacionGlobal.toFixed(2)+'</h3></td></tr></tbody>';
					});
					$("#divtablaResulFinal").html(htmll+'</table>');													
				}				
			});	

	},//*Fin ranking de posiciones****//
	
	
	//********************************** Carga datos de la tabla de resultados por Presentacion ***********************************************************/
	cargaTablaResultadosPresentacion: function (){
	
		$("#listProyectos").live('change', function(){
			 $("table#tablaResulExpo td").remove();
			 $('#showProyectos').trigger('click');
		 
			var idProyecto= $("#listProyectos option:selected").val();
			/*carga de JSON a tabla resultados proyectos presentacion*/ 
			 htmll='';
			$.ajax({
				type: "GET",
				dataType: "JSON",
				url:URL_APP_SERVICE + "/manager/resultados-categoria/"+$this.idEvalucacionEncabezado+".json",
				success: function(data){
					htmll='';
					$.each(data.proyectos, function (key, value) {	
						
						if(idProyecto==value.idProyecto){
								$("#nombreProyecto").text("");
								$("#nombreProyecto").html('<h3>'+value.nombre+'</h3>');
								 $.each(value.resultado, function (llave, valor) {
									 $.each(valor, function (cle, val) {
										 var rubricaPresentacion= val.rubrica.categoria; 												 
										 if (rubricaPresentacion == undefined){
											 
											 htmll=htmll+'<tr><td><span class="tdResultados">'+val.evaluador.nombre+'</span></td>';
											 
											 $.each(val.resultadoPorItem, function (llav, vale) { //entra calificacion evaluadores
			   									 htmll=htmll+'<td><span class="tdResultados">'+vale+'</span></td>';							 
			   			   					 });
											 htmll=htmll+'<td><span class="tdResultados">'+val.totalRubrica+'</span></td></tr>';
										 }
			
				  					}); 
								 });
								 htmll=htmll+'<tr><td colspan="6"><h1>CALIFICACI&OacuteN TOTAL</h1></td><td><h1>'+value.resultado.calificacionPorCategoria+'</h1></td></tr>';
						}
					});
					 $("table#tablaResulExpo").append(htmll);
				}						 
			});	
		});

		//$this.cargaFunciones();
	},

	formsFunction: function(){
		/*Elimina las etiquetas de errores vacias*/
		$(".label-info").each(function(){
			if($(this).children().size() == 0){
				$(this).remove();
			}
		});
		/*Limpia los campos cuando almacene los datos*/
		if($(".alert-success").size() > 0){
			$("input, textarea, select").val("");
		}		
	},
	
	
	
	controlDeTiempo:function(){
		$this.cargaTablaResultadosCategoria();
		var timer = setInterval(this.changeSlider, 8000);
	},
	
	changeSlider:function() {
		$this.i++;
		if($this.i == $(".slider .block").size()){
			$this.i = 0;
		}
		$(".slider .block").hide();
		$(".slider .block").eq($this.i).fadeIn(3000);
	},
	
	//Funcion encargada de actualizar resultados de categoria
	updateResultadosCategoria:function(){
		setInterval(function(){	
			$this.cargaTablaResultadosCategoria();
		}, 40000);
	},
	
};//Fin var demo

var bootStrapLabel = {
		/* 
		 * esconde las etiquetas definidas por
		 * bootstrap from twitter 
		 *  */
		hideEmptyLabels: function(){
			$this = this;
			
			var labelsInfo = $(".label-info");
			window.console.info(labelsInfo);
			$.each(labelsInfo, function(key, value){
				var label = $(value);
				if($(value).html().trim() == ''){
					label.hide();
				}
			});
		}
};

$(document).ready(function(){
	
	bootStrapLabel.hideEmptyLabels();
	
	DEMO.main();
});
