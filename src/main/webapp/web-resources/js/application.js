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
	},
	
	//Carga los tooltips
	cargaFunciones: function (){
		$('#fechaEvaluacion').datepicker();
	},
	
	
	
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
