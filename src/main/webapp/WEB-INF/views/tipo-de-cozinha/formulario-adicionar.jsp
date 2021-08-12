<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-template title="Adicionar um Tipo de Cozinha">
    <h1>Adicionar um novo tipo de cozinha</h1>
    <form method="post" action="/admin/tipos-de-cozinha/novo">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input class="form-control" id="nome" type="text" name="nome">
            <form:errors cssClass="text text-danger" path="tipoDeCozinhaParaAdicaoForm.nome"/>
        </div>
        <input class="btn btn-primary margin" type="submit" value="Salvar">
        <a class="text-muted" href="/admin/tipos-de-cozinha">Cancelar</a>
    </form>
</templates:admin-template>
