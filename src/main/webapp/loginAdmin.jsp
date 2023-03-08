<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/loginAdmin.css">
<title>Administracion</title>
</head>
<body>

	<div class="section">
		<div class="container">
			<div class="row full-height justify-content-center">
				<div class="col-12 text-center align-self-center py-5">
					<div class="section pb-5 pt-5 pt-sm-2 text-center">
						<div class="card-3d-wrap mx-auto">
							<div class="card-3d-wrapper">
								<div class="card-front">
									<div class="center-wrap">
										<div class="section text-center">
											<h3 class="mb-4 pb-3">Inicia sesión</h3>
											<form method="post" action="admin/" style="width: 70%;">
											<div class="form-group">
												<input type="text" name="usuario" class="form-style" placeholder="admin" id="logemail" value="admin">
												<i class="input-icon bi bi-person-circle"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="pass" class="form-style" placeholder="Your Password" id="logpass" autocomplete="off">
												<i class="input-icon bi bi-lock-fill"></i>
											</div>
											<input type="submit" class="btn mt-4" value="CONTINUAR"/>
                            				</form>
				      					</div>
			      					</div>
			      				</div>
			      			</div>
			      		</div>
			      	</div>
		      	</div>
	      	</div>
	    </div>
	</div>

<!-- <div style="text-align:center;margin:20px;"> -->
<!-- 	<span style="margin:10px;">Identificate admin:</span> -->

<!-- 	<form method="post" action="admin/" style="margin:10px;"> -->
<!-- 		Pass: <input type="password" name="pass" /> <br> -->
<!-- 		<input type="submit"/> -->
<!-- 	</form> -->
<!-- </div> -->

</body>
</html>