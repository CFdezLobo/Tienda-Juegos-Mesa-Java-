<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
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
	<title>Registrar usuario</title>
</head>

<body>

<jsp:include page="navegacion.jsp"></jsp:include>

<h4 style="text-align:center;margin-top:3rem;">Introduce los datos:</h4>

<div style="display:flex;justify-content:center;margin-top:3rem;">
	<springform:form modelAttribute="usuario" action="guardarNuevoUsuario" class="row g-3" style="width:50%;text-align:start;">
		<div class="col-md-6">
			<label for="inputEmail" class="form-label">Email</label> 
			<springform:input a="f" type="email" path="email" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label for="inputPassword" class="form-label">Contraseña</label>
			<springform:input path="pass" class="form-control"/> 
		</div>
		<div class="col-md-6">
			<label for="inputNombre" class="form-label">Nombre</label> 
			<springform:input path="nombre" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label for="inputApellidos" class="form-label">Apellidos</label> 
			<springform:input path="apellidos" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label for="inputDni" class="form-label">DNI</label> 
			<springform:input path="dni" class="form-control" maxlength="9"/>
		</div>
		<div class="col-md-6">
			<label for="inputTelefono" class="form-label">Teléfono</label> 
			<springform:input path="telefono" class="form-control" maxlength="9"/>
		</div>
		<div class="col-md-6">
			<label for="inputProvincia" class="form-label">Provincia</label> 
			<springform:select class="form-select" path="idProvincia">
				<springform:options items="${provincias}"/>
			</springform:select>
		</div>
		<div class="col-md-6">
			<label for="inputEdad" class="form-label">Edad</label> 
			<springform:input path="edad" class="form-control"/>
		</div>
		<div class="col-12" style="display: flex;justify-content: space-around;margin-top: 3rem;">
			<input type="submit"  class="btn btn-primary" value="REGISTRARME" onclick="return confirm('¿seguro?');" style="width: 30%;"/>
			<a href="gestionarUsuarios" class="btn btn-primary" style="width: 30%;">VOLVER</a>
		</div>
	</springform:form>
</div>

</body>
</html>