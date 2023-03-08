<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
	<title>Usuarios</title>
</head>

<body>

	<jsp:include page="navegacion.jsp"></jsp:include>
	
	<h1>Usuarios</h1>
	
	<div id=contenedorSection>
		
		<section>
	    
	    <div class="swiper mySwiper container">
	      <div class="swiper-wrapper content">
	      
		<c:forEach var="usuario" items="${usuarios}">
	        <div class="swiper-slide card">
	          <div class="card-content">
	            <div class="image">
	              <object style="height: 130px; border-radius: 100px;" data="../subidas/usuarios/${usuario.id}.jpg">
						<img style="height: 130px; border-radius: 100px;" src="../subidas/usuarios/usuario.jpg"/>	
					</object>
	            </div>
	
	            <div class="media-icons">
	              <i class="fab fa-facebook"></i>
	              <i class="fab fa-twitter"></i>
	              <i class="fab fa-github"></i>
	            </div>
	
	            <div class="name-profession">
	              <div style="margin-top:1rem;">
	             	<span class="name">${usuario.nombre}</span>
	              	<span class="name">${usuario.apellidos}</span>
	              </div>
	              <div style="text-align:start;margin-top:0.5rem;">
	              	  <span class="profession"> Dni: </span> <span class="professionDetail"> ${usuario.dni} </span> <br>
		              <span class="profession"> Email: </span> <span class="professionDetail"> ${usuario.email} </span> <br>
		              <span class="profession"> Contraseña: </span> <span class="professionDetail"> ${usuario.pass} </span> <br>
		              <span class="profession"> Edad: </span> <span class="professionDetail"> ${usuario.edad} años </span> <br>
		              <span class="profession"> Teléfono: </span> <span class="professionDetail"> ${usuario.telefono} </span> <br>
		              <span class="profession"> Provincia: </span> <span class="professionDetail"> ${usuario.provincia.nombre} </span> <br>
	              </div>
	            </div>
	
	            <div class="button">
	            	<a class="aboutMe" onclick="return confirm('¿seguro?');" href="editarUsuario?idEditar=${usuario.id}">Editar</a>
	             	<a class="hireMe" onclick="return confirm('¿seguro?');" href="borrarUsuario?idBorrar=${usuario.id}">Borrar</a>
	            </div>
	          </div>
	        </div>
	       </c:forEach> 
	       
	      </div>
	    </div>
	
	    <div class="swiper-button-next"></div>
	    <div class="swiper-button-prev"></div>
	    <div class="swiper-pagination" style="bottom: -15px;"></div>
	   
	 </section>
	</div>
	
	<div style="margin-top:4rem; text-align:center;">
		<a id="botonRegistrarUsuario" href="nuevoUsuario">
			Registrar un usuario
		</a>	
	</div>


 <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 3,
      spaceBetween: 30,
      slidesPerGroup: 3,
      loop: true,
      loopFillGroupWithBlank: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
  </script>


</body>
</html>