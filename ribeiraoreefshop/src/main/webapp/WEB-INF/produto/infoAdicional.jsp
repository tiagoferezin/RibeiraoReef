<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<div class="col-md-6 text-center">

	<h4 class="my-4 h4">Informações Adicionais</h4>

	<p>
	<table id="tabela-informacoes"
		class="display table table-striped table-responsive"
		style="width: 100%">

		<tbody>

			<c:forEach items="${listaInfoAdicionalProduto }" var="infoAdcional">

				<tr>

					<td style="width: 150px;"><strong>${infoAdicional.nome }</strong></td>
					<td>${infoAdicional.termo }</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

	</p>
</div>