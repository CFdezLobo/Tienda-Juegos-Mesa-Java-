<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
	<title>Juegos</title>
</head>
<body>

<jsp:include page="navegacion.jsp"></jsp:include>

<h1 style="text-align:center;margin:1rem;">Juegos</h1>

<div>
	<form action="gestionarJuegos" style="display:flex;justify-content:center;margin:2rem;">
		<input type="text" name="nombre" class="form-control me-2" placeholder="Buscar juego" value="${nombre}" style="width:20%;"/>
		<input id="buscador_titulo" class="btn btn-primary" type="submit" value="BUSCAR">	 
	</form>
</div>


<div class="row row-cols-5 gx-0" style="justify-content:center;">
	<c:forEach var="juego" items="${juegos}" >
		<div class="card col fichaJuego" style="margin: 1rem; border: none !important; border-radius: 0px !important;">
			<div class="enlace_detalles" style="display: flex; justify-content:center; margin-top: 2rem; z-index: 98;">
				<object style="height: 150px;" data="../subidas/juegos/${juego.id}-1.jpg?fai=${juego.fechaImagenPortada}">
					<img style="height: 150px;" src="../subidas/juegos/juego.png"/>	
				</object>
					<object style="height: 150px;" data="../subidas/juegos/${juego.id}-2.jpg?fai=${juego.fechaImagenContraPortada}">
					<img style="height: 150px;" src="../subidas/juegos/juego.png"/>
				</object>
			</div>
			<div class="enlace_detalles card-body" style="text-align:center; z-index: 98;padding-bottom: 0rem; margin-top: 1rem;">
				<h4 class="card-title">${juego.nombre} </h4>
			</div>
				<ul class="list-group list-group-flush" style="text-align: start; padding: 1rem;">
					<li class="list-group-item"> <span id="tituloEspecificacion"> Precio: </span> ${juego.precio} € </li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Jugadores: </span> ${juego.nJugadores} jugadores </li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Duracion: </span> ${juego.duracion} min.</li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Dificultad: </span> ${juego.dificultad} </li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Idioma: </span> ${juego.idioma} </li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Categoria: </span>  ${juego.categoria.nombre} </li>
					<li class="list-group-item"> <span id="tituloEspecificacion"> Alta: </span>  ${juego.alta} </li>
				</ul>
			<div id="contenedorBotonesGestionarJuegos" style="text-align:center; padding-bottom: 1.5rem;">
				<a href="editarJuego?idEditar=${juego.id}" class="btn btn-primary" onclick="return confirm('¿seguro?');">
	            	Editar
	        	</a>
				 <a href="borrarJuego?idBorrar=${juego.id}" class="btn btn-primary" onclick="return confirm('¿seguro?');">
	            	Borrar
	        	</a>
			</div>
		</div>
	</c:forEach>
</div>

<div style="text-align:center;margin:3rem">
	<span style="font-weight:600">Total resultados:</span>
	<span id="total_juegos">${total}</span>
	<div style="margin-top:1rem;">
		<c:if test="${anterior >= 0}">
			<a href="gestionarJuegos?comienzo=${anterior}&nombre=${nombre}" class="btn btn-primary">Anterior</a> &nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${siguiente < total}">
			<a href="gestionarJuegos?comienzo=${siguiente}&nombre=${nombre}" class="btn btn-primary">Siguiente</a>
		</c:if>
	</div> 
</div>

<div style="margin: 2rem; text-align:center;padding-bottom:7rem;">
	<a href="nuevoJuego" class="btn btn-primary" style="height:40px;width:15%;font-weight:600;">REGISTRAR JUEGO</a>	
</div>

</body>
</html>