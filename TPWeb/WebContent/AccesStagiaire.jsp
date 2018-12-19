
<%@include file="Header.jsp"%>

<%@include file="Menu.jsp"%>

<div class="container">
	<div class="starter-template">

		<div class="row titre">
			<div class="col-md-12 col-md-offset-4">TP Web-Accès Stagiaire</div>
		</div>
		<hr>
		<div class="row parag">
			<div class="col-md-6">
				<br>
				<form class="col-md-offset-4" action="<%=request.getContextPath()%>/StagiaireServlet" 
			method="post">
					<div class="form-group">
						<label for="id">Identifiant: </label> <input type="text"
							maxlength="20" placeholder="Identifiant" class="form-control"
							id="id" name="login">
					</div>
					<div class="form-group">
						<label for="password">Mot de passe: </label> <input
							type="password" placeholder="Mot de passe" maxlength="20"
							class="form-control" id="password" name="password">
					</div>
					<button type="submit" class="btn btn-success">Se connecter</button>
					<br>
				</form>
				<br>
			</div>
		</div>
		<hr>
	</div>

</div>


<%@include file="Footer.jsp"%>