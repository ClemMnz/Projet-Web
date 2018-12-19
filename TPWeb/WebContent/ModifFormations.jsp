<%@page import="fr.eni.servlet.StagiaireServlet"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.model.Formation"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="Header.jsp"%>

<%@include file="Menu.jsp"%>

<div class="container">
	<div class="starter-template ">
	
	
			<div class="row titre">
				<div class="col-md-12 col-md-offset-4">Formations</div>
			</div>

			<hr>

			<div class="row parag">
				<div class="col-md-offset-2">
					<br> 

		<table border="1px">
			<tr>
				<th>ID</th>
				<th>LIBELLE</th>
				<th>DESCRIPTION</th>

			</tr>
			<%
				if (request.getAttribute("formations") != null) {

					List<Formation> formations = (List<Formation>) request.getAttribute("formations");
					for (Formation formation : formations) {
			%>
			<tr>
				<td><%=formation.getCodeFormation()%></td>
				<td><%=formation.getLibelle()%></td>
				<td><%=formation.getDescription()%></td>
				<td><a
					href="<%=request.getContextPath()%>/ManageFormationServlet?action=delete&id=<%=formation.getCodeFormation()%>">Supprimer</a>
					| <a
					href="<%=request.getContextPath()%>/ManageFormationServlet?action=update&id=<%=formation.getCodeFormation()%>">Modifier</a>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>

		<a
			href="<%=request.getContextPath()%>/ManageFormationServlet?action=add">Ajouter</a>

	<br> 
				</div>
			</div>
			<hr>
		</div>

	</div>
<%@include file="Footer.jsp"%>


