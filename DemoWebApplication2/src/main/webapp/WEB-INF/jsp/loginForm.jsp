<%@ include file="common/header.jspf" %>
<%@ include file="common/common.jspf" %>
<div class="container">
<font color="Red">${errorMessage }</font>
<form method="post">
Name : <input type="text" name="name" />
Password : <input type="text" name="password" />
<input type="submit" />
</form>
</div>
<%@ include file="common/footer.jspf" %>
