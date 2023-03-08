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
	<title>Detalles pedido</title>
</head>
<body>

	<jsp:include page="navegacion.jsp"></jsp:include>
	
	<h4 style="text-align:center;margin-top:3rem;">Detalles del pedido</h4>

	<div style="display:flex;justify-content:center;margin-top:3rem;">
		<div class="row g-3" style="width:40%;text-align:start;">
			<div class="col-md-2">
				<label class="form-label">Pedido:</label>
				<label class="form-control">${pedido.id}</label>
			</div>
			<div class="col-md-4">
				<label class="form-label">Nombre</label> 
				<label class="form-control">${pedido.nombre}</label>
			</div>
			<div class="col-md-6">
				<label class="form-label">Apellidos</label> 
				<label class="form-control">${pedido.apellidos}</label>
			</div>
			<div class="col-md-5">
				<label class="form-label">Direccion</label> 
				<label class="form-control">${pedido.direccion}</label> 
			</div>
			<div class="col-md-4">
				<label class="form-label">Provincia</label> 
				<label class="form-control">${pedido.provincia}</label> 
			</div>
			<div class="col-md-3">
				<label class="form-label">Código Postal</label> 
				<label class="form-control">${pedido.cp}</label> 
			</div>
			<div class="col-md-6">
				<label class="form-label">Titular de la tarjeta</label> 
				<label class="form-control">${pedido.titularTarjeta}</label> 
			</div>
			<div class="col-md-6">
				<label class="form-label">Nº de la tarjeta</label> 
				<label class="form-control">${pedido.numeroTarjeta}</label> 
			</div>
			<div class="col-md-12">
				<label class="form-label">Observaciones</label> 
				<textarea class="form-control" rows="4">${pedido.observaciones}</textarea> 
			</div>
			<label class="form-label" style="font-weight:600;">Productos:</label> 
			<c:forEach var="pp" items="${pedido.productosPedido}">
				<div class="col-md-6">
					<label class="form-label">Nombre</label> 
					<label class="form-control">${pp.juego.nombre}</label> 
				</div>
				<div class="col-md-4">
					<label class="form-label">Precio/unidad</label> 
					<label class="form-control">${pp.juego.precio} €</label> 
				</div>
				<div class="col-md-2">
					<label class="form-label">Cantidad</label> 
					<label class="form-control">${pp.cantidad}</label> 
				</div>
			</c:forEach>
			<div class="col-md-8">
				<label class="form-label">Estado del pedido</label> 
				<select id="select_estado" class="form-select">
					<c:forEach var="estado" items="${estados}">
						<option
							<c:if test="${estado.key == pedido.estado}">
								selected = "selected"
							</c:if>
								value="${estado.key}">${estado.value}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<label class="form-label">Precio Total</label> 
				<label class="form-control">${pedido.precioTotal} €</label> 
			</div>		
		</div>
	</div>
	
	<div style="display:flex;justify-content:center;padding:4rem;">
		<a href="gestionarPedidos" class="btn btn-primary" style="width: 10%;">VOLVER</a>
	</div>

	<input type="hidden" id="id_pedido" value="${pedido.id}" />

	<script type="text/javascript" src="../librerias_js/jquery.js"></script>
	<script type="text/javascript">
		$("#select_estado").change(function(e){
			//obtener el estado seleccionado y mandarlo a un servicio web
			let estado = $(this).find(":selected").val();
			let idPedido =  $("#id_pedido").val();
			$.post("ServicioWebPedidosAdmin/actualizarEstadoPedido",{
						id: idPedido,
						estado : estado
			}).done(function(res){
				alert(res);
			});
			
		});	
	</script>
	
</body>
</html>