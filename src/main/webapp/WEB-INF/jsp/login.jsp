
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Login</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootsWacth/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/toastr.min.css" />

<style>
h2 {
	color: white;
	margin-left: auto;
	margin-right: auto;
	font-style: italic;
}

h3 {
	color: white;
	margin-left: auto;
	margin-right: auto;
	font-style: italic;
}

img {
	border-radius: 90px;
	border-bottom: none;
}

body {
	background-image:
		url('https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
	background-repeat: no-repeat;
	backgroubd-position: center;
	width: auto;
}

#fonte {
	position: relative;
	font-style: italic;
	margin-left: 180%;
	margin-right: auto;
	
	
	
}
</style>

</head>

<body class="text-center">

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">

			<h1 id=fonte>J4 Cosm�ticos</h1>
		</a>

		
	</nav>

	<br>
	<br>
	<br>

	<div class="container col-md-3">
		<form action="${pageContext.request.contextPath}/Login" method="post"
			class="form-signin co" autocomplete="off">
			
			<h3 class="h3 mb-3 font-weight-normal">LOGIN</h3>
			<label class="sr-only">Login</label>
			<tr>
				<td><label for="inputLogin" class="sr-only">Login</label> <input
					type="text" id="login" name="login" value="${Usuario.login}"
					class="form-control" placeholder="Login" required autofocus>
				</td>

				<td><label for="inputPassword" class="sr-only">Senha</label> <input
					type="password" id="senha" name="senha" value="${Usuario.senha}"
					class="form-control" placeholder="Senha" required> <br>
					<button type="button" class="btn btn-link" onclick="abreModal()">Esqueceu
						sua senha? Clique Aqui</button> <input
					class="btn btn-lg btn-primary btn-block" type="submit"
					value="Entrar" onsubmit="limparForm()"> <br></td>
			</tr>
		</form>
	</div>

	<!-- Modal esqueci minha senha -->
	<div class="modal fade" id="modalEsqueciSenha" name="modalEsqueciSenha"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Esqueci minha
						senha</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="erros" class="text-danger"></div>
					<div class="form-group pull-left">
						<label for="email">Digite seu e-mail cadastrado para que
							sua senha seja alterada:</label> <input type="email" id="email"
							name="email" value="" class="form-control"
							placeholder="Digite seu e-mail cadastrado" required> <small>A
							nova senha ser� enviada no seu endere�o de e-mail</small>
					</div>
					<div id="aguarde"></div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" id="linkResetSenha"
						onclick="alterarSenha($('#email').val())">Enviar</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/jsp/autenticado/rodape.jsp"%>

	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/toastr.min.js"></script>

	<script>
		$(document).ready(function() {
			var statusAlterado = '${statusAlterado}';
			if (statusAlterado === 'true') {
				toastr.success('Senha alterada com sucesso', 'Sucesso');
			}

			$('#login').focus();

			var msgErro = '${erro}';
			if (msgErro !== '') {
				toastr.error('Usu�rio ou senha inv�lido(s)', 'Aten��o');
				$('#login').val('');
				$('#senha').val('');
				$('#login').focus();
			}
		});

		function limparForm() {
			$('#login').val('');
			$('#senha').val('');
		}

		function abreModal() {
			$('#modalEsqueciSenha').modal();
		}

		function alterarSenha(email) {
			if (email === '') {
				toastr.warning('E-mail n�o pode estar vazio', 'Aten��o');
				$('#email').focus();
			} else if (!isEmail(email)) {
				toastr.warning('E-mail inv�lido, verifique por favor',
						'Aten��o');
				$('#email').focus();
			} else {
				$
						.ajax({
							url : 'ResetSenha',
							type : 'POST',
							data : {
								'email' : email.toString()
							},
							beforeSend : function() {
								$('#aguarde')
										.html(
												"<img id='loader' src='resources/img/ajax-loader.gif'/><br /> <p id='adicionando'>Processando... Por favor aguarde.</p>");
								$('#linkResetSenha').prop("disabled", true);
							},
							success : function(data) {
								var usuario = $.parseJSON(data);
								if (usuario !== null) {
									console.log(usuario);
									$('#email').val('');
									$('#modalEsqueciSenha').modal('hide');
									toastr.success(
											'A senha foi alterada e enviada para o e-mail '
													+ email + ' com sucesso',
											'Sucesso');
									console.log(data);
								} else {
									toastr.warning(
											'E-mail n�o est� cadastrado',
											'Aten��o');
									$('#erros').html(
											'E-mail n�o est� cadastrado');
									$('#email').val('');
								}
							},
							error : function() {
								$('#email').val('');
								$('#modalEsqueciSenha').modal('hide');
								toastr
										.error('Ocorreu um erro ao alterar a senha');
							},
							complete : function() {
								$("aguarde").prop("hidden", true);
								$("#loader").prop("hidden", true);
								$("#adicionando").prop("hidden", true);
								$('#linkResetSenha').prop("disabled", false);
							}
						});
			}
		}

		function isEmail(email) {
			var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			return regex.test(email);
		}
	</script>
</body>
</html>
