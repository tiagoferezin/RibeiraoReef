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
<jsp:include page="../head.jsp" />


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

		<jsp:include page="../header.jsp" />

	</section>
	
	<section class="carrousse" >
	
	<jsp:include page="../carroussel.jsp" />
	
	</section>

	<main>

	<div class="container">
		<!--Section: Products v.3-->
		<section class="text-center mb-4">
			<jsp:include page="frenteLoja.jsp" />

		</section>
	</div>
	</main>

	<section class="footer" id="secao-footer">

		<jsp:include page="../footer.jsp" />

	</section>

	<script type="text/javascript" src="${path}/static/js/navbar.js"></script>

</body>
</html>