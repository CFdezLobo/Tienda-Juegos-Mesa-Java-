let regexp_nombre = /^[a-z áéíóúñ]{2,10}$/i;
let regexp_apellidos = /^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$/i;
let regexp_pass = /^[a-z0-9áéíóú]{3,10}$/i;
let regexp_email = /^([a-z0-9_.-]+)@([a-z0-9_.-]+)\.([a-z.]{2,6})$/i;
let regexp_nif = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;
let regexp_nie = /^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;
let regexp_cp = /^(?:0[1-9]|[1-4]\d|5[0-2])\d{3}$/;
let regexp_tarjeta = /^[0-9]{13,18}$/i;

function validarNombre(nombre){
	if( regexp_nombre.test(nombre) ){
		$(".mensajeNombre").css("display","none");
		return true;
	}else{
		//alert("Nombre incorrecto");
		$(".mensajeNombre").css("display","block");
		$(".mensajeNombre").html("Nombre incorrecto");
		return false;
	}
}

function validarApellidos(apellidos){
	if( regexp_apellidos.test(apellidos) ){
		$(".mensajeApellidos").css("display","none");
		return true;
	}else{
		//alert("Apellidos incorrectos");
		$(".mensajeApellidos").css("display","block");
		$(".mensajeApellidos").html("Apellidos incorrectos");
		return false;
	}
}

function validarEmail(email){
	if( regexp_email.test(email) ){
		$(".mensajeEmail").css("display","none");
		return true;
	}else{
		//alert("Email incorrecto");
		$(".mensajeEmail").css("display","block");
		$(".mensajeEmail").html("Email incorrecto");
		return false;
	}
}

function validarPass(pass){
	if( regexp_pass.test(pass) ){
		$(".mensajePass").css("display","none");
		return true;
	}else{
		//alert("Pass incorrecto");
		$(".mensajePass").css("display","block");
		$(".mensajePass").html("Contraseña incorrecta");
		return false;
	}
}

function validarDni(dni){
	if( regexp_nif.test(dni) || regexp_nie.test(dni)){
		$(".mensajeDni").css("display","none");
		return true;
	}else{
		//alert("Dni incorrecto");
		$(".mensajeDni").css("display","block");
		$(".mensajeDni").html("Dni incorrecto");
		return false;
	}
}

function validarEdad(edad){
	if( edad >= 1 && edad <= 100){
		$(".mensajeEdad").css("display","none");
		return true;
	}else{
		//alert("Edad incorrecta");
		$(".mensajeEdad").css("display","block");
		$(".mensajeEdad").html("Edad incorrecta");
		return false;
	}
}

function validarDireccion(direccion){
	if(direccion != ""){
		$(".mensajeDireccion").css("display","none");
		return true;
	}else{
		//alert("Direccion incorrecta");
		$(".mensajeDireccion").css("display","block");
		$(".mensajeDireccion").html("Complete la direccion");
		return false;
	}
}

function validarProvincia(provincia){
	if(provincia > 0){
		$(".mensajeProvincia").css("display","none");
		return true;
	}else{
		//alert("Provincia incorrecta");
		$(".mensajeProvincia").css("display","block");
		$(".mensajeProvincia").html("Seleccione una provincia");
		return false;
	}
}


function validarCp(cp){
	if(regexp_cp.test(cp)){
		$(".mensajeCP").css("display","none");
		return true;
	}else{
		//alert("Codigo Postal incorrecta");
		$(".mensajeCP").css("display","block");
		$(".mensajeCP").html("Código postal incorrecto");
		return false;
	}
}

function validarTarjetaCredito(tarjeta){
	if(regexp_tarjeta.test(tarjeta)){
		$(".mensajeNumeroTarjeta").css("display","none");
		return true;
	}else{
		//alert("Número de tarjeta incorrecto");
		$(".mensajeNumeroTarjeta").css("display","block");
		$(".mensajeNumeroTarjeta").html("Número de tarjeta incorrecto");
		return false;
	}
}

