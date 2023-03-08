// Funciones de js para los pasos del checkout

function checkout_paso_1(){
	$("#contenedor").html(plantillas.checkout_1);
	$("#aceptar_paso_1").click(function(){
		let nombre = $("#campo_nombre").val();
		let apellidos = $("#campo_apellidos").val();
		let direccion = $("#campo_direccion").val();
		let provincia = $("#campo_provincia").find('option:selected').text();
		let cp = $("#campo_cp").val();
		
		$.post("ServicioWebPedidos/paso1",
			{
				nombre: nombre,
				apellidos: apellidos,
				direccion: direccion,
				provincia: provincia,
				cp: cp
			}
		).done(function(res){
			if(res == "ok"){
				if( !validarNombre($("#campo_nombre").val()) ||
					!validarApellidos($("#campo_apellidos").val()) ||
					!validarDireccion($("#campo_direccion").val()) ||
					!validarProvincia($("#campo_provincia").val()) ||
					!validarCp($("#campo_cp").val()))
				{
					return false;
						
				}else{	
					checkout_paso_2();
				}
			}else{
				alert(res);
			}
		});
	});
}

function checkout_paso_2(){
	$("#contenedor").html(plantillas.checkout_2);
	$("#aceptar_paso_2").click(function(){
		$.post("ServicioWebPedidos/paso2",
			{
				titular: $("#titular_tarjeta").val(),
				numero: $("#numero_tarjeta").val()
			}
		).done(function(res){
			if(res == "ok"){
				if( !validarApellidos($("#titular_tarjeta").val()) ||
					!validarTarjetaCredito(parseInt($("#numero_tarjeta").val())))
				{
					return false;	
				}else{
					checkout_paso_3();
				}
			}else{
				alert(res);
			}
		});
	});
}

function checkout_paso_3(){
	$("#contenedor").html(plantillas.checkout_3);
	$("#aceptar_paso_3").click(function(){
		$.post("ServicioWebPedidos/paso3",{
			observaciones: $("#observaciones").val()
		}).done(function(res){
			if(res.substring(0,2) == "ok"){
				let json = JSON.parse(res.substring(3,res.length));
				let html = Mustache.render(plantillas.checkout_4,json);
				$("#contenedor").html(html);
				$("#editarPedido").click(function(){
					mostrar_productos_carrito();
				});
				$("#boton_confirmar_pedido").click(checkout_confirmar);

			}
		});
	});
}


function checkout_confirmar(){
	$.ajax("ServicioWebPedidos/confirmarPedido",{
		success : function(res){
			alert(res);
			mostrar_productos();
		}
	});
}