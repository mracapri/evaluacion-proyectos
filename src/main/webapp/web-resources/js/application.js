var DEMO = {
		//declaracion de variables globales
		data: null,
		existe: null,
		i:0,
	main : function(){
		this.init();
		$(".slider .block:first").fadeIn(3000); //carga el primer block de la animacion
	},
	init: function(){
		$this = this;
		$this.cargaTablaResultadosCategoria();
		$this.cargaTablaResultadosPresentacion();
		$this.changeSlider();
		$this.controlDeTiempo();
	},
	
	//Carga tablas resultados rubrica categoria
	cargaTablaResultadosCategoria: function (){
		var data= {
				"proyectos": [{
					"nameproyecto": "DESARROLLO DE MODULO INTERACTIVO",
					"promedio": "89",
			   				"val": [{
			         			"nameEvaluador": "jose",
			         			"cal1": "54",
			         			"cal2": "96",
								"cal3": "34",
			         			"cal4": "44",
								"cal5": "5",
								"resultado": "89"
			         		},
			         		{
			         			"nombre": "alonso",
			         			"cal1": "14",
			         			"cal2": "26",
								"cal3": "74",
			         			"cal4": "24",
								"cal5": "53",
								"resultado": "89"
			         		}]
							
				},
				{
					"nameproyecto": "SISTEMA DE EVALUACION DE PROYECTOS",
					"promedio": "89",
			   				"val": [{
			         			"nombre": "josefinitor",
			         			"cal1": "15",
			         			"cal2": "23",
								"cal3": "57",
			         			"cal4": "13",
								"cal5": "24",
								"resultado": "89"
			         		},
			         		{
			         			"nombre": "alonsitod",
			         			"cal1": "94",
			         			"cal2": "36",
								"cal3": "54",
			         			"cal4": "64",
								"cal5": "33",
								"resultado": "89"
			         		}]
				},
				{
					"nameproyecto": "SISTEMA INTEGRAL DE INFORMACION 3 PARA LA UTVM",
					"promedio": "89",
			   				"val": [{
			         			"nombre": "Roberto",
			         			"cal1": "19",
			         			"cal2": "23",
								"cal3": "45",
			         			"cal4": "27",
								"cal5": "39",
								"resultado": "89"
			         		},
			         		{
			         			"nombre": "Margarito",
			         			"cal1": "12",
			         			"cal2": "13",
								"cal3": "14",
			         			"cal4": "24",
								"cal5": "15",
								"resultado": "89"
			         		}]
				}]
			}
		
			/*carga de JSON a tabla reusltados proyectos categoria*/ 
			var htmll='';
			$.each(data, function (key, value) {
			    $.each(value, function (llave, valor) {
					htmll=htmll+'<article class="block"><div class="row"><div class="span12"><h3>'+valor.nameproyecto+'</h3></div></div>';
					htmll=htmll+'<table class="table table-bordered table-striped"><thead>';
					htmll=htmll+'<tr><th><h3>Nombre del Evaluador</h3></th><th><h3>Criterio 1</h3></th><th><h3>Criterio 2</h3></th>';
					htmll=htmll+'<th><h3>Criterio 3</h3></th><th><h3>Criterio 4</h3></th><th><h3>Criterio 5</h3></th>';
					htmll=htmll+'<th><h3>Total</h3></th></tr></thead><tbody>';
					
			           $.each(valor.val, function (cle, val) {
			              htmll=htmll+'<tr><td><span class="tdResultados">'+val.nombre+'</span></td><td><span class="tdResultados">'+val.cal1+'</span></td>';
						  htmll=htmll+'<td><span class="tdResultados">'+val.cal2+'</span></td><td><span class="tdResultados">'+val.cal3+'</span></td><td><span class="tdResultados">'+val.cal4+'</span></td>';
						  htmll=htmll+'<td><span class="tdResultados">'+val.cal5+'</span></td><td><span class="tdResultados">'+val.resultado+'</span></td></tr>';
			            });
			 
						 htmll=htmll+'<tr><td colspan="6"><h3>CALIFICACI&OacuteN TOTAL</h3></td><td><h3>'+valor.promedio+'</h3></td>';
						 htmll=htmll+'</tr></tbody></table></article>';
			    });
			    $("#seccion1").html(htmll);
			});
			

	},
	
	
	
	//**Carga datos de la tabla de resultados por Presentacion**/
	cargaTablaResultadosPresentacion: function (){
			
		var data= {
				"proyectos": [{
					"nameproyecto": "Proyecto de evaluacion",
					"promedio": "89",
			   				"val": [{
			         			"nameEvaluador": "jose",
			         			"cal1": "54",
			         			"cal2": "96",
								"cal3": "34",
			         			"cal4": "44",
								"cal5": "5",
								"resultado": "89"
			         		},
			         		{
			         			"nombre": "alonso",
			         			"cal1": "14",
			         			"cal2": "26",
								"cal3": "74",
			         			"cal4": "24",
								"cal5": "53",
								"resultado": "89"
			         		}]
				}]
			}
		
		$("#listProyectos").live('change', function(){
			 $("table#tablaResulExpo td").remove();
			 $('#showProyectos').trigger('click');
			 
			/*carga de JSON a tabla resultados proyectos presentacion*/ 
			htmll='';
			$.each(data, function (key, value) {
			    $.each(value, function (llave, valor) {
			           $.each(valor.val, function (cle, val) {
			        		htmll=htmll+'<tr><td><span class="tdResultados">'+val.nombre+'</span></td>'+
			        		'<td><span class="tdResultados">'+val.cal1+ '</span></td>'+
			    			'<td><span class="tdResultados">'+val.cal2+ '</span></td>'+
			    			'<td><span class="tdResultados">'+val.cal3+ '</span></td>'+
			    			'<td><span class="tdResultados">'+val.cal4+ '</span></td>'+
			    			'<td><span class="tdResultados">'+val.cal5+ '</span></td>'+
			    			'<td><span class="tdResultados">'+val.resultado+ '</span></td></tr>';
			            });
			           
			           htmll=htmll+'<tr>'+
		    			'<td colspan="6"><h3>CALIFICACI&OacuteN TOTAL</h3></td>'+
		    			'<td><h3>'+valor.promedio+'</h3></td></tr>';
			    });
			    
			    $("table#tablaResulExpo").append(htmll);
			});
			//******************************/
		});

		//$this.cargaFunciones();
		//$this.formsFunction();
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
		var timer = setInterval(this.changeSlider, 8000);
		this.cargaTablaResultadosCategoria();
		
	},
	
	changeSlider:function() {
		$this.i++;
		if($this.i == $(".slider .block").size()){
			$this.i = 0;
		}
		$(".slider .block").hide();
		$(".slider .block").eq($this.i).fadeIn(3000);
	}
	
};//Fin var demo



$(document).ready(function(){
	DEMO.main();
	
});
