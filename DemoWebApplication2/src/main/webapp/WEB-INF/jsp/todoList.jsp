<%@ include file="common/header.jspf" %>
<%@ include file="common/common.jspf" %>
<div class="container">
<table class="table table-striped">
<caption><font color="blue">Your ToDos</font></caption>
<thead>
   <tr>
      <th>Description</th>
      <th>Target Date</th>
      <th>Is it done?</th>
      <th></th>
      <th></th>
   </tr>
</thead>
<tbody>
  <c:forEach items="${todos}" var="todo">
	   <tr>
	      <td>${todo.desc}</td>
	      <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
	      <td>${todo.done}</td>
	      <td><a type="button" class="btn btn-success" href="/updateTODO?id=${todo.id}">Update</a></td>
	      <td><a type="button" class="btn btn-warning" href="/deleteTODO?id=${todo.id}">Delete</a></td>
	   </tr>
 </c:forEach>	   
</tbody>
</table>
<div><a class="button" href="/addTodo">Add</a> your TODO</div>       
</div>
<%@ include file="common/footer.jspf" %>