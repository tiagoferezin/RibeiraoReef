<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<div class="row">
	<div class="col-md">
		<div style="background-color: #63c58d; color: #fff;">
			<center>
				<label for="login"><h3>Logar</h3></label>
			</center>
		</div>
		<form id="form-login" method="post" style="background-color: #f2f2f2;">
			<br>
			<div class="form-group col-md-12">
				<label for="email">Nome de Usuário ou E-mail:<font
					color="red">*</font></label> <input type="text" class="form-control"
					id="email" name="email">
			</div>
			<div class="form-group col-md-12">
				<label for="senha">Password:<font color="red">*</font></label> <input
					type="password" class="form-control" id="senha" name="senha">
			</div>

			<div class="form-group col-md-12">
				<button type="button" class="btn btn-success btn-entrar col-md-4">Entrar</button>
				<button type="button"
					class="btn btn-link btn-esqueci-senha col-md-4">Esqueci a
					senha</button>
			</div>
			<div class="form-group col-md-12"></div>
		</form>
	</div>
	<div class="col-md">
		<div style="background-color: #63c58d; color: #fff;">
			<center>
				<label for="login"><h3>Registrar-se</h3></label>
			</center>
		</div>
		<form id="form-cadastro" method="post"
			style="background-color: #f2f2f2;">
			<br>
			<div class="form-group col-md-12">
				<label for="emailCadastro">E-mail:<font color="red">*</font></label>
				<input type="text" class="form-control" id="emailCadastro"
					name="email">
			</div>
			<div class="form-group col-md-12">
				<label for="senhaCadastro">Password:<font color="red">*</font></label>
				<input type="password" class="form-control" id="senhaCadastro"
					name="senha">
			</div>
			<div class="form-group col-md-12">
				<label for="senhaConfirma">Confirme a Senha:<font
					color="red">*</font></label> <input type="password" class="form-control"
					id="senhaConfirma" name="senhaConfirma">
			</div>

			<div class="form-group col-md-12">
				<button type="button" class="btn btn-success btn-registrar col-md-4">Registrar</button>
			</div>
			<div class="form-group col-md-12"></div>
		</form>

	</div>
</div>

