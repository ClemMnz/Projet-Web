package fr.eni.model;

/**
 * Représente la classe Animateur dans le model
 * 
 * @author cmenez2016
 *
 */
public class Animateur {

	private int id;
	private String adresseMail;
	private String motDePasse;
	private String nom;
	private String prenom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	public Animateur() {
		super();
	}
	public Animateur(int id, String adresseMail, String motDePasse, String nom, String prenom) {
		super();
		setId(id); 
		setAdresseMail(adresseMail);
		setMotDePasse(motDePasse); 
		setNom(nom); 
		setPrenom(prenom);
		
	}
	@Override
	public String toString() {
		return "Animateur [id=" + id + ", adresseMail=" + adresseMail + ", motDePasse=" + motDePasse + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}
	
	

	
	
	
}
