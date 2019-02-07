<jsp:include page="/faces/template/header.jsp" />

<jsp:include page="/faces/template/navbar.jsp" />

<div class="container my-3">
	<h2>Tarefas de hoje:</h2>
	<table class="table mt-2">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Título</th>
				<th scope="col">Data</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td >1</td>
				<td><a class="link" href="#">Levar o lixo para fora</a></td>
				<td>10/02/2019</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a class="link" href="#">Comprar pão para fazer sanduíche</a></td>
				<td>12/02/2019</td>
			</tr>
			<tr>
				<td>3</td>
				<td><a class="link" href="#">Alguma outra tarefa qualquer</a></td>
				<td>12/02/2019</td>
			</tr>
			<tr>
				<td colspan="3"><button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target=".bd-example-modal-lg">+ nova tarefa</button></td>
			</tr>
		</tbody>
	</table>
	
	
	
</div>

<!-- Page creation modal -->
<jsp:include page="/faces/edit-task.jsp" />

<jsp:include page="/faces/template/footer.jsp" />