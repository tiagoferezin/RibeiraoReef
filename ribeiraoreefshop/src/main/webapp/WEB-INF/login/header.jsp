<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<div class= "row">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

	<div class="navbar-header">
		<a class="navbar-brand" href="#">Ribeirao Reef Shop</a>
	</div>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
	
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="nav navbar-nav col-md-8">
			<c:forEach items="${itensMenu }" var="item">
				<li class="nav-item"><a href="#">${item.nome }</a></li>||
			</c:forEach>
			<li class="nav-item col-md-1"><a href="#" style="font-weight: 700; color: #ffffff;">Home</a></li>
			<li class="nav-item col-md-1"><a href="#" style="font-weight: 700; color: #ffffff;">Sobre</a></li>
			<li class="nav-item col-md-1"><a href="#" style="font-weight: 700; color: #ffffff;">Produtos</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right col-md-3">
			<li class="nav-item col-md-4"><a href="${path }/app/login" style="font-weight: 700; color: #ffffff;"><span
					class="far fa-user"></span> Sign Up</a></li>
			<li class="nav-item col-md-4"><a href="${path }/app/login" style="font-weight: 700; color: #ffffff;"><span
					class="fas fa-sign-in-alt"></span> Login</a></li>
		</ul>
	</div>
</nav>
</div>
<br>
<br>

<br>
<br>

