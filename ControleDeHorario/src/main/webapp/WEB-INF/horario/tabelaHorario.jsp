<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table id="tabela-horarios" class="display" style="width: 100%">

	<thead>
		<tr>

			<th>Data</th>
			<th>Mês</th>
			<th>Entrada</th>
			<th>Saída Almoço</th>
			<th>Retorno Almoço</th>
			<th>Saída</th>
			<th>Minutos Trabalhados</th>
			<th>Horas Trabalhadas</th>
			<th>Editar</th>


		</tr>
	</thead>

	<tbody>

		<c:forEach items="${listaHorarios }" var="horario">

			<tr data-id="${horario.idHorario }">

				<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${horario.data }"/></td>
				<td>${horario.mes }</td>
				<td>${horario.horaEntrada }</td>
				<td>${horario.saidaAlmoco }</td>
				<td>${horario.retornoAlmoco }</td>
				<td>${horario.saida }</td>
				<td>${horario.minutosTrabalhados }minutos</td>
				<td>${horario.totalDeHorasTrabalhadas }h</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>

			</tr>

		</c:forEach>

	</tbody>

	<tfoot>
		<tr>

			<th>Data</th>
			<th>Mês</th>
			<th>Entrada</th>
			<th>Saída Almoço</th>
			<th>Retorno Almoço</th>
			<th>Saída</th>
			<th>Minutos Trabalhados</th>
			<th>Horas Trabalhadas</th>
			<th>Editar</th>


		</tr>

		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalAlterar" style="float: right;">Cadastrar
					Horário</button>
			</td>
		</tr>

		</tfood>
</table>