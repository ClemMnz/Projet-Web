

<%@include file="../Header.jsp" %>


<%@include file="../Menu.jsp" %>
<div class="container">
		<div class="starter-template ">
		
<div class="row parag">
<div class="col-md-offset-2">
ERREUR!
<%
if(request.getAttribute("error") != null)
{
%>
	<%=request.getAttribute("error").toString()%>
<%
}
%>
</div>
</div>
</div>
</div>
<%@include file="../Footer.jsp" %>

