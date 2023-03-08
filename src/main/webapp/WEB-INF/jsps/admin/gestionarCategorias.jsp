<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<title>Gestionar categorias</title>
</head>
<body>
	
	<jsp:include page="navegacion.jsp"></jsp:include>
	
	<h1 style="text-align:center;margin:1rem;">Listado de categorias</h1>
	
	<div class="row row-cols-5 gx-0" style="justify-content:center;">
		<c:forEach var="categoria" items="${categorias}">
			<div class="card col fichaPedido" style="margin: 1rem; border: none !important;">
				<div class="enlace_detalles card-body" style="text-align:center; z-index: 98;padding: 1rem; margin-top: 1rem;">
					<h4 class="card-title">${categoria.nombre} </h4>
					<span id="tituloEspecificacion" style="display:flex;margin-left: 1rem; margin-top: 1rem;">Descripcion: </span>
					<p style="text-align:justify;margin-top:1rem;padding: 0rem 1rem; font-weight:400;">${categoria.descripcion}</p>
				</div>
				
				<div id="contenedorBotonesGestionarJuegos" style="text-align:center; padding-bottom: 1.5rem;">
					<a href="editarCategoria?idEditar=${categoria.id}" class="btn btn-primary" onclick="return confirm('¿seguro?');">
		            	Editar
		        	</a>
<%-- 					 <a href="borrarCategoria?idBorrar=${categoria.id}" class="btn btn-primary" onclick="return confirm('¿seguro?');"> --%>
<!-- 		            	Borrar -->
<!-- 		        	</a> -->
				</div>
			</div>
		</c:forEach>
	</div>
	
	<div style="margin: 2rem; text-align:center;padding-bottom:7rem;">
		<a href="nuevaCategoria" class="btn btn-primary" style="height:40px;width:15%;font-weight:600;">REGISTRAR CATEGORIA</a>	
	</div>
	
</body>
</html>