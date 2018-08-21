<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<div class="col-md-9">

	<!-- Extended material form grid -->
	<form class="form-pessoa">

		<!-- Grid row -->
		<div class="form-row">
			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group">
					<input type="text" class="form-control" id="nome" name="nome">
					<label for="nome">Nome</label>
				</div>
			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group">
					<input type="text" class="form-control" id="sobrenome"
						name="sobrenome"> <label for="sobrenome">Sobrenome</label>
				</div>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->
		<!-- Grid row -->
		<div class="form-row">
			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group">
					<input type="email" class="form-control" id="email" name="email">
					<label for="email">Email</label>
				</div>
			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group">
					<input type="password" class="form-control" id="senha" name="senha">
					<label for="senha">Senha</label>
				</div>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->

		<!-- Grid row -->
		<div class="row">
			<!-- Grid column -->
			<div class="col-md-3">
				<!-- Material input -->
				<div class="md-form form-group">

					<select class="form-control" id="tipoDocumento"
						name="tipoDocumento">
						<c:forEach items="${listaTipoDocumento }" var="tipoDocumento">
							<option value="${tipoDocumento }">${tipoDocumento }</option>
						</c:forEach>
					</select>

				</div>
			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-9">
				<!-- Material input -->
				<div class="md-form form-group">
					<input type="text" class="form-control" id="documento"
						name="documento"> <label for="documento">Documento</label>
				</div>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->

		<!-- Grid row -->
		<div class="form-row">
			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group" style="font-weight: 700;">
					Você tem: ${pontosFidelidade } pontos.
					<input id="idUsuario" name="idUsuario" type="hidden">
				</div>
			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-6">
				<!-- Material input -->
				<div class="md-form form-group">
				
					<button type="submit" class="btn btn-primary btn-md float-right btn-Salvar">Salvar</button>
				</div>
			</div>
			<!-- Grid column -->
		</div>
		<!-- Grid row -->
		
	</form>
	<!-- Extended material form grid -->
</div>
