// Funciones de caracter genérico
function mostrar_productos(){
	$("#contenedor").html(plantillas.productos);
	comienzo = 0;
	titulo_buscar = "";
	$("#form_buscador").submit(
		function(){
			titulo_buscar = $("#buscador_titulo").val();
			refresca_listado();
		}
	);
	$("#buscador_titulo").keyup(
		function(){
			comienzo = 0;
			titulo_buscar = this.value;
			refresca_listado();
		}
	);
	
	$("#enlace_anterior").click(
		function(){
			comienzo -= 8
			refresca_listado();
		}
	);
	$("#enlace_siguiente").click(
		function(){
			comienzo += 8; 
			refresca_listado();
		}	
	);	
	refresca_listado();
}

function refresca_listado(){
	
	if( comienzo <= 0 ){
		$("#enlace_anterior").hide();
	}else{
		$("#enlace_anterior").show();
	}
	
	$.get("ServicioWebJuegos/obtenerJuegos",{
		nombre: titulo_buscar,
		comienzo: comienzo
	}).done( 
		function(res){
			res = JSON.parse(res);
			let juegos = res.juegos;
			let total_juegos = res.total;
			
			if( comienzo + 10 > total_juegos ){
				$("#enlace_siguiente").hide();
			}else{
				$("#enlace_siguiente").show();
			}								
			$("#productos_listado").html(Mustache.render(plantillas.productos_listado,juegos));
			$("#total_juegos").html(total_juegos);
			$(".enlace_detalles").click(mostrar_detalles);
			$(".enlace_comprar").click(comprar_producto);
		}
	);
}

function mostrar_detalles(){
	let id = $(this).attr("id_producto");
	$.get("ServicioWebJuegos/obtenerJuegoPorId?id=" + id, function(res){
		res = JSON.parse(res);
		$("#contenedor").html(Mustache.render(plantillas.detalles_juego,res));
		$(".enlace_comprar").click(comprar_producto);
	});
}

function comprar_producto(){
	if(nombre_login == ""){
		alert("Debes identificarte para poder comprar producto");
	}else{
		var id = $(this).attr("id_producto");
		var cantidad = $("#input-cantidad-"+id).val();
		$.post("ServicioWebCarrito/agregaJuego", 
			{
				idProducto: id,
				cantidad: cantidad
			}
		).done(function(res){
			alert(res);
		});
	}
}

function mostrar_productos_carrito(){
	if(nombre_login == ""){
		alert("Debes identificarte para consultar el carrito");
		return;
	}
	$.get("ServicioWebCarrito/obtenerProductosCarrito",function(res){
		res = JSON.parse(res);
		if(res == null || res.length == 0){
			alert("Carrito vacio");
			mostrar_productos();
		}else{	
			$("#contenedor").html(Mustache.render(plantillas.carrito,res));
			
			$(".input_cantidad").change(function(){
				let id = $(this).attr("id_producto");
				let cantidad = $("#input-cantidad-"+id).val();
				$.post("ServicioWebCarrito/modificarCantidadProductoCarrito", 
					{
						idProducto: id,
						cantidad: cantidad
					}
				).done(function(res){
					alert(res);
				});			
			});
			
			$(".enlace_detalles").click(mostrar_detalles);
			
			$(".enlace_borrar_producto").click(function(){
				let id = $(this).attr("id-producto");
				borrar_producto_carrito(id);
			});
			
			$("#realizar_pedido").click(function(){
				checkout_paso_1();
			});		
		}		
	});
}

function borrar_producto_carrito(id){
	$.post("ServicioWebCarrito/borrarJuego", 
		{
			idProducto: id
		}
	).done(function(res){
		alert(res);
		mostrar_productos_carrito();
	});
}


function identificar_usuario(){
	var email = $("#email").val();
	var pass = $("#pass").val();
	$.ajax("ServicioWebUsuarios/identificarUsuario", {
		type: "POST",
		data: "email=" + email + "&pass=" + pass,
		success: function(res){
			var respuesta = res.split(",")[0];
			var mensaje = res.split(",")[1];
			var id = res.split(",")[2];
			if(respuesta == "ok"){
				if ( $("#recordar_datos").prop("checked") ){
					Cookies.set('email',email, { expires:100 });
					Cookies.set('pass',pass, { expires:100 });
				}
				alert("Bienvenido" + mensaje + ", ya puedes comprar");
				nombre_login = mensaje;
				mostrar_productos();
				$("#inicio_span_nombre_usuario").html(nombre_login);
				$("#imagenPerfilUsuario").attr("src","subidas/usuarios/"+id+".jpg");
				$("#login").hide();
				$("#registrarme").hide();
				$("#logout").show();
				
				$(".campoLogin").css("display","none");
				$("#perfilUsuario").css("display","block");
				$("#boton_login").css("display","none");
				$("#boton_logout").css("display","inline-block");
				$("#contenedor_registrarme").css("display","none");
			}else if(respuesta == "error"){
				alert(mensaje);
			}
		}
	});
}

function logout(){
	$.ajax("ServicioWebUsuarios/logout", {
		success: function(res){
			if(res == "ok"){
				alert("Hasta pronto");
				nombre_login = "";
				$("#login").show();
				$("#registrarme").show();
				$("#logout").hide();
				
				$("#perfilUsuario").css("display","none");
				$(".mb-3").css("display","block");
				$("#boton_logout").css("display","none");
				$("#boton_login").css("display","inline-block");
				$("#contenedor_registrarme").css("display","inline-block");
				
				mostrar_productos();
			}
		}
	});
}

function changeImage(element) {
	var main_prodcut_image = document.getElementById('main_product_image');
	main_prodcut_image.src = element.src;
}


