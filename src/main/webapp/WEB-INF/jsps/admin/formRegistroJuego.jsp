<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
	<title>Registrar juego</title>
</head>
<body>

<jsp:include page="navegacion.jsp"></jsp:include>

<h4 style="text-align:center;margin-top:3rem;">Introduce los datos:</h4>

<div style="display:flex;justify-content:center;margin-top:3rem;">
	<springform:form modelAttribute="juego" action="guardarNuevoJuego" enctype="multipart/form-data" class="row g-3" style="width:40%;text-align:start;">
		<div class="col-md-1 contenedorCheckBox">
			<label class="form-label">Alta</label>
			<springform:checkbox path="alta" class="form-check-input"/>		
		</div>
		<div class="col-md-6">
			<label class="form-label">Nombre</label> 
			<springform:input path="nombre" class="form-control"/> 
			<p style="color: red"> <springform:errors path="nombre" /> </p>
		</div>
		<div class="col-md-5">
			<label class="form-label">Idioma</label>
			<springform:input path="idioma" class="form-control"/>
		</div>
		<div class="col-md-4">
			<label class="form-label">Precio</label> 
			<springform:input path="precio" class="form-control"/>
			<p style="color: red"> <springform:errors path="precio" /> </p> 
		</div>
		<div class="col-md-4">
			<label class="form-label">Dificultad</label> 
			<springform:input path="dificultad" class="form-control"/>
		</div>
		<div class="col-md-4">
			<label class="form-label">Nº de jugadores</label> 
			<springform:input path="nJugadores" class="form-control"/>
		</div>
		<div class="col-md-4">
			<label class="form-label">Duracion</label> 
			<springform:input path="duracion" class="form-control"/>
		</div>
		<div class="col-md-8">
			<label for="inputProvincia" class="form-label">Categoria</label> 
			<springform:select path="idCategoria" class="form-select">
				<springform:options items="${categorias}"/>
			</springform:select>
		</div>
		<div class="col-md-6">
			<label class="form-label">Imagen 1</label> 
			<springform:input path="portada" type="file" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label class="form-label">Imagen 2</label> 
			<springform:input path="contraportada" type="file" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label class="form-label">Imagen 3</label> 
			<springform:input path="juegoDesplegado1" type="file" class="form-control"/>
		</div>
		<div class="col-md-6">
			<label class="form-label">Imagen 4</label> 
			<springform:input path="juegoDesplegado2" type="file" class="form-control"/>
		</div>
			<div class="col-md-12">
			<label class="form-label">Descripción</label> 
			<springform:textarea path="descripcion" class="form-control" rows="8"/>
		</div>
		<div class="col-12" style="display: flex;justify-content: space-around;margin-top: 3rem;">
			<springform:hidden path="id"/>
			<input type="submit" class="btn btn-primary" value="GUARDAR CAMBIOS" onclick="return confirm('¿seguro?');" style="width: 30%;"/>
			<a href="gestionarJuegos" class="btn btn-primary" style="width: 30%;">VOLVER</a>
		</div>
	</springform:form>
</div>

</body>
</html>