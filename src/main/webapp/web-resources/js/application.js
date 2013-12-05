var DEMO = {
		//declaracion de variables globales
		i:0,
		numeroDeElementos:0,
		idEvalucacionEncabezado:self.location.href.match(/\/([^/]+)$/)[1],
		rubricaCategoria:'',
		time:0,
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
				$this.cargaTablaResultadosCategoria();
				$this.updateResultadosCategoria();
				$this.changeSlider();
				break;
			case 'exposicion':
				$this.cargaTablaResultadosPresentacion();
				$this.cargaTablaResultadosPresentacionPrimer();
				break;
			case 'finales':
				 //$this.cargaTablaRankinPosiciones(); 
				 $this.runProcessRanking();
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
					htmll=htmll+'<article class="block">';
					htmll=htmll+	'<div class="row">';
					htmll=htmll+		'<div class="span12">';
					htmll=htmll+			'<h1>'+value.nombre+'</h1>';
					htmll=htmll+		'</div>';
					htmll=htmll+	'</div>';
										
					var columna = 1;
					$.each(value.resultado.calificacionEvaluadores, function(llave, valor){
						if(valor != undefined){
							columna = 1;
							$.each(valor.resultadoPorItem, 
									function (key, value) {
								columna++;
							});							
						}
					});
							

					
					htmll=htmll+	'<table class="table table-bordered table-striped">';
					htmll=htmll+		'<thead>';
					htmll=htmll+			'<tr>';
					htmll=htmll+				'<th rowspan="2">';
					htmll=htmll+					'<h1>Nombre del Evaluador</h1>';
					htmll=htmll+				'</th>';
					htmll=htmll+				'<th colspan="' + columna + '" class="tdCentrado">';
					htmll=htmll+					'<h2>Criterios</h2>';
					htmll=htmll+				'</th>';
					htmll=htmll+			'</tr>';
				
					htmll=htmll+			'<tr>';
					
					for(var iteraCol = 1; iteraCol < columna; iteraCol++){
						htmll=htmll+				'<th class="tdCentrado"><h3>' + iteraCol + '</h3></th>';	
					}
					htmll=htmll+					'<th rowspan="2" class="tdCentrado">';
					htmll=htmll+						'<h1>Total</h1>';
					htmll=htmll+					'</th>';
					
					htmll=htmll+			'</tr>';
					htmll=htmll+		'</thead>';					
					htmll=htmll+		'<tbody>';	
					
					 $.each(value.resultado, function (llave, valor) {
						 $.each(valor, function (cle, val) {
							 var rubricaCategoria= val.rubrica.categoria;
							 if (rubricaCategoria != undefined){
								
								 htmll=htmll+'<tr>';
								 htmll=htmll+	'<td>';
								 htmll=htmll+		'<span class="tdResultados">';
								 htmll=htmll+ 			val.evaluador.nombre;
								 htmll=htmll+		'</span>';
								 htmll=htmll+	'</td>';
								 								 
								 $.each(val.resultadoPorItem, function (llave, valoritem) { 										
									 htmll=htmll+'<td class="tdCentrado">';
									 htmll=htmll+	'<span class="tdResultados">';
									 htmll=htmll+		valoritem;
									 htmll=htmll+	'</span>';
									 htmll=htmll+'</td>';
									 
			   					 });
								 
								 htmll=htmll+	'<td>';
								 htmll=htmll+		'<span class="tdResultados tdCentrado" >';
								 htmll=htmll+			val.totalRubrica;
								 htmll=htmll+		'</span>';
								 htmll=htmll+'	</td>';
								 htmll=htmll+'</tr>';
							 }
	  					});
					 });
						 
					 htmll=htmll+			'<tr>';
					 htmll=htmll+				'<td colspan="' + (iteraCol) + '" class="tdResultados"><h3>CALIFICACI&OacuteN TOTAL</h3></td>';
					 htmll=htmll+				'<td class="tdCentrado tdResultados">';
					 htmll=htmll+					value.resultado.calificacionPorCategoria.toFixed(2);
					 htmll=htmll+				'</td>';					 
					 htmll=htmll+			'</tr>';
					 htmll=htmll+		'</tbody>';
					 htmll=htmll+	'</table>';
					 htmll=htmll+'</article>';
							
					 $("#seccion1").html(htmll);
						
					});
				
					$(".slider .block:first").fadeIn(3000);
					$this.numeroDeElementos = $("#seccion1").children().size();
					$this.controlDeTiempo();
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
					$("#tablaPosicion").remove();
					htmll=htmll+'<table class="table table-bordered table-striped" id="tablaPosicion">'+
					'<thead><tr><th class="tdCentrado"><h3>POSICION</h3></th><th class="tdCentrado"><h3>LOGO</h3></th><th class="tdCentrado"><h3>PROYECTO</h3></th><th class="tdCentrado"><h3>PUNTAJE</h3></th>'+
					'</tr></thead><tbody>';
					var posicion = 0;
					$.each(data, function (key, value) {
						posicion = key + 1;
						// Obtengo el nombre
						htmll = htmll + '<tr><td class="tdCentrado"><h3>'+posicion+'</h3></td>';
						htmll=htmll+'<td><div class="logo"><img src="'+URL_APP_SERVICE+'/evaluacion/proyecto/logo/'+value.idProyecto+'" width /></div></td>';
						htmll = htmll + '<td class="nombre-proyecto"><h3>' + value.nombre + '<h3></td><td class="tdCentrado"><h3>'+value.resultado.calificacionGlobal.toFixed(2)+'</h3></td></tr>';
					});
					$("#divtablaResulFinal").html(htmll+'</tbody></table>');
					$("#tablaPosicion tr").hide();
					$("#tablaPosicion tr").slice(0,5).show(3000);
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
											 
											 htmll=htmll+'<tr><td><span class="tdResultados"><h2>'+val.evaluador.nombre+'</h2></span></td>';
											 
											 $.each(val.resultadoPorItem, function (llav, vale) { //entra calificacion evaluadores
			   									 htmll=htmll+'<td class="tdCentrado"><span class="tdResultados"><h3>'+vale+'</h3></span></td>';							 
			   			   					 });
											 htmll=htmll+'<td><span class="tdCentrado"><h3>'+val.totalRubrica+'</h3></span></td></tr>';
										 }
			
				  					}); 
								 });
								 htmll=htmll+'<tr><td colspan="6"><h1>CALIFICACI&OacuteN TOTAL</h1></td><td><h1>'+value.resultado.calificacionPorPresentacion.toFixed(2)+'</h1></td></tr>';
						}
					});
					 $("table#tablaResulExpo").append(htmll);
				}						 
			});	
		});
	},
	
	cargaTablaResultadosPresentacionPrimer: function (){
		
			$("#listProyectos").eq(0).val();
			 $("table#tablaResulExpo td").remove();
		 
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
											 
											 htmll=htmll+'<tr><td><span class="tdResultados"><h2>'+val.evaluador.nombre+'</h2></span></td>';
											 
											 $.each(val.resultadoPorItem, function (llav, vale) { //entra calificacion evaluadores
			   									 htmll=htmll+'<td class="tdCentrado"><span class="tdResultados"><h3>'+vale+'</h3></span></td>';							 
			   			   					 });
											 htmll=htmll+'<td><span class="tdCentrado"><h3>'+val.totalRubrica+'</h3></span></td></tr>';
										 }
			
				  					}); 
								 });
								 htmll=htmll+'<tr><td colspan="6"><h1>CALIFICACI&OacuteN TOTAL</h1></td><td><h1>'+value.resultado.calificacionPorPresentacion.toFixed(2)+'</h1></td></tr>';
						}
					});
					 $("table#tablaResulExpo").append(htmll);
					
				}						 
				
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
		if ($this.numeroDeElementos > 1){
			var timer = setInterval(this.changeSlider, 16000);
		}else{
			$(".slider .block:first").fadeIn(3000);
		}
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
		}, 300000);
	},
	
	
	//******Funciones de Rnaking posiciones********///
	updateRankingPosiciones:function(){
		var numeroProyectos= $("#tablaPosicion tbody tr").length;
        if (numeroProyectos > 0){
                if (numeroProyectos > 4){
                        $("#tablaPosicion tbody").fadeOut(3000, function(){

                                $("#tablaPosicion tbody tr").slice(0,4).remove();
                        $("#tablaPosicion tbody").fadeIn(3000);
                        $("#tablaPosicion tr").slice(0,5).show();

                        if (numeroProyectos >= 5 && numeroProyectos <9){
                                window.clearTimeout($this.time);

                                $("#tablaPosicion").delay(5000).fadeOut(3000, function(){
                                        $("#tablaPosicion").remove();
                                        $this.runProcessRanking();
                                });
                        }
                         //$this.cargaTablaRankinPosiciones();
               });
            }else{
                    $("#tablaPosicion").fadeOut(3000, function(){
                            $("#tablaPosicion").remove();
                            window.clearTimeout($this.time);
                            $this.runProcessRanking();
                    });
            }

        }else{
                $this.cargaTablaRankinPosiciones();
        }
	},
	//Funcion encargada de actualizar el ranking de posiciones
	runProcessRanking:function(){ 
		$this.updateRankingPosiciones();
		$this.time = setInterval(function(){
			$this.updateRankingPosiciones(); 
		 }, 16000);
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
