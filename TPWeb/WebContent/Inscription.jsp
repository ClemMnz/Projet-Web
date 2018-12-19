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
			<div class="col-md-12 col-md-offset-4">Inscriptions</div>
		</div>

		<hr>

		<div class="row parag">
			<div class="col-md-offset-4">
				<br>
				
				
				<br>
						<form class="col-md-offset-4" action="InscriptionServlet">

							<div class="form-group">


			<input type="hidden" value="${requestScope['stagiaireAModifier'].id}"
				name="id">
				<label for="nom">Nom: </label> 
			<input type="text" name="nom"
				value="${requestScope['stagiaireAModifier'].nom}" required
				maxlength="250" id="nom" placeholder="Nom"/><br /> 
			<label for="prenom">Prénom:</label>
			<input type="text" name="prenom"
				value="${requestScope['stagiaireAModifier'].prenom}" required
				maxlength="250" id="prenom" placeholder="Prénom"/><br /> 	
				<label for="mail">Mail :</label>
			<input type="text" name="mail"
				value="${requestScope['stagiaireAModifier'].mail}" required
				maxlength="50" id="mail" placeholder="Adresse Mail"/><br /> 
				<label for="mdp">Mot de passe :</label>
			<input type="text" name="motDePasse"
				value="${requestScope['stagiaireAModifier'].motDePasse}" required
				maxlength="20" id="mdp" placeholder="Mot de passe"/><br /> 	

			<c:choose>
				<c:when test="${param['action'] == 'update'}">
					<input type="submit" value="Modifier" name="bouton" />
				</c:when>
				<c:otherwise>
					<input type="submit" value="Ajouter" name="bouton" />
				</c:otherwise>
			</c:choose>
		
						<br>
						</form>
						<br>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
				
				
							</div>
			<br>

		</div>
	</div>
	<hr>
</div>

</div>
<%@include file="Footer.jsp"%>


				