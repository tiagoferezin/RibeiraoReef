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

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css"
	href="${path}/static/css/footerEspecial.css">
<jsp:include page="../head.jsp" />


</head>
<body>

	<section class="header" id="secao-header">

		<jsp:include page="../header.jsp" />

	</section>

	<main>
	<br><br><br><br>

	<section class="container" id="secao-login">
		<div class="row">
			<jsp:include page="listaProdutos.jsp" />
		</div>
	</section>

	</main>


	<section class="footer" id="secao-footer">

		<jsp:include page="../footer.jsp" />

	</section>

	<script type="text/javascript" src="${path}/static/js/navbar.js"></script>
	<script type="text/javascript" src="${path}/static/js/login.js"></script>


</body>
</html>