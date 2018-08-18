<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table id="tabela-produtos" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>Descricao</th>
			<th>Quantidade</th>
			
			
			<th>Valor</th>
			<th>Editar</th>
			<th>Deletar</th>

		</tr>
	</thead>
	<tbody>

		<c:forEach items="${listaProdutos }" var="produto">
			<tr data-id="${produto.idProduto }">
				<td>${produto.nomeProduto }</td>
				<td>${produto.estoque }</td>
				
				<td><fmt:formatNumber value="${produto.valor}"
						type="currency" /></td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button"
						class="btn btn-danger btn-deletar-tabela" data-toggle="modal"
						data-target="#modalConfirmarExclusao">Deletar</button></td>
			</tr>

		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<th>Descricao</th>
			<th>Quantidade</th>
			
			<th>Valor</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalAlterar" style="float: right;">Cadastrar
					Produto</button>
			</td>
		</tr>
	</tfoot>
</table>

