<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/list">Prueba Tecnica</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Lista de Personas</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

    <h1>Lista de Personas</h1>
		<div class="starter-template">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Nombre</th>
			      <th scope="col">Apellido</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach  items="${personResponse.embedded.people}" var ="person">
			    <tr>
			      <td>${person.firstName}</td>
			      <td>${person.lastName}</td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item"><a class="page-link" href="/paging?p=0&s=20">1</a></li>
			    <li class="page-item"><a class="page-link" href="/paging?p=1&s=20">2</a></li>
			  </ul>
			</nav>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

   
    <br/><br/>

</body>

</html>
