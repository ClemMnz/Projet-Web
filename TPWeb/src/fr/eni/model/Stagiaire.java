package fr.eni.model;

public class Stagiaire {
	
	private int id; 
	private String nom; 
	private String prenom; 
	private String mail; 
	private String motDePasse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public Stagiaire() {
		super();
	}
	public Stagiaire(int id, String nom, String prenom, String mail, String motDePasse) {
		super();
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setMail(mail);
		setMotDePasse(motDePasse);
	
	}
	@Override
	public String toString() {
		return "<h6>"+nom+"</h6>" 
				+ "<br/>"+prenom+"<br/>"+ mail +"<br/>" 
						+motDePasse ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		if (id != other.id)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public int compareTo(String anotherString) {
		return mail.compareTo(anotherString);
	}
	
	
	
	
	

}
