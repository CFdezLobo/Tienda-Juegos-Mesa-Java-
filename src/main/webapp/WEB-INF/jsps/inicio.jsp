<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="icon" type="image/png" href="imagenes/icono.png" sizes="32x32">
	<link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
	<link rel="stylesheet" href="css/styles.css">
	<title>Gametopia</title>
</head>

<body>

	<header>
		<nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    
		      <a class="navbar-brand" href="index.jsp" style="margin-left: 2rem;max-width: 10%;">
		    	<img style="width:100%;" src="imagenes/logo.png"/>
		      </a>
		    	
		      <form id="form_buscador" class="d-flex">
		        <input id="buscador_titulo" class="form-control me-2" type="search" placeholder="<spring:message code="buscador.placeholder"/>" aria-label="Buscar">
		      </form>
		      
		      <div id="contenedorIconos" style="display:flex;">
		      	<div class="dropdown" style="margin-right: 2rem;">
		      <i id="iconoUsuario" class="bi bi-person-circle" data-bs-toggle="dropdown"></i>
<!-- 		      	<button class="btn btn-secondary dropdown-toggle" type="button" -->
<!-- 							id="dropdownMenuButton1" data-bs-toggle="dropdown" -->
<!-- 							aria-expanded="false">Dropdown button</button> -->
				<form id="form_login" class="dropdown-menu p-4">
					<div class="mb-3 campoLogin">
						<label for="exampleDropdownFormEmail2" class="form-label">Email</label> 
						<input type="email" id="email" class="form-control" placeholder="email@ejemplo.com">
					</div>
					<div class="mb-3 campoLogin">
						<label for="exampleDropdownFormPassword2" class="form-label"> <spring:message code="inicio.contrasenya"/> </label>
						<input type="password" id="pass" class="form-control" placeholder="<spring:message code="inicio.contrasenya"/>">
					</div>
					<div class="mb-3 campoLogin">
						<div class="form-check">
							<input id="recordar_datos" checked type="checkbox" class="form-check-input"> 
							<label class="form-check-label"for="dropdownCheck2"> <spring:message code="inicio.recordarDatos"/> </label>
						</div>
					</div>
					<div id="perfilUsuario" class="p-4" style="display:none; text-align:center;">
						<span style="font-size: 1.1rem;">
							<spring:message code="inicio.bienvenida"/> 
						</span>
						<p id="inicio_span_nombre_usuario"> 
							<spring:message code="inicio.usuario"/> 
						</p>
						<div id="contenedorImagenPerfilUsuario">
							<img id="imagenPerfilUsuario" src="subidas/usuarios/usuario.jpg"/>
						</div>
					</div>
				 <button id="boton_login" type="submit" class="btn btn-primary"> <spring:message code="inicio.iniciaSesion"/> </button>
				 <button id="boton_logout" type="button" class="btn btn-primary" style="display:none;"> <spring:message code="inicio.cierraSesion"/> </button>
				 <div id="contenedor_registrarme" class="text-center">
       				 <p> <spring:message code="inicio.noTienesCuenta"/> 
       				 	<a id="registrarme" href="#"> <spring:message code="inicio.registrarme"/> </a>
       				 </p>
      			 </div>
				 </form>
			  </div>
			  
			  <div class="dropdown">
		      	<i id="carrito" class="bi bi-cart-fill" data-bs-toggle="dropdown"></i>
			  </div>
		      </div>
			  
		      <div style="margin:10px;">
				<a href="?lang=es"> <img id="imagen_bandera" src="imagenes/espana.png"/> </a>
				<a href="?lang=en"> <img id="imagen_bandera" src="imagenes/reino_unido.png"/> </a>
				<a href="?lang=ge"> <img id="imagen_bandera" src="imagenes/alemania.png"/> </a>
			  </div>
		    </div>
		  </div>
		</nav>
	
	</header>

	<main>
		<div id="contenedor"></div>
		
		<div id=contenedorCargando style="display:none;">
			<svg version="1.1" id="loader-1" xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
				width="40px" height="40px" viewBox="0 0 40 40"
				enable-background="new 0 0 40 40" xml:space="preserve">
	  		<path opacity="0.2" fill="#000"
					d="M20.201,5.169c-8.254,0-14.946,6.692-14.946,14.946c0,8.255,6.692,14.946,14.946,14.946
	   					s14.946-6.691,14.946-14.946C35.146,11.861,28.455,5.169,20.201,5.169z M20.201,31.749c-6.425,0-11.634-5.208-11.634-11.634
	    				c0-6.425,5.209-11.634,11.634-11.634c6.425,0,11.633,5.209,11.633,11.634C31.834,26.541,26.626,31.749,20.201,31.749z"></path>
	  		<path fill="#000"
					d="M26.013,10.047l1.654-2.866c-2.198-1.272-4.743-2.012-7.466-2.012h0v3.312h0
	    			C22.32,8.481,24.301,9.057,26.013,10.047z">
	    	<animateTransform attributeType="xml" attributeName="transform"
					type="rotate" from="0 20 20" to="360 20 20" dur="0.5s"
					repeatCount="indefinite"></animateTransform>
	   		 </path>
	  		</svg>
		</div>
		
	</main>
	
	<div id="contenedorFooter" style="bottom:0; position:static; display:block;">
	  <footer class="py-5 container">
	    <div class="row">
	      <div class="col-6 col-md-2 mb-3">
	        <h5 style="text-align:center;">Contacto</h5>
	        <ul class="nav flex-column">
	          <li id="listaContacto" class="nav-item mb-2"><i class="bi bi-telephone-fill"></i><a href="#" class="nav-link p-0 text-muted">+34 612345789</a></li>
	          <li id="listaContacto" class="nav-item mb-2"><i class="bi bi-envelope-fill"></i><a href="#" class="nav-link p-0 text-muted">info@gametopia.com</a></li>
	          <li id="listaContacto" class="nav-item mb-2"><i class="bi bi-signpost-fill"></i><a href="#" class="nav-link p-0 text-muted">C/Donoso Cortés, 61</a></li>
	          <li id="listaContacto" class="nav-item mb-2"><i class="bi bi-geo-alt-fill"></i><a href="#" class="nav-link p-0 text-muted">Mapa</a></li>
	        </ul>
	      </div>
	
	      <div class="col-6 col-md-2 mb-3">
	        <h5 style="text-align:center;">Redes sociales</h5>
	        <ul class="nav flex-column">
	          <li id="listaRedSocial" class="nav-item mb-2"><i class="bi bi-twitter"></i><a id="iconoRedSocial" href="#" class="nav-link p-0 text-muted">Twitter</a></li>
	          <li id="listaRedSocial" class="nav-item mb-2"><i class="bi bi-instagram"></i><a id="iconoRedSocial" href="#" class="nav-link p-0 text-muted">Instagram</a></li>
	          <li id="listaRedSocial" class="nav-item mb-2"><i class="bi bi-facebook"></i><a id="iconoRedSocial" href="#" class="nav-link p-0 text-muted">Facebook</a></li>
	          <li id="listaRedSocial" class="nav-item mb-2"><i class="bi bi-youtube"></i><a id="iconoRedSocial" href="#" class="nav-link p-0 text-muted">Youtube</a></li>
	        </ul>
	      </div>
	
	      <div class="col-6 col-md-2 mb-3">
	        <h5 style="text-align:center;">Mapa web</h5>
	        <ul class="nav flex-column">
	          <li class="nav-item mb-2"><a href="index.jsp" class="nav-link p-0 text-muted" style="text-align:center;">Inicio</a></li>
	<!--           <li class="nav-item mb-2"><a id="registrarme" href="#" class="nav-link p-0 text-muted">Registrarse</a></li> -->
	<!--           <li class="nav-item mb-2"><a id="carrito" href="#" class="nav-link p-0 text-muted">Carrito</a></li> -->
	<!--           <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li> -->
	<!--           <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Nosotros</a></li> -->
	        </ul>
	      </div>
	
	      <div class="col-md-5 offset-md-1 mb-3" id="seccionFooter">
	        <form>
	          <h5>Suscribite a nuestro newsletter</h5>
	          <p>Consigue todas las novedades mensuales y descuentos</p>
	          <div class="d-flex flex-column flex-sm-row w-100 gap-2">
	            <label for="newsletter1" class="visually-hidden">Email</label>
	            <input id="newsletter1" type="text" class="form-control" placeholder="Email">
	            <button class="btn btn-primary" type="button">Suscribirse</button>
	          </div>
	        </form>
	      </div>
	    </div>
	
	    <div id="contenedorCopyRight" class="d-flex flex-column flex-sm-row justify-content-center py-4 my-4 border-top">
	      <p>© 2022 Carlos Fernández Lobo</p>
	    </div>
	  </footer>
 </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript" src="librerias_js/jquery.js"></script>
<script type="text/javascript" src="librerias_js/mustache.js" ></script>
<script type="text/javascript" src="librerias_js/js.cookie.min.js" ></script>
<script type="text/javascript" src="javascript/cargar_plantillas.js"></script>
<script type="text/javascript" src="javascript/cargar_eventos.js"></script>
<script type="text/javascript" src="javascript/funciones.js"></script>
<script type="text/javascript" src="javascript/funciones_checkout.js"></script>
<script type="text/javascript" src="javascript/globales.js"></script>
<script type="text/javascript" src="javascript/validaciones.js"></script>
<script type="text/javascript">
	idioma_actual = "<spring:message code="codigo.idioma" />" ;
	carga_archivos_plantillas(idioma_actual);
</script>

</body>

</html>