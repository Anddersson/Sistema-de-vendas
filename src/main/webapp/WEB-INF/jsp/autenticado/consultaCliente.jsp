
<%@include file="header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Consulta de Cliente</title>
<style>
#fundo {
	background: #D3D3D3;
}
img {
	opacity: 0.5;
	border-radius: 120px;
}
</style>
<body id=fundo>
<div class="col-md-10 container">
    <br>
    <h2>Consulta de Clientes</h2>
    <hr>
    <br>
    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">

        <div class="input-group-append col-md-6">
            <input type="text" class="form-control " placeholder="Pesquisar" id="filtro" name="filtro">

        </div>
        <div class="input-group">
            <div>
                <a href="${pageContext.request.contextPath}/autenticado/Clientes?acao=salvar" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Novo Cliente"><i class="fas fa-user-plus"></i> Novo Cliente</a>
            </div>

        </div>
    </div>
    <br>
    <br>
    <table class="table table-hover border border-primary">
        <thead> 
            <tr class="table-primary ">
                <th class="text-center" scope="col">Id</th>
                <th class="text-center" scope="col">Nome</th>
                <th class="text-center" scope="col">CPF</th>
                <th class="text-center" scope="col">CNPJ</th>
                <th class="text-center" scope="col">Data Nasc.</th>
                <th class="text-center" scope="col">Sexo</th>
                <th class="text-center" scope="col">E-mail</th>
                <th class="text-center" scope="col">Telefone</th>
                <th class="text-center" scope="col">Celular</th>
                <th class="text-center" scope="col">Status</th>
                <th class="text-center" scope="col">#</th>

            </tr>
        </thead>
        <tbody id="tabela" name="tabela">
            <c:forEach var="c" items="${clientes}">
                <tr>
                    <td class="text-center">${c.idCliente}</td>
                    <td class="text-center">${c.nome}</td>
                    <td class="text-center">${c.documento.cpf}</td>
                    <td class="text-center">${c.documento.cnpj}</td>
                    <td class="text-center"><fmt:formatDate value="${c.dataNasc}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                    <td class="text-center">${c.sexo}</td>
                    <td class="text-center">${c.email}</td>
                    <td class="text-center">${c.telefone}</td>
                    <td class="text-center">${c.celular}</td>
                    <c:if test="${c.ativo == true}">
                        <td class="text-center">Ativo</td>
                    </c:if>
                    <c:if test="${c.ativo == false}">
                        <td class="text-center">Inativo</td>
                    </c:if>
                    <td class="text-center">
                        <c:url var="alterarCliente" value="/autenticado/Clientes">
                            <c:param name="acao" value="alterar" />
                            <c:param name="idCliente" value="${c.idCliente}" />
                        </c:url>
                        <a href="${alterarCliente}" class="btn btn-md btn-warning" data-toggle="tooltip" data-placement="left" title="Alterar Cliente"><i class="fas fa-user-edit"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <hr>

</div>
</body>
<script>

    $(document).ready(function () {
        var statusSalvo = '${statusSalvo}';
        var statusAlterado = '${statusAlterado}';
        if (statusSalvo === 'true') {
            toastr.success('Cliente salvo com sucesso', 'Sucesso');
        } else if (statusAlterado === 'true') {
            toastr.success('Cliente alterado com sucesso', 'Sucesso');
        }
              
    });

    $('#filtro').on('keyup', function () {
        var value = $(this).val();
        var patt = new RegExp(value, "i");

        $('#tabela').find('tr').each(function () {
            if (!($(this).find('td').text().search(patt) >= 0)) {
                $(this).not('.myHead').hide();
            }
            if (($(this).find('td').text().search(patt) >= 0)) {
                $(this).show();
            }

        });

    });
</script>
