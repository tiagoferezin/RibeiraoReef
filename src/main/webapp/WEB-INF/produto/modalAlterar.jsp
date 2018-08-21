<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modalAlterar" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-produto" method="post">
				<div class="modal-header">
				<h4 class="modal-title">Informações do Produto</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
				</div>
				<div class="modal-body">
					<label for="nomeProduto">Nome: </label> <input id="nomeProduto"
						name="nomeProduto" class="form-control"> 
						<label for="estoque">Quantidade: </label> <input id="estoque"
						name="estoque" class="estoque form-control" style="display: inline-block" placeholder="100"> 
						
						
					<label for="valor">Valor Unitário: </label> R$<input
						id="valor" name="valor"
						class="valorUnitario form-control" style="display: inline-block" placeholder="100.00">

					<input id="idProduto" name="idProduto" type="hidden"> <input id="csrf"
						name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-success">Salvar</button>
				</div>
			</form>
		</div>
	</div>
</div>