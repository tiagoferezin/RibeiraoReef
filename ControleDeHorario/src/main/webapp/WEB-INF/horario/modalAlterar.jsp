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

			<form id="form-horario" method="post">

				<div class="modal-header">
					<h4 class="modal-title">Informações do Produto</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<div class="modal-body">

						<label for="data">Data: </label><input id="data" name="data"
							class="data form-control" style="display: inline-block"
							placeholder="dd/MM/aaaa"> <label for="horaEntrada">Hora
							de Entrada: </label><input id="horaEntrada" name="horaEntrada"
							class="horaEntrada form-control" style="display: inline-block"
							placeholder="HH:mm"> <label for="saidaAlmoco">Saída
							Almoço: </label><input id="saidaAlmoco" name="saidaAlmoco"
							class="saidaAlmoco form-control" style="display: inline-block"
							placeholder="HH:mm"> <label for="retornoAlmoco">Retorno
							Almoço: </label><input id="retornoAlmoco" name="retornoAlmoco"
							class="retornoAlmoco form-control" style="display: inline-block"
							placeholder="HH:mm"> <label for="saida">Saída: </label><input
							id="saida" name="saida" class="saida form-control"
							style="display: inline-block" placeholder="HH:mm"> <input
							id="idProduto" name="idProduto" type="hidden"> <input
							id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button id="btn-salvar" type="button" class="btn btn-success">Salvar
							Horário</button>
					</div>

				</div>

			</form>

		</div>
	</div>
</div>