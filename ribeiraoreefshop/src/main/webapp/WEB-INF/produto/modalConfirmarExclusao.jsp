<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modalConfirmarExclusao" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-produto" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Confirmar Exclusão</h4>

				</div>
				<div class="modal-body">
					<label for="tituloMod">Confirma a exclusão do produto?</label> 
				</div>
				<div class="modal-footer">
					<div class="botoesModal" style="float: right;">
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
						<button type="button" class="btn btn-danger btn-deletar">Sim</button>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>