<jsp:include page="/faces/template/header.jsp" />

<div class="container">
	<div class="card mt-5">
		<form action="sign-up.jsp" method="POST">
			<div class="card-body">
				<h2>Cadastre-se</h2>
				<div class="form-group">
					<label for="name">Nome </label>
					<input type="text" name="name" id="name" class="form-control" required="required">
				</div>
				<div class="form-group">
					<label for="email">E-mail </label>
					<input type="email" name="email" id="email" class="form-control" required="required">
				</div>
				<div class="form-group">
					<label for="password">Senha </label>
					<input type="password" name="password" id="password" class="form-control" required="required">
				</div>
				<div class="form-group">
					<input type="submit" value="Cadastrar" class="btn btn-success">
					<a href="login.jsp" class="btn btn-primary">Voltar</a>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/faces/template/footer.jsp" />