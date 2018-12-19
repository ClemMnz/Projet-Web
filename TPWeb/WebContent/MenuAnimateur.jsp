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
			<div class="col-md-12 col-md-offset-4">Menu Animateur</div>
		</div>

		<hr>

		<div class="row parag">
			<div class="col-md-offset-2">
				<br>
				<ul>
					<li><a href="ManageFormationServlet">Formations</a>

						<div class="row parag">

							<li><a href="AjouterStagiaireServlet">Stagiaires</a>
								<div class="row parag">
									<li><a href="InscriptionServlet">Inscriptions</a>
				</ul>
			</div>
			<br>

		</div>
	</div>
	<hr>
</div>

</div>
<%@include file="Footer.jsp"%>


