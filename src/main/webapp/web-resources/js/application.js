var DEMO = {
	//declaracion de variables globales
		selecMotivo: null,
		data: null,
		existe: null,
	main : function(){
		this.init();
	},
	init: function(){
		$this = this;
		$this.cargaFunciones();
		$this.formsFunction();
	},
	
	//Carga los tooltips
	cargaFunciones: function (){
		
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
	}
	
	
	
};//Fin var demo



$(document).ready(function(){
	DEMO.main();
	
		var rows = document.getElementsByTagName("tr");
		for(var i in rows) {
		    rows[i].onmouseover = function() {
		            this.className = "color";
		            }
		    rows[i].onmouseout = function() {
		            this.className = null;
		            }
		    }
	
});
