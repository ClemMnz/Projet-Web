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
				<div class="col-md-12 col-md-offset-4">Stagiaires:</div>
			</div>

			<hr>

			<div class="row parag">
				<div class="col-md-offset-2">
					<br> 

		<table border="1px">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Mail</th>
				<th>Mot de passe</th>

			</tr>

			<c:choose>
				<c:when test="${requestScope['stagiaires']!=null}">
					<c:forEach var="stagiaire" items="${requestScope['stagiaires']}">

						<tr>
							<td><c:out value="${stagiaire.id}"></c:out></td>
							<td><c:out value="${stagiaire.nom}"></c:out></td>
							<td><c:out value="${stagiaire.prenom}"></c:out></td>
							<td><c:out value="${stagiaire.mail}"></c:out></td>
							<td><c:out value="${stagiaire.motDePasse}"></c:out></td>
							<td><a
								href="AjouterStagiaireServlet?action=delete&id=<c:out value="${stagiaire.id}"></c:out>">Supprimer</a>|
								<a
								href="AjouterStagiaireServlet?action=update&id=<c:out value="${stagiaire.id}"></c:out>">Modifier</a>
							</td>
						</tr>
	</c:forEach>



				</c:when>

			</c:choose>
		</table>

		<a href="AjouterStagiaireServlet?action=add">Ajouter</a>

	<br> 
				</div>
			</div>
			<hr>
		</div>

	</div>