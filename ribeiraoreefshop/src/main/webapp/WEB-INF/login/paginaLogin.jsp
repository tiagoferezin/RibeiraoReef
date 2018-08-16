<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ribeirão Reef Shop - ${titulo }</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet" src="${path}/static/css/style.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>

	</br>
	<c:if test="${not empty mensagemErro }">
		<div class="container">

			<div class="alert alert-danger">${mensagemErro }</div>

		</div>
	</c:if>

	<c:if test="${not empty mensagemInfo }">
		<div class="container">

			<div class="alert alert-info">${mensagemInfo }</div>

		</div>
	</c:if>

	<section class="header" id="secao-header">

		<jsp:include page="header.jsp" /> 

	</section>

	

		<section class="container" id="secao-login">
			<jsp:include page="login.jsp" />
		</section>
	

<script type="text/javascript" src="${path}/static/js/navbar.js"></script>


	<script type="text/javascript" src="${path}/static/js/login.js"></script>

</body>
</html>