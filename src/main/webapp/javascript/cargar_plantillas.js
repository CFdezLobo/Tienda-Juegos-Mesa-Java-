var plantillas = {};
var intervalo = null;

function carga_archivos_plantillas(idioma){
	$.get("ServicioWebPlantillas",function(res){
		var arr = JSON.parse(res);
		for(i in arr){
			var nombre_archivo = arr[i].split(".")[0];
			plantillas[nombre_archivo] = "";
		}
//		console.log("contenido del objeto plantillas");
//		console.log(plantillas);
		cargarPlantillas(idioma);
	});
}

function cargarPlantillas(idioma){
	var carpeta = "plantillas";
	if(idioma == "en"){
		carpeta = "plantillas_en";
	}else if(idioma == "ge"){
		carpeta = "plantillas_ge";
	}
	for (i in plantillas){
		var plantilla_a_cargar = carpeta + "/" + i + ".html";
		$.ajax(plantilla_a_cargar,
				{
					parametro : i,
					success: function(res ){
						plantillas[this.parametro] = res;
					}
				}
		);
	}
	$("#contenedor").html($("#contenedorCargando").html());
	intervalo = setInterval(comprobarPlantillas,1000);
}

function comprobarPlantillas(){
	var listo = true;
	for(i in plantillas){
		if ( plantillas[i] == "" ){
			listo = false;
		}
	}
	if( listo ){
		mostrar_productos();
		cargarEventos();
		clearInterval(intervalo);
	}
}
