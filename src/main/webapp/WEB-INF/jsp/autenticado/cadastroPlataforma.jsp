

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Cadastro de Plataforma</title>
<style>
#fundo {
	background: #D3D3D3;
}
img {
	opacity: 0.5;
	border-radius: 120px;
}
</style>

</head>

<body id=fundo>
	<div class=" container">
		<br>
		<h2>Cadastro de Plataforma</h2>
		<hr>
		<!-- notificacoes caso houver erros nas validações -->
		<div class="form-group">
			<ul class="text-danger">
				<c:forEach var="n" items="${notificacoes}">
					<li>${n.valor}</li>
				</c:forEach>
			</ul>

		</div>

		<form action="Plataformas" method="post">
			<input type="hidden" value="salvar" id="acao" name="acao">

			<div class="row">
				<div class="col-md-5">
					<label for="nome">Nome<h11 class="text-danger">*</h11></label> <input
						type="text" id="nome" name="nome" class="form-control"
						placeholder="Digite o nome da plataforma" required>
				</div>
			</div>

			<hr>

			<div class="row">
				<div class=" form-group col-md-2">
					<button type="submit" class="btn btn-success" value="Salvar">Salvar</button>
					<button type="reset" class="btn btn-light" value="cancelar">Cancelar</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
