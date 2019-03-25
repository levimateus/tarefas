<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="com.tasks.model.dao.TaskDAO"  />

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5>Nova tarefa</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="create-task.jsp" method="POST">
				<input type="hidden" name="id_task" value="">
			
				<div class="modal-body">
					<div class="form-group">
						<label for="title">Título da tarefa</label>
						<input type="text" name="title" id="title" class="form-control" placeholder="Insere o título" required="required">
						<small class="text-small text-danger">O título é um campo obrigatório</small>
					</div>
					<div class="form-group">
						<label for="description">Descrição da tarefa</label>
						<textarea name="description" id="description" class="form-control"></textarea>
					</div>
					<div class="form-group">
						<label for="task_date">Data da tarefa</label>
						<input type="text" name="task_date" id="task_date" class="date_input form-control" placeholder="dd/mm/aaaa">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        			<input type="submit" class="btn btn-success" value="Salvar">
				</div>
			</form>
		</div>
	</div>
</div>

<script> CKEDITOR.replace("description"); </script>