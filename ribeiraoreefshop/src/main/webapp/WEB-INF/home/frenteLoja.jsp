<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<!--Grid row-->
<div class="row wow fadeIn">

	<c:forEach items="${listaProduto }" var="produto">

		<!--Grid column-->
		<div class="col-lg-3 col-md-6 mb-4">

			<div class="card">

				<!--Card image-->
				<div class="view overlay">
					<img
						src="https://scontent.faqa1-1.fna.fbcdn.net/v/t51.2885-15/p640x640/39062484_691444077874281_3863810187877941248_n.jpg?_nc_cat=0&oh=be25fe968415768dd65dd749e298a32d&oe=5BF038D1"
						class="card-img-top" alt=""> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!--Card image-->

				<!--Card content-->
				<div class="card-body text-center">
					<!--Category & Title-->
					<a href="${path}/app/produto/detalheProduto/${produto.urlSlug}"
						class="grey-text">
						<h5>${produto.nomeProduto }</h5>
					</a>
					<h5>
						<strong> <a
							href="${path}/app/produto/detalheProduto/${produto.urlSlug}"
							class="dark-grey-text">${produto.breveDescricao } <span
								class="badge badge-pill danger-color">Novo</span>
						</a>
						</strong>
					</h5>

					<h4 class="font-weight-bold blue-text">
						<strong>R$ ${produto.valorDemonstrado}</strong>
					</h4>

				</div>
				<!--Card content-->

			</div>
			<!--Card-->

		</div>
		<!--Grid column-->

	</c:forEach>

</div>
<!--Grid column-->