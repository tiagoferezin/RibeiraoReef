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
			<th>Nome</th>
			<th>Quantidade</th>
			<th>Valor</th>
			<th>Total</th>
		</tr>
	</thead>

	<tbody>

		<c:forEach items="${listaProdutos }" var="produto">

			<tr data-id="${produto.idProduto }">
				<td>${produto.nomeProduto }</td>
				<td>2</td>
				<td><fmt:formatNumber value="${produto.valor}" type="currency" /></td>
				<td>R$500,00</td>
			</tr>
		</c:forEach>

	</tbody>

	<tfoot>
		<tr>
			<th>Nome</th>
			<th>Quantidade</th>
			<th>Valor</th>
			<th>Total</th>
		</tr>
	</tfoot>