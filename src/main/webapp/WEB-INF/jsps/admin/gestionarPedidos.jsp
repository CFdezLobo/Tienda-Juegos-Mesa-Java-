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
	<title>Gestionar pedidos</title>
</head>
<body>

	<jsp:include page="navegacion.jsp"></jsp:include>
	
	<h1 style="text-align:center;margin:1rem;">Listado de pedidos</h1>
	
	<div class="row row-cols-5 gx-0" style="justify-content:center;">
		<c:forEach var="pedido" items="${pedidos}">
			<div class="card col fichaPedido" style="margin: 1rem; border: none !important;">
				<div class="enlace_detalles card-body" style="text-align:center; z-index: 98;padding-bottom: 0rem; margin-top: 1rem;">
					<h4 class="card-title">Pedido: ${pedido.id} </h4>
				</div>
					<ul class="list-group list-group-flush" style="text-align: start; padding: 1rem;">
						<li class="list-group-item"> <span id="tituloEspecificacion"> Nombre: </span> ${pedido.nombre} </li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Apellidos: </span> ${pedido.apellidos} </li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Dirección: </span> ${pedido.direccion}</li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Provincia: </span> ${pedido.provincia} </li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Código Postal: </span> ${pedido.cp} </li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Precio: </span> ${pedido.precioTotal} €</li>
						<li class="list-group-item"> <span id="tituloEspecificacion"> Estado: </span>  ${pedido.estado} </li>
					</ul>
				<div id="contenedorBotonesGestionarPedidos" style="text-align:center; padding-bottom: 1.5rem;">
					<a href="verDetallesPedido?id=${pedido.id}" class="btn btn-primary"> Detalles </a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>