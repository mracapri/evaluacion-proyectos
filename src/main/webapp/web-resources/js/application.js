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
					htmll=htmll+'<td><div class="fileupload-new thumbnail logo"> <img src="data:image/jpeg;base64,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JgZKRPYJklMkxKcCOVFJT//Z/+0PLlBob3Rvc2hvcCAzLjAAOEJJTQQlAAAAAAAQAAAAAAAAAAAAAAAAAAAAADhCSU0D7QAAAAAAEABIAAAAAQABAEgAAAABAAE4QklNBCYAAAAAAA4AAAAAAAAAAAAAP4AAADhCSU0EDQAAAAAABAAAAHg4QklNBBkAAAAAAAQAAAAeOEJJTQPzAAAAAAAJAAAAAAAAAAABADhCSU0ECgAAAAAAAQAAOEJJTScQAAAAAAAKAAEAAAAAAAAAAThCSU0D9QAAAAAASAAvZmYAAQBsZmYABgAAAAAAAQAvZmYAAQChmZoABgAAAAAAAQAyAAAAAQBaAAAABgAAAAAAAQA1AAAAAQAtAAAABgAAAAAAAThCSU0D+AAAAAAAcAAA/////////////////////////////wPoAAAAAP////////////////////////////8D6AAAAAD/////////////////////////////A+gAAAAA/////////////////////////////wPoAAA4QklNBAgAAAAAABAAAAABAAACQAAAAkAAAAAAOEJJTQQeAAAAAAAEAAAAADhCSU0EGgAAAAADUwAAAAYAAAAAAAAAAAAAAwAAAAQAAAAADwBQAHUAbgBpAHMAaABlAHIAMwAgAGMAbwBwAHkAMgAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAEAAAAAwAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAQAAAAAAAG51bGwAAAACAAAABmJvdW5kc09iamMAAAABAAAAAAAAUmN0MQAAAAQAAAAAVG9wIGxvbmcAAAAAAAAAAExlZnRsb25nAAAAAAAAAABCdG9tbG9uZwAAAwAAAAAAUmdodGxvbmcAAAQAAAAABnNsaWNlc1ZsTHMAAAABT2JqYwAAAAEAAAAAAAVzbGljZQAAABIAAAAHc2xpY2VJRGxvbmcAAAAAAAAAB2dyb3VwSURsb25nAAAAAAAAAAZvcmlnaW5lbnVtAAAADEVTbGljZU9yaWdpbgAAAA1hdXRvR2VuZXJhdGVkAAAAAFR5cGVlbnVtAAAACkVTbGljZVR5cGUAAAAASW1nIAAAAAZib3VuZHNPYmpjAAAAAQAAAAAA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ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCjw/eHBhY2tldCBlbmQ9J3cnPz7/7gAmQWRvYmUAZIAAAAABAwAVBAMGCg0AAAAAAAAAAAAAAAAAAAAA/9sAhAAMCAgICQgMCQkMEQsKCxEVDwwMDxUYExMVExMYEQwMDAwMDBEMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMAQ0LCw0ODRAODhAUDg4OFBQODg4OFBEMDAwMDBERDAwMDAwMEQwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAz/wgARCAMABAADASIAAhEBAxEB/8QA2AABAAMBAQEBAAAAAAAAAAAAAAECAwQFBgcBAQAAAAAAAAAAAAAAAAAAAAAQAAICAQIEBQMEAgICAwAAAAECAAMREgQQYCETIDAxIgUyMxRAQSM0QiRQFXCwQyU1EQABAgMECQEFBgUDBQAAAAABABEQIQIxQVESIDBg8GFxIjIDgUCRoUITscHRYnIjUOHxUjNwggSQoJKyUxIBAAAAAAAAAAAAAAAAAAAAsBMBAAICAQMDAwQDAQEBAQAAAQARITFBEFFhIHGBMGCR8KGxwUDR4VDxsHD/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PPPLHPPPPPPPPPPPCPPPPPPPPPKPPLAAAMMAAAPKFAPPIEIFPFKEFOKLDPPFAAPPPPPPPPPPPPPPPPPPKPPPPPPPPPPPPOHPPKAAAAPCEHOCBPAEHCGHEFOBMAPFKBPPPPPPPPPPPPPPPPPPKPPPPPPPPPPPPKPPPIKAAFCKFCEDKFAIFJLMFLIIIHMFKEPPPPPPPPPPPPPPPPPPLPPPPPPPPPOPPKPPPIKACFFLMKPCIMBFPNHEDHGOPMCFIEPPPPPPPPPPPPPPPPPPPPPPPPPPPPKFPKPPPKKAKHBCIEDGHKECJCBKCOKHFIKFKFPPPPPPPPPPPPPPPPPPOPPPPPPPPPAFAKPPPKKFKKFKBDNMDKANCPKJGELCHCNFKEPPPPPPPPPPPPPPPPPPKPPPPPPPPOAAAKPPPAAHKKFNDPAMLABGLHHCPKDBPLHKKAPPPPPPPPPPPPPPPPPPKPPPPPPPPLAAAIPPPFANKKDFNGKGABJGIBPIGEKBBOOIKBPPPPPPPPPPPPPPPPPPKPPPPPPPPPAAAAPPPPAFKKCGJEODCPNHHBIFPAEOMEIAKFPPPPPPPPPPPPPPPPPPKPPPPPPPPPKAAAPPPHAAAKNEOMJEKEHMAAAEEACPHIPAKAPPPPPPPPPPPPPPPPPPKPPPPPPPPPLABKPPPPAADKBOFPAMCEECAAAAHFCHMPNBKAPPPPPPPPPPPPPPPPPPKPPPPPPPPPPPPPPPPPDAPBFAKANOGPGAAAAEIAKJMFNNKAPPPPPPPPPPPPPPPPPPKPPPPPPPPPPPPPPPPPCAPFHPBHFJEBHDAABDLKNFACOFBAPPPPPPPPPPPPPPPPPPLPPPPPPPPPPPPPPPPPPAPFOLLGMOKCIGFPOBPHEJALKAFAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPAPFKJPLGMJJODIANFKBCDIPLMNCFPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPAPFAPJHHFAECJAMILLHFPCKLCFKFPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPAHFBGONPNNFFAFNGIMBLJKHODKKEPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPANFFNNAIHBOKBDJKKJCLNCBFLPOCPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPHLBEFGMDKBBPGKBOFCOOCFJNMKIOFPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPBIDPHFBAOKOLFPEIGLHCGFFKIAFPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPFPPONNGEAOONNLJOIGMLKGGKIAAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPOFMOPNOICFMMPFEAOGLJKCKPCACAPPPPPPPPPPPPPPPPPPPPPPPPPPPPIEPPPIFPKCACHHONPABOEDEPCINLPNIAMBPAFPPPPPPPPPPPPPPPPPPPPPPPPPPPAAENMHENDHFJPJCKLEBJOMNLPKEBNNBKKFPAEPPPPPPPPPPPPPPPPPPPPPPPPPPOAAMBELGFGCMDJDGEKMHAJJCMOMCPNCIPKAAFPPPPPPPPPPPPPPPPPPPPPPPPPPPLCBEKJMNACKBFEOKIIJKGNMPGLODEKNPNIBDHNPPPPPPPPPPPPPPPPPPPPPPPPPPPKCHPMPHLFHLLBAEPFJDIFCDPIECPIHOMCOIPFPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPLOOJFPPKAMPGNCIGLKLHMEEGFOAGADCPNPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPLLOPPOJEIEIMBPDAHJGHIIFPKAEBEAEFKPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPFFKIPKPIPHLAAAOBPNCKDFPOPFCABAAHIPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPKCHPJNCMCPPPANFEIAEMBCAKEKHOFOCCPHPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPDAPPEHKAAEMIAIHNIBIADJKECOHFHPPPPPPPPPPPPPPPPPPKPPPPPPPPPPPLPPPOCPPPBCKAKBCPAIAHIFKBPKKAJEBEPPIMNPPPPPPPPPPPPPPKKPPPPPPPPPPPPPPJFPPPPEIFJCOJAACDDACAAFDGCIOKPNFAHPPPPPPPPPPPPPPBKPPPPPPPPPPPPOPMHPPPFCOCFEBPIFPPPPPMMCBOFNPGFBCBPPPPPPMPPPPPPPPFIPPPPPPPPPPPPNPPPPPPPPOAEKNNKFPPPPPLGENNIANIFHKFPPPPPJPGPPPPPPKFBPPPPPPPPPPPPPPPPPPPPPEJHICEDHPPPPPPLECFCABHEPLEPPPPPFPKPPPPPPAAFPPPPPPPPPPPPPPP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" /> </div></td>';
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
	
	$("#si-guardar").click(function(){
		$("#formProyectoEvaluar").submit();
	});
	
});
