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
		$this.cargaTablaRankinPosiciones();
		$this.changeSlider();
		$this.controlDeTiempo();
		$this.formsFunction();
	},
	
	//Carga tablas resultados rubrica categoria
	cargaTablaResultadosCategoria: function (){
	
/////////////////////////////////////////////////******************************
		 var data= {
			   "idEvaluacion":"25bbdcd06c32d477f7fa1c3e4a91b032",
			   "descripcion":"Evaluacion TIC 2013",
			   "fechaCreacion":"Aug 2, 2013 5:31:25 PM",
			   "proyectos":{
			      "a2ef406e2c2351e0b9e80029c909242d":{
			         "idProyecto":"a2ef406e2c2351e0b9e80029c909242d",
			         "nombre":"Pagina para el IFE",
			         "categoria":{
			            "idCategoria":4,
			            "descripcion":"Software Web"
			         },
			         "responsable":"Andres Dominguez",
			         "integrantes":[
			            null
			         ],
			         "resultado":{
			            "calificacionEvaluadores":[
			               {
			                  "evaluador":{
			                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			                     "especialidad":"TIC",
			                     "nombre":"Mario",
			                     "usuario":"aaaaa",
			                     "clave":"12345",
			                     "activo":1
			                  },
			                  "resultadoPorItem":{
			                     "1":9.0,
			                     "2":9.0,
			                     "3":9.0,
			                     "4":9.0,
			                     "5":9.0
			                  },
			                  "rubrica":{},
			                  "totalRubrica":9.0
			               },
			               {
				                  "evaluador":{
				                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				                     "especialidad":"TIC",
				                     "nombre":"Mauricio ledesma",
				                     "usuario":"aaaaa",
				                     "clave":"12345",
				                     "activo":1
				                  },
				                  "resultadoPorItem":{
				                     "1":99.0,
				                     "2":39.0,
				                     "3":49.0,
				                     "4":59.0,
				                     "5":29.0
				                  },
				                  "rubrica":{},
				                  "totalRubrica":38.0
				           },
			               {
				                  "evaluador":{
				                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				                     "especialidad":"TIC",
				                     "nombre":"Alonso Aguirre marquez",
				                     "usuario":"aaaaa",
				                     "clave":"12345",
				                     "activo":1
				                  },
				                  "resultadoPorItem":{
				                     "1":3.0,
				                     "2":4.0,
				                     "3":3.0,
				                     "4":9.0,
				                     "5":10.0
				                  },
				                  "rubrica":{},
				                  "totalRubrica":35
				               }
			            ],
			            "calificacionPorCategoria":9.0
			         }
			      },
			      "96a3be3cf272e017046d1b2674a52bd3":{
			         "idProyecto":"96a3be3cf272e017046d1b2674a52bd3",
			         "nombre":"Aplicacion para kinect",
			         "categoria":{
			            "idCategoria":2,
			            "descripcion":"Software Escritorio"
			         },
			         "responsable":"Joel Morales",
			         "integrantes":[
			            null
			         ],
			         "resultado":{
			            "calificacionEvaluadores":[
			               {
			                  "evaluador":{
			                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			                     "especialidad":"TIC",
			                     "nombre":"Margara ledesma",
			                     "usuario":"aaaaa",
			                     "clave":"12345",
			                     "activo":1
			                  },
			                  "resultadoPorItem":{
			                     "1":5.0,
			                     "2":5.0,
			                     "3":5.0,
			                     "4":5.0,
			                     "5":5.0
			                  },
			                  "rubrica":{
			                     "categoria":{
			                        "idCategoria":1,
			                        "descripcion":"Software Multimedia"
			                     },
			                     "id":"dc5c7986daef50c1e02ab09b442ee34f",
			                     "items":[
			                        {
			                           "idItemRubrica":1,
			                           "descripcionCorta":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
			                           "descripcionLarga":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
			                           "escala":{
			                              "idEscala":1,
			                              "inicio":0,
			                              "fin":100
			                           }
			                        },
			                        {
			                           "idItemRubrica":2,
			                           "descripcionCorta":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
			                           "descripcionLarga":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
			                           "escala":{
			                              "idEscala":1,
			                              "inicio":0,
			                              "fin":100
			                           }
			                        },
			                        {
			                           "idItemRubrica":3,
			                           "descripcionCorta":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
			                           "descripcionLarga":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
			                           "escala":{
			                              "idEscala":1,
			                              "inicio":0,
			                              "fin":100
			                           }
			                        },
			                        {
			                           "idItemRubrica":4,
			                           "descripcionCorta":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
			                           "descripcionLarga":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
			                           "escala":{
			                              "idEscala":1,
			                              "inicio":0,
			                              "fin":100
			                           }
			                        },
			                        {
			                           "idItemRubrica":5,
			                           "descripcionCorta":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
			                           "descripcionLarga":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
			                           "escala":{
			                              "idEscala":1,
			                              "inicio":0,
			                              "fin":100
			                           }
			                        }
			                     ]
			                  },
			                  "totalRubrica":9.0
			               },
			               {
				                  "evaluador":{
				                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				                     "especialidad":"TIC",
				                     "nombre":"Margarito paquiao",
				                     "usuario":"aaaaa",
				                     "clave":"12345",
				                     "activo":1
				                  },
				                  "resultadoPorItem":{
				                     "1":5.0,
				                     "2":5.0,
				                     "3":5.0,
				                     "4":5.0,
				                     "5":5.0
				                  },
				                  "rubrica":{
				                     "categoria":{
				                        "idCategoria":1,
				                        "descripcion":"Software Multimedia"
				                     },
				                     "id":"dc5c7986daef50c1e02ab09b442ee34f",
				                     "items":[
				                        {
				                           "idItemRubrica":1,
				                           "descripcionCorta":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
				                           "descripcionLarga":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
				                           "escala":{
				                              "idEscala":1,
				                              "inicio":0,
				                              "fin":100
				                           }
				                        },
				                        {
				                           "idItemRubrica":2,
				                           "descripcionCorta":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
				                           "descripcionLarga":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
				                           "escala":{
				                              "idEscala":1,
				                              "inicio":0,
				                              "fin":100
				                           }
				                        },
				                        {
				                           "idItemRubrica":3,
				                           "descripcionCorta":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
				                           "descripcionLarga":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
				                           "escala":{
				                              "idEscala":1,
				                              "inicio":0,
				                              "fin":100
				                           }
				                        },
				                        {
				                           "idItemRubrica":4,
				                           "descripcionCorta":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
				                           "descripcionLarga":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
				                           "escala":{
				                              "idEscala":1,
				                              "inicio":0,
				                              "fin":100
				                           }
				                        },
				                        {
				                           "idItemRubrica":5,
				                           "descripcionCorta":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
				                           "descripcionLarga":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
				                           "escala":{
				                              "idEscala":1,
				                              "inicio":0,
				                              "fin":100
				                           }
				                        }
				                     ]
				                  },
				                  "totalRubrica":9.0
				               },
				               {
					                  "evaluador":{
					                     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
					                     "especialidad":"TIC",
					                     "nombre":"El travieso arce",
					                     "usuario":"aaaaa",
					                     "clave":"12345",
					                     "activo":1
					                  },
					                  "resultadoPorItem":{
					                     "1":5.0,
					                     "2":5.0,
					                     "3":5.0,
					                     "4":5.0,
					                     "5":5.0
					                  },
					                  "rubrica":{
					                     "categoria":{
					                        "idCategoria":1,
					                        "descripcion":"Software Multimedia"
					                     },
					                     "id":"dc5c7986daef50c1e02ab09b442ee34f",
					                     "items":[
					                        {
					                           "idItemRubrica":1,
					                           "descripcionCorta":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
					                           "descripcionLarga":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
					                           "escala":{
					                              "idEscala":1,
					                              "inicio":0,
					                              "fin":100
					                           }
					                        },
					                        {
					                           "idItemRubrica":2,
					                           "descripcionCorta":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
					                           "descripcionLarga":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
					                           "escala":{
					                              "idEscala":1,
					                              "inicio":0,
					                              "fin":100
					                           }
					                        },
					                        {
					                           "idItemRubrica":3,
					                           "descripcionCorta":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
					                           "descripcionLarga":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
					                           "escala":{
					                              "idEscala":1,
					                              "inicio":0,
					                              "fin":100
					                           }
					                        },
					                        {
					                           "idItemRubrica":4,
					                           "descripcionCorta":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
					                           "descripcionLarga":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
					                           "escala":{
					                              "idEscala":1,
					                              "inicio":0,
					                              "fin":100
					                           }
					                        },
					                        {
					                           "idItemRubrica":5,
					                           "descripcionCorta":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
					                           "descripcionLarga":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
					                           "escala":{
					                              "idEscala":1,
					                              "inicio":0,
					                              "fin":100
					                           }
					                        }
					                     ]
					                  },
					                  "totalRubrica":9.0
					               }
			            ],
			            "calificacionPorCategoria":9.0
			         }
			      }
			   },
			   "evaluadores":{
			      "68a9e49bbc88c02083a062a78ab3bf30":{
			         "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			         "especialidad":"Aplicaciones Moviles",
			         "nombre":"Cobijas 33",
			         "usuario":"mayri_022",
			         "clave":"1452546",
			         "activo":1
			      },
			      "cd3dc8b6cffb41e4163dcbd857ca87da":{
			         "idEvaluador":"cd3dc8b6cffb41e4163dcbd857ca87da",
			         "especialidad":"TIC",
			         "nombre":"Alfredo de Jesus Perez de los Robles y Rebolledo",
			         "usuario":"alfredop",
			         "clave":"12345",
			         "activo":1
			      }
			   }
			}
		
		htmll='';
		$.each(data.proyectos, function (key, value) {
			//Obtengo el nombre
			htmll=htmll+'<article class="block"><div class="row"><div class="span12"><h1>'+value.nombre+'</h1></div></div>';
			htmll=htmll+'<table class="table table-bordered table-striped"><thead>';
			htmll=htmll+'<tr><th><h1>Nombre del Evaluador</h1></th><th><h1>Criterio 1</h1></th><th><h1>Criterio 2</h1></th>';
			htmll=htmll+'<th><h1>Criterio 3</h1></th><th><h1>Criterio 4</h1></th><th><h1>Criterio 5</h1></th>';
			htmll=htmll+'<th><h1>Total</h1></th></tr></thead><tbody>';
			
				 $.each(value.resultado, function (llave, valor) {
					 $.each(valor, function (cle, val) {
						//aqui se obtiene nombre alert(val.evaluador.nombre);
						htmll=htmll+'<tr><td><span class="tdResultados">'+val.evaluador.nombre+'</span></td>';
						 $.each(val.resultadoPorItem, function (llav, vale) { //entra calificacion evaluadores
							// alert(vale);
							 htmll=htmll+'<td><span class="tdResultados">'+vale+'</span></td>';							 
	   					});
						 htmll=htmll+'<td><span class="tdResultados">'+val.totalRubrica+'</span></td></tr>';
						 //alert(val.totalRubrica);//promedio items evaluador
  					});
					 
				 });
				 //alert(value.resultado.calificacionPorCategoria); calificacion proyecto
				 htmll=htmll+'<tr><td colspan="6"><h3>CALIFICACI&OacuteN TOTAL</h3></td><td><h3>'+value.resultado.calificacionPorCategoria+'</h3></td>';
				 htmll=htmll+'</tr></tbody></table></article>';
					
				 $("#seccion1").html(htmll);
			});
		
			//Implementar setInterval(function(){}, 3000);
				/*$.ajax({
					type: "GET",
					dataType: "JSON",
		   			url:URL_APP_SERVICE + "/manager/resultados-categoria.json",
		   			success: function(data){
		   						   				
		   				$.each(data.proyectos, function (key, value) {
		   					 
		   						
		   					 $.each(value.resultado, function (llave, valor) {
		   						
		   						 $.each(valor, function (cle, val) {
		   							//aqui se obtiene nombre alert(val.evaluador.nombre);
		   							//alert(val.evaluador.resultadoPorItem);
		   							 $.each(val.resultadoPorItem, function (llav, vale) { //entra calificacion evaluadores
		   								alert(vale);
		   								 $.each(vale, function (indice, evaluador) { //entra calificacion evaluadores
		   									//alert(evaluador);
						   						
						   					});
					   						
					   					});
				   						
				   					});
		   						
		   					 });
		   				});
					}
					 
				});	*/
				
		
		
			

	},
	
	//**********************************Carga Ranking de posiciones**********************************************////
	cargaTablaRankinPosiciones: function (){
		

			var data= {
			"idEvaluacion":"25bbdcd06c32d477f7fa1c3e4a91b032",
			"descripcion":"Evaluacion TIC 2013",
			"fechaCreacion":"Aug 2, 2013 5:31:25 PM",
			"proyectos":{
			"a2ef406e2c2351e0b9e80029c909242d":{
			"idProyecto":"a2ef406e2c2351e0b9e80029c909242d",
			"nombre":"Pagina para el IFE",
			"categoria":{
			"idCategoria":4,
			"descripcion":"Software Web"
			},
			"responsable":"Andres Dominguez",
			"integrantes":[
			null
			],
			"resultado":{
			"calificacionEvaluadores":[
			{
			"evaluador":{
			"idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			"especialidad":"TIC",
			"nombre":"Mario Angeles",
			"usuario":"aaaaa",
			"clave":"12345",
			"activo":1
			},
			"resultadoPorItem":{
			"1":9.0,
			"2":9.0,
			"3":9.0,
			"4":9.0,
			"5":9.0
			},
			"rubrica":{},
			"totalRubrica":9.0
			},
			{
			"evaluador":{
			 "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			 "especialidad":"TIC",
			 "nombre":"Alonso Aguirre",
			 "usuario":"aaaaa",
			 "clave":"12345",
			 "activo":1
			},
			"resultadoPorItem":{
			 "1":3.0,
			 "2":4.0,
			 "3":3.0,
			 "4":9.0,
			 "5":10.0
			},
			"rubrica":{},
			"totalRubrica":35
			},
			{
			  "evaluador":{
			     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			     "especialidad":"TIC",
			     "nombre":"Margaro ledesma",
			     "usuario":"aaaaa",
			     "clave":"12345",
			     "activo":1
			  },
			  "resultadoPorItem":{
			     "1":9.0,
			     "2":34.0,
			     "3":32.0,
			     "4":94.0,
			     "5":100.0
			  },
			  "rubrica":{},
			  "totalRubrica":35
			}
			
			],
			"calificacionPorCategoria":9.0
			}
			},
			"a2ef406e2c2351e0b9e80029c9092434":{
				"idProyecto":"a2ef406e2c2351e0b9e80029c9092434",
				"nombre":"Software de calidad",
				"categoria":{
				"idCategoria":4,
				"descripcion":"Software Web"
				},
				"responsable":"Andres Dominguez",
				"integrantes":[
				null
				],
				"resultado":{
				"calificacionEvaluadores":[
				{
				"evaluador":{
				"idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				"especialidad":"TIC",
				"nombre":"Mario Angeles",
				"usuario":"aaaaa",
				"clave":"12345",
				"activo":1
				},
				"resultadoPorItem":{
				"1":9.0,
				"2":9.0,
				"3":9.0,
				"4":9.0,
				"5":9.0
				},
				"rubrica":{},
				"totalRubrica":9.0
				},
				{
				"evaluador":{
				 "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				 "especialidad":"TIC",
				 "nombre":"Alonso Aguirre",
				 "usuario":"aaaaa",
				 "clave":"12345",
				 "activo":1
				},
				"resultadoPorItem":{
				 "1":3.0,
				 "2":4.0,
				 "3":3.0,
				 "4":9.0,
				 "5":10.0
				},
				"rubrica":{},
				"totalRubrica":35
				},
				{
				  "evaluador":{
				     "idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
				     "especialidad":"TIC",
				     "nombre":"Margaro ledesma",
				     "usuario":"aaaaa",
				     "clave":"12345",
				     "activo":1
				  },
				  "resultadoPorItem":{
				     "1":9.0,
				     "2":34.0,
				     "3":32.0,
				     "4":94.0,
				     "5":100.0
				  },
				  "rubrica":{},
				  "totalRubrica":35
				}
				
				],
				"calificacionPorCategoria":9.0
				}
				},
			"96a3be3cf272e017046d1b2674a52bd3":{
			"idProyecto":"96a3be3cf272e017046d1b2674a52bd3",
			"nombre":"Aplicacion para kinect",
			"categoria":{
			"idCategoria":2,
			"descripcion":"Software Escritorio"
			},
			"responsable":"Joel Morales",
			"integrantes":[
			null
			],
			"resultado":{
			"calificacionEvaluadores":[
			{
			"evaluador":{
			"idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			"especialidad":"TIC",
			"nombre":"Margarito",
			"usuario":"aaaaa",
			"clave":"12345",
			"activo":1
			},
			"resultadoPorItem":{
			"1":5.0,
			"2":5.0,
			"3":5.0,
			"4":5.0,
			"5":5.0
			},
			"rubrica":{
			"categoria":{
			"idCategoria":1,
			"descripcion":"Software Multimedia"
			},
			"id":"dc5c7986daef50c1e02ab09b442ee34f",
			"items":[
			{
			   "idItemRubrica":1,
			   "descripcionCorta":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
			   "descripcionLarga":"No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido",
			   "escala":{
			      "idEscala":1,
			      "inicio":0,
			      "fin":100
			   }
			},
			{
			   "idItemRubrica":2,
			   "descripcionCorta":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
			   "descripcionLarga":"La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido",
			   "escala":{
			      "idEscala":1,
			      "inicio":0,
			      "fin":100
			   }
			},
			{
			   "idItemRubrica":3,
			   "descripcionCorta":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
			   "descripcionLarga":"El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)",
			   "escala":{
			      "idEscala":1,
			      "inicio":0,
			      "fin":100
			   }
			},
			{
			   "idItemRubrica":4,
			   "descripcionCorta":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
			   "descripcionLarga":"Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales",
			   "escala":{
			      "idEscala":1,
			      "inicio":0,
			      "fin":100
			   }
			},
			{
			   "idItemRubrica":5,
			   "descripcionCorta":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
			   "descripcionLarga":"Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente",
			   "escala":{
			      "idEscala":1,
			      "inicio":0,
			      "fin":100
			   }
			}
			]
			},
			"totalRubrica":9.0
			}
			],
			"calificacionPorCategoria":9.0
			}
			}
			},
			"evaluadores":{
			"68a9e49bbc88c02083a062a78ab3bf30":{
			"idEvaluador":"68a9e49bbc88c02083a062a78ab3bf30",
			"especialidad":"Aplicaciones Moviles",
			"nombre":"Cobijas 33",
			"usuario":"mayri_022",
			"clave":"1452546",
			"activo":1
			},
			"cd3dc8b6cffb41e4163dcbd857ca87da":{
			"idEvaluador":"cd3dc8b6cffb41e4163dcbd857ca87da",
			"especialidad":"TIC",
			"nombre":"Alfredo de Jesus Perez de los Robles y Rebolledo",
			"usuario":"alfredop",
			"clave":"12345",
			"activo":1
			}
			}
			}
			
					
					htmll='';
					htmll=htmll+'<table class="table table-bordered table-striped">'+
					'<thead><tr><th><h3>POSICION</h3></th><th><h3>LOGO</h3></th><th><h3>PROYECTO</h3></th><th><h3>PUNTAJE</h3></th>'+
					'</tr></thead>';
					
					$.each(data.proyectos, function (key, value) {
					//Obtengo el nombre
					htmll=htmll+'<tbody><tr><td>1</td>';
					//htmll=htmll+'<td><div class="logo"> <img src="'+URL_APP_SERVICE+ '/evaluacion/proyecto/logo/b1ba9a6770" width /> </div></td>';
					htmll=htmll+'<td>'+value.nombre+'</td><td><h3>'+value.resultado.calificacionPorCategoria+'</h3></td></tr></tbody>';
					
					});
				$("#divtablaResulFinal").html(htmll+'</table>');
				//Implementar setInterval(function(){}, 3000);
				/*$.ajax({
				type: "GET",
				dataType: "JSON",
				url:URL_APP_SERVICE + "/manager/resultados-categoria.json",
				success: function(data){
								
				
				}
				
				});	*/
			
			
			
			
			
			},

	//**********************************Fin ranking de posiciones***********************************************************/
	
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
