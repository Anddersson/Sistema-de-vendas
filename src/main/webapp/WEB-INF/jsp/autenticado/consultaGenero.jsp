
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<title>Consulta de G�nero</title>
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
<div class="container">
    <br>
    <h2>Consulta de G�nero</h2>
    <hr>
    <br>
    <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">

        <div class="input-group-append col-md-6">
            <input type="text" class="form-control " placeholder="Pesquisar" id="filtro" name="filtro">

        </div>
        <div class="input-group">
            <div>
                <a href="Generos?acao=salvar" class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="Novo G�nero"><i class='fas fa-plus-circle'></i> Novo G�nero</a>
            </div>
        </div>
    </div>

    <br>
    <br>

    <table id="tabelaGeneros" class="table table-hover border border-primary">
        <thead> 
            <tr class="table-primary">
                <th class="text-center" scope="col">Id</th>
                <th class="text-center" scope="col">Nome</th>
                <th class="text-center" scope="col">#</th>

            </tr>
        </thead>
        <tbody id="tabela" name="tabela">
            <c:forEach var="g" items="${generos}">
                <tr>
                    <td class="text-center">${g.idGenero}</td>
                    <td class="text-center">${g.nome}</td>

                    <td class="text-center">
                        <c:url var="alterarGenero" value="/autenticado/Generos">
                            <c:param name="acao" value="alterar" />
                            <c:param name="idGenero" value="${g.idGenero}" />
                        </c:url>
                        <a href="${alterarGenero}" class="btn btn-md btn-warning" data-toggle="tooltip" data-placement="right" title="Alterar G�nero"><i class="fas fa-edit"></i></a>

                        <c:url var="excluir" value="/autenticado/Generos">
                            <c:param name="excluir" value="excluir" />
                            <c:param name="idGenero" value="${g.idGenero}" />
                        </c:url>
                        <button type="button" class="btn btn-md btn-danger" onclick="confirmaExclusao(${g.idGenero})" data-toggle="tooltip" data-placement="right" title="Excluir G�nero"><i class="far fa-trash-alt"></i></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<!-- Modal -->
<div class="modal fade" id="modalExemplo" name="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Excluir G�nero</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="hidden" value="" name="idGeneroModal" id="idGeneroModal">
                Deseja realmente excluir a plataforma de Id <strong id="idTextGeneroModal"></strong>?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="excluir($('#idGeneroModal').val())">Excluir</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        var statusSalvo = '${statusSalvo}';
        var statusAlterado = '${statusAlterado}';
        if (statusSalvo === 'true') {
            toastr.success('G�nero salvo com sucesso', 'Sucesso');
        } else if (statusAlterado === 'true') {
            toastr.success('G�nero alterado com sucesso', 'Sucesso');
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

    function confirmaExclusao(id) {
        $('#modalExemplo').modal('show');
        $('#idTextGeneroModal').text(id);
        $('#idGeneroModal').val(id);
    }

    function excluir(id) {
        $.ajax({
            url: 'Generos?acao=excluir',
            type: 'POST',
            data: {'idGenero': id},
            success: function (data) {
                var genero = $.parseJSON(data);
                if (genero.produtos.length !== 0) {
                    toastr.error('N�o � poss�vel excluir o g�nero, pois existem ' + genero.produtos.length + ' produto(s) atribu�dos a ele', 'Erro');
                    $('#modalExemplo').modal('hide');
                } else {
                    $('#modalExemplo').modal('hide');
                    $("#tabelaGeneros").load("Generos #tabelaGeneros");
                    toastr.success('G�nero removido', 'Sucesso');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                toastr.error('Ocorreu um erro ao remover', 'Erro');
            }
        });
    }
</script>

