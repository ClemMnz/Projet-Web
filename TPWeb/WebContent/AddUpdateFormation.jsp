<%@page import="fr.eni.model.Formation"%>


<%@include file="Header.jsp"%>

<%@include file="Menu.jsp"%>


<%
	Formation formation = (Formation) request.getAttribute("formationAModifier");
	Boolean isAjout = (Boolean) request.getAttribute("ajout");
%>


<div class="container">
	<div class="starter-template">
		<div class="row parag">
			<div class="col-md-offset-2">

				<div class="row parag">
					<div class="col-md-6">
						<br>
						<form class="col-md-offset-4" action="ManageFormationServlet">

							<div class="form-group">
								 <input type="hidden"
									name="id"
									value="<%if (!isAjout) {%><%=formation.getCodeFormation()%><%}%>" />
							</div>
							
							<div class="form-group">
								<label for="libelle">Libellé: </label> <input required type="text"
									maxlength="100" placeholder="Libellé" class="form-control"
									id="libelle" name="libelle"
									value="<%if (!isAjout) {%><%=formation.getLibelle()%> <%}%>" />
							</div>
							<div  class="form-group">
								<label for="description">Description: </label> 
								<input
									required
									type="text" placeholder="Description" maxlength="350"
									class="form-control" id="description" name="description"
									value="<%if (!isAjout) {%><%=formation.getDescription()%> <%}%>" />
									
							</div>
							
							<%
								if (isAjout) {
							%>
							<input type="submit" value="Ajouter" name="bouton" />
							<%
								} else {
							%>
							<input type="submit" value="Modifier" name="bouton" />
							<%
								}
							%>
							<br>
						</form>
						<br>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="Footer.jsp"%>