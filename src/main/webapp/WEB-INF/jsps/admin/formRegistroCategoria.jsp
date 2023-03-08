<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
	<title>Registrar categoria</title>
</head>
<body>

<jsp:include page="navegacion.jsp"></jsp:include>

	<h4 style="text-align:center;margin-top:3rem;">Introduce los datos:</h4>
	
	<div style="display:flex;justify-content:center;margin-top:3rem;">
		<springform:form modelAttribute="categoria" action="guardarNuevaCategoria" class="row g-3" style="width:50%; text-align:start; display:flex; flex-direction: column; align-items: center;">
			<div class="col-md-6">
				<label class="form-label">Nombre</label> 
				<springform:input type="text" path="nombre" class="form-control"/>
			</div>
			<div class="col-md-6">
				<label class="form-label">Descripción</label>
				<springform:textarea path="descripcion" class="form-control" rows="8"/> 
			</div>
			<div class="col-8" style="display: flex;justify-content: space-around;margin-top: 3rem;">
				<springform:hidden path="id"/>
				<input type="submit" class="btn btn-primary" value="GUARDAR CAMBIOS" onclick="return confirm('¿seguro?');" style="width: 30%;"/>
				<a href="gestionarCategorias" class="btn btn-primary" style="width: 30%;">VOLVER</a>
			</div>
		</springform:form>
	</div>

</body>
</html>