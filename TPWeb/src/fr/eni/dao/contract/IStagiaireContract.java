package fr.eni.dao.contract;

public interface IStagiaireContract {

public static final String TABLE_STAGIAIRES = "STAGIAIRES";
	
	public static final String COL_STAGIAIRE_ID = "id";
	public static final String COL_STAGIAIRE_NOM = "nom";
	public static final String COL_STAGIAIRE_PRENOM = "prenom";
	public static final String COL_STAGIAIRE_MAIL = "mail";
	public static final String COL_STAGIAIRE_MOTDEPASSE = "motDePasse";
	
    public static final String SELECT_ALL = "SELECT * FROM " + TABLE_STAGIAIRES;
	
	public static final String INSERT = "INSERT INTO " + TABLE_STAGIAIRES + 
			  " VALUES("+
			  " ?, ?, ?, ?)";
	
	public static final String SELECT_BY_ID =SELECT_ALL
			  +" WHERE "+ COL_STAGIAIRE_ID+" =?"; 
	
	public static final String UPDATE = "UPDATE "+ TABLE_STAGIAIRES+ " SET "+
			COL_STAGIAIRE_NOM +" =? ," +
			COL_STAGIAIRE_PRENOM +" =? "+
			COL_STAGIAIRE_MAIL+" =?"+
			COL_STAGIAIRE_MOTDEPASSE+" =?"
			+ " WHERE "+ COL_STAGIAIRE_ID +"=?";
	
	public static final String DELETE = "DELETE FROM "+ TABLE_STAGIAIRES +" WHERE "+COL_STAGIAIRE_ID+" =?";

}
