<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<main class="mt-5 pt-4">
<div class="container dark-grey-text mt-5">

	<!--Grid row-->
	<div class="row wow fadeIn">

		<!--Grid column-->
		<div class="col-md-6 mb-4">

			<c:if test="${empty urlImagem || urlImagem == null}">

				<img src="${path}/resources/uploads/foto-indisponivel.png"
					class="img-fluid" alt="">

			</c:if>
			<c:if test="${not empty urlImagem }">
				<img src="${path}/resources/uploads/${urlImagem }" class="img-fluid" alt="">
			</c:if>
		</div>
		<!--Grid column-->

		<!--Grid column-->
		<div class="col-md-6 mb-4">

			<!--Content-->
			<div class="p-4">
				<div class="mb-3">
					<c:forEach items="${listaCategoriasProduto }" var="categoria">

						<a href=""> <span class="badge purple mr-1">${categoria.nomeCategoria }</span>
						</a>

					</c:forEach>


					<a href=""> <span class="badge blue mr-1">New</span>
					</a> <a href=""> <span class="badge red mr-1">Bestseller</span>
					</a>
				</div>

				<p class="lead">
					<span class="mr-1"> <!-- <del>$200</del> -->
					</span> <span>R$ ${produto.valorDemonstrado }</span>
				</p>

				<p class="lead font-weight-bold">Descrição</p>

				<p>${produto.breveDescricao }</p>

				<form class="d-flex justify-content-left">
					<!-- Default input -->
					<input type="number" value="1" aria-label="Search"
						class="form-control" style="width: 100px">
					<button class="btn btn-primary btn-md my-0 p" type="submit">
						Adicionar ao Carrinho <i class="fa fa-shopping-cart ml-1"></i>
					</button>

				</form>

			</div>
			<!--Content-->

		</div>
		<!--Grid column-->

	</div>
	<!--Grid row-->



	<!--Grid row-->
	<!-- <div class="row d-flex justify-content-center wow fadeIn">  -->


	<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active"
			id="descricao-tab" data-toggle="tab" href="#descricao" role="tab"
			aria-controls="descricao" aria-selected="true"><h4>Descrição</h4></a>
		</li>
		<li class="nav-item"><a class="nav-link" id="info-tab"
			data-toggle="tab" href="#info" role="tab" aria-controls="info"
			aria-selected="false"><h4>Informações Adicionais</h4></a></li>
		<li class="nav-item"><a class="nav-link" id="avaliacao-tab"
			data-toggle="tab" href="#avaliacao" role="tab"
			aria-controls="avaliacao" aria-selected="false"><h4>Avaliações</h4></a>
		</li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="descricao" role="tabpanel"
			aria-labelledby="descricao-tab">

			<div class="row d-flex justify-content-center wow fadeIn">

				<div class="col-md-6 text-center">

					<h4 class="my-4 h4">Descrição do Produto</h4>

					<p>${produto.descricao }</p>

				</div>
				<!--Grid column-->
			</div>
		</div>
		<div class="tab-pane fade" id="info" role="tabpanel"
			aria-labelledby="info-tab">
			<div class="row d-flex justify-content-center wow fadeIn">
				<jsp:include page="infoAdicional.jsp" />
			</div>
		</div>
		<div class="tab-pane fade" id="avaliacao" role="tabpanel"
			aria-labelledby="avaliacao-tab">
			<div class="row d-flex justify-content-center wow fadeIn">

				<div class="col-md-6 text-center">

					<h4 class="my-4 h4">Avaliação do Produto</h4>


					<p></p>

				</div>

			</div>
		</div>
	</div>

	<!--  </div> -->
	<!--Grid row-->

	<!--Grid row-->
	<div class="row wow fadeIn">

		<!--Grid column-->
		<div class="col-lg-4 col-md-12 mb-4">

			<img
				src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/11.jpg"
				class="img-fluid" alt="">

		</div>
		<!--Grid column-->

		<!--Grid column-->
		<div class="col-lg-4 col-md-6 mb-4">

			<img
				src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/12.jpg"
				class="img-fluid" alt="">

		</div>
		<!--Grid column-->

		<!--Grid column-->
		<div class="col-lg-4 col-md-6 mb-4">

			<img
				src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/13.jpg"
				class="img-fluid" alt="">

		</div>
		<!--Grid column-->

	</div>
	<!--Grid row-->

</div>
</main>