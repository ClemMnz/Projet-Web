<%@page import="fr.eni.model.Formation"%>
<%@page import="java.util.List"%>


<%@include file="Header.jsp" %>

<%@include file="Menu.jsp" %>


	<div class="container">
		<div class="starter-template">

			<div class="row titre">
				<div class="col-md-12 col-md-offset-4">TP Web-Formations</div>
			</div>

			<hr>

			<div class="row parag">
				<div class="col-md-offset-2">
					<br> 
<%
	List<Formation> liste =(List<Formation>)request.getAttribute("superliste");
	
	for(Formation item:liste)
	{
%>
		<p><%=item%></p>
<%
	}
%>
		
	<br> 
				</div>
			</div>
			<hr>
		</div>

	</div>

<%@include file="Footer.jsp" %>

