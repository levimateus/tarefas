<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/faces/template/header.jsp" />

<div class="container">
	
	<div class="card mt-5 mx-auto" style="max-width: 300px;">
		<div class="card-body">
			<h2 align="center">Tarefas</h2>
			<c:if test="${not empty param.error}">
				<p class="text-danger text-center">Usuário ou senha inválidos</p>			
			</c:if>
			<form action="login.jsp" method="POST">
				<div class="form-group">
					<label for="email">E-mail</label>
					<input type="email" name="email" id="email" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="password">Senha</label>
					<input type="password" name="password" id="password" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<input type="submit" value="Entrar" class="btn btn-success">
					<a href="sign-up.jsp" class="btn btn-primary">Cadastrar-se</a>
				</div>
			</form>
		</div>
	</div>
	
</div>

<jsp:include page="/faces/template/footer.jsp" />