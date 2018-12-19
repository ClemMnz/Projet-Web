package fr.eni.model;

public class Inscription {

	private int Id; 
	private Stagiaire idStagiaire; 
	private Formation idFormation;
	
	

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Stagiaire getIdStagiaire() {
		return idStagiaire;
	}
	public void setIdStagiaire(Stagiaire idStagiaire) {
		this.idStagiaire = idStagiaire;
	}
	public Formation getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(Formation idFormation) {
		this.idFormation = idFormation;
	} 
		
	public Inscription() {
		super();
	}
	public Inscription(int id, Stagiaire idStagiaire, Formation idFormation) {
		super();
		setId(id);
	    setIdStagiaire(idStagiaire);
	    setIdFormation(idFormation);
	}
	@Override
	public String toString() {
		return "<h3>" + Id + "<br/>" + idStagiaire + "<br/>" + idFormation ;
	}
	
	
}
