<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Tipos de Cozinha</title>
        <link href="/assets/bootstrap-3.3.7.min.css" rel="stylesheet">
        <link href="/assets/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Tipos de cozinha</h1>
            <a class="btn btn-primary margin" href="/admin/tipos-de-cozinha/novo">Adicionar novo</a>
            <table class="table table-hover">
                <tr>
                    <th>Nome</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${tiposDeCozinha}" var="tipoDeCozinha">
                    <tr>
                        <td>${tipoDeCozinha.nome}</td>
                        <td><a class="btn btn-default" href="/admin/tipos-de-cozinha/edicao/${tipoDeCozinha.id}">Editar</a></td>
                        <td>
                            <form method="post" action="/admin/tipos-de-cozinha/remocao/${tipoDeCozinha.id}">
                                <button class="btn btn-danger" type="submit">Remover</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
