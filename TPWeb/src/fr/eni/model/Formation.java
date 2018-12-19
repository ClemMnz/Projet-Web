package fr.eni.model;
/**
 * Représente la classe Formation dans le model 
 *
 * @author cmenez2016
 *
 */

public class Formation {

	private int codeFormation; 
	private String libelle; 
	private String description;
	
	
	public int getCodeFormation() {
		return codeFormation;
	}
	public void setCodeFormation(int codeFormation) {
		this.codeFormation = codeFormation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Formation() {
		super();
	}
	public Formation(int codeFormation, String libelle, String description) {
		this();
		setCodeFormation(codeFormation);
		setLibelle(libelle); 
		setDescription(description); 
	}
	public int compareTo(Formation formation) {
		return this.getLibelle().compareTo(formation.getLibelle());
	}
	protected Formation clone() throws CloneNotSupportedException {
		return (Formation)super.clone();
	}

	public String toString() {
		return "<h3>"+libelle+"</h3>" 
				+ "<br/>"+description; 
	}
}
