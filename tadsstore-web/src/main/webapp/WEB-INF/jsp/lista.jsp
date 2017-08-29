<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>JSP Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Evita q conteúdo seja redimensionado em mobile -->

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <style>
      img { width: 100% }
    </style>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </head>
  <body>
    <h1>Hello World!</h1>
    <div class="container">
      <div class="row">
        <c:forEach var="produto" items="${produtos}" varStatus="status">
	  <div class="col-md-6 col-lg-4 well">
	    <img src="./img/bolo1.png" class="img-thumbnail">
	    <h1><c:out value="${produto.nome}" /></h1>
	    <p><c:out value="${produto.descricao}" /></p>
	    <h3><fmt:formatNumber value="${produto.preco}" type="currency" /></h3>
	    <form method="post" action="adicionar-produto">
	      <input type="hidden" name="id" value="${produto.id}" />
	      <button type="submit" class="btn btn-success btn-lg btn-block">
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Comprar</button>
	    </form>

	    <button type="button" class="btn btn-info btn-lg btn-block">
	      <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Ver mais</button>
	  </div>
        </c:forEach>
      </div>

    </div>
  </body>
</html>
