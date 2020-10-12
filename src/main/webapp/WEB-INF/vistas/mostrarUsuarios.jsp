<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a Taller Web 1</h1>
		</div>
		Lista de usuarios
		<br>
		<c:forEach items="${usuario}" var="USER">
			${USER.email}-${USER.rol}<br>
			<a class="btn btn-primary" href="eliminar-usuario/${USER.id}">DELETE</a><br><br>
		</c:forEach>
		<a class="btn btn-primary" href="crear-usuario">CREAR</a>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>