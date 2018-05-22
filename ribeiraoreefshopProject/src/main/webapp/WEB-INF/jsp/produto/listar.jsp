<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<table>
  <thead>
    <tr>
      <th>Nome</th>
      <th>Descrição</th>
      <th>Preço</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${produtoList}" var="produto">
      <tr>
        <td>${produto.nomeProduto }</td>
        <td>${produto.idProduto }</td>
        <td>${produto.valor }</td>
      </tr>          
    </c:forEach>
  </tbody>
</table>
<a href="<c:url value="/produto/editar/novo"/>">Cadastrar Produtos</a>
</body>
</html>