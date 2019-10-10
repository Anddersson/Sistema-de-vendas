

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<title>Altera��o de G�nero</title>

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
	<div class=" container">
		<br>
		<h2>Altera��o de G�nero</h2>
		<hr>

		<!-- notificacoes caso houver erros nas valida��es -->
		<div class="form-group">
			<ul class="text-danger">
				<c:forEach var="n" items="${notificacoes}">
					<li>${n.valor}</li>
				</c:forEach>
			</ul>
		</div>

		<form action="Generos" method="post">
			<input type="hidden" value="${genero.idGenero}" id="idGenero"
				name="idGenero"> <input type="hidden" value="alterar"
				id="acao" name="acao">

			<div class="row">
				<div class=" form-group col-md-5">
					<label for="nome">Nome<h11 class="text-danger">*</h11></label> <input
						type="text" id="nome" name="nome" class="form-control"
						placeholder="Digite o nome do g�nero" required
						value="${genero.nome}">
				</div>
			</div>

			<hr>

			<div class="row">
				<div class=" form-group col-md-2">
					<button type="submit" class="btn btn-success" value="Salvar">Salvar</button>
					<a href="Generos" class="btn btn-light">Cancelar</a>
				</div>
			</div>

		</form>
	</div>
	</body>