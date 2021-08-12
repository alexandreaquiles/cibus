<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-template title="Tipos de Cozinha">
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
</templates:admin-template>