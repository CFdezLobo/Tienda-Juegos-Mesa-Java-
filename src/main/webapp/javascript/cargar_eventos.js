function cargarEventos(){
	
	$("#inicio").click(function(){
		mostrar_productos();
		$("#inicio").addClass("active");
		$("#carrito").removeClass("active");
		$("#login").removeClass("active");
		$("#registrarme").removeClass("active");
	});

	$("#carrito").click(function(){
		mostrar_productos_carrito();
	});
	
	$("#form_login").submit(function(e){
		e.preventDefault();
		identificar_usuario();
	});
	
	$("#boton_logout").click(function(){
		logout();
	});

	$("#registrarme").click(function(){
		$("#contenedor").html(plantillas.registrarme);
		$("#form_registro_usuario").submit(function(e){
			e.preventDefault();	
			let formulario = this;
			let formData = new FormData(formulario);
			
			if( !validarNombre(formData.get("nombre")) ||
				!validarApellidos(formData.get("apellidos")) ||
				!validarEmail(formData.get("email")) ||
				!validarPass(formData.get("pass")) ||
				!validarDni(formData.get("dni")) ||
				!validarEdad(formData.get("edad")) ||
				!validarProvincia($("#provincia").val()))
			{
				return false;
			}
			
			$.ajax("ServicioWebUsuarios/registrarUsuario", {
				type: "POST",
				data: formData,
				cache: false,
				contentType: false,
				processData: false,
				success: function(res){
					if(res == "ok"){
						alert("Ya puedes identificarte con tus datos");
						mostrar_productos();
					}else{
						alert(res);	
					}
				}
			});	
		});
	});
	
}//cargar eventos
