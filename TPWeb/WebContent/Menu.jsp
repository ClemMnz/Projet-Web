
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="http://localhost:8080/TPWeb/AccueilServlet">Accueil</a></li>
					<li><a href="http://localhost:8080/TPWeb/RecupererFormationsServlet">Liste des formations</a></li>
					<li><a href="http://localhost:8080/TPWeb/AnimateurServlet">Accès
							animateurs</a></li>
					<li><a href="http://localhost:8080/TPWeb/StagiaireServlet">Accès
							stagiaires</a></li>
				</ul>
				
				
				<form class="navbar-form navbar-right"
					action="http://www.google.fr/search">
					<div class="form-group">
						<input type="text" name="q">
					</div>
					<button type="submit" class="btn btn-success">Rechercher</button>
				
				</form >
				
				<form action="DeconnexionServlet" class="navbar-form navbar-right">
					<button type="submit" class="btn btn-success" value="Sedeconnecter" name="bouton">Se Déconnecter</button>
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
