

<%@include file="Header.jsp" %>
<%@include file="Menu.jsp" %>
<div class="container">
		<div class="starter-template ">

			<div class="row titre">
				<div class="col-md-12 col-md-offset-4">
					TP Web-Accès Animateur
				</div>
			</div>
			<hr>
			<div class="row parag">
				<div class="col-md-6 ">
				<br>
					<form class="col-md-offset-4"action="<%=request.getContextPath()%>/AnimateurServlet" 
			>
						<div class="form-group ">
							<label for="id">Identifiant: </label> <input type="text"
								maxlength="20"  placeholder="Identifiant" class="form-control" id="id" name="login">
						</div>
						<div class="form-group">
							<label for="password">Mot de passe: </label> <input
								type="password" placeholder="Mot de passe" class="form-control"
								id="password" maxlength="20" name="password">
						</div>
						<div class="form-group">
							<label for="connecté">Connecté :</label> <input type="checkbox" name="stayConnected" id="connecté">
							</div> 
						<button type="submit" class="btn btn-success">Se
							connecter</button>
							
					</form>
					<br>
				</div>
			</div>
			<hr>
		</div>
		
	</div>


<%@include file="Footer.jsp" %>



