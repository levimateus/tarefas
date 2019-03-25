<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="dao" class="com.tasks.model.dao.TaskDAO"  />

<jsp:include page="/faces/template/header.jsp" />
<jsp:include page="/faces/template/navbar.jsp" />

<div class="container">
	<div class="row">
		<div class="col col-xl-3 col-lg-4 col-md-4 mt-2">
			<div class="card">
				<div class="card-body">
					<h4 class="text-center">Maio</h5>
					<table class="table table-sm table-bordered">
						<thead>
							<th>D</th>
							<th>S</th>
							<th>T</th>
							<th>Q</th>
							<th>Q</th>
							<th>S</th>
							<th>S</th>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
							</tr>
							<tr>
								<td>5</td>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
							</tr>
							<tr>
								<td>12</td>
								<td class="bg-success">13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
							</tr>
							<tr>
								<td>19</td>
								<td class="bg-success">20</td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td>25</td>
							</tr>
							<tr>
								<td>26</td>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
								<td>31</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="list-group my-2 col col-xl-9 col-lg-8 col-md-8">
			<h4 class="list-group-item text-center">Tarefas de hoje:</h4>
			<c:forEach var="task" items="${dao.getListToday(user)}">
				<a class="list-group-item list-group-item-action"
				   href="#collapse-task-${task.id}"
				   data-toggle="collapse"
				   role="button"
				   >
				   <span class="badge badge-success">Entregue</span>
				   <span class="badge badge-secondary"><fmt:formatDate type="date" value="${task.taskDate.time}" pattern="dd/MM/yyyy" /></span>
				   &nbsp${task.title}
				</a>
				<div class="collapse list-group-item" style="background-color: #eaeaea" id="collapse-task-${task.id}">
					${task.description}
					<a href="delete-task.jsp?id=${task.id}" class="btn btn-danger btn-sm">Excluir</a>
				</div>
			</c:forEach>
			
			<button type="button" class="list-group-item list-group-item-action active text-center" data-toggle="modal" data-target=".bd-example-modal-lg">+ nova tarefa</button>
		</div>
	</div>
</div>

<!-- Page creation modal -->
<jsp:include page="/faces/tasks/create-task.jsp" />

<jsp:include page="/faces/template/footer.jsp" />