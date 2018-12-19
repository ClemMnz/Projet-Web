package fr.eni.dao.contract;


public interface IAnimateurContract {

public static final String TABLE_ANIMATEURS = "ANIMATEURS";
	
	public static final String COL_ANIMATEUR_ID = "Id";
	public static final String COL_ANIMATEUR_MAIL = "adresseMail";
	public static final String COL_ANIMATEUR_MOT_DE_PASSE= "motDePasse";
	public static final String COL_ANIMATEUR_NOM= "nom";
	public static final String COL_ANIMATEUR_PRENOM= "prenom";

	public static final String SELECT_ALL = "SELECT * FROM " +TABLE_ANIMATEURS;
	
	public static final String SELECT_BY_MAIL = "SELECT * FROM "+ 
			TABLE_ANIMATEURS +" WHERE "+COL_ANIMATEUR_MAIL +" =?";

	
	public static final String INSERT = "INSERT INTO " + TABLE_ANIMATEURS+ 
			  " VALUES("+
			  " ?, ?, ?, ?)";
	
	public static final String SELECT_BY_ID =SELECT_ALL
			  +" WHERE "+ COL_ANIMATEUR_ID+" =?"; 
	
	public static final String UPDATE = "UPDATE "+ TABLE_ANIMATEURS+ " SET "+
			COL_ANIMATEUR_MAIL +" =? ," +
			COL_ANIMATEUR_MOT_DE_PASSE +
				COL_ANIMATEUR_NOM +" =? ," +
				COL_ANIMATEUR_PRENOM +" =? ,"+
			" =? " +" WHERE "+ COL_ANIMATEUR_ID +"=?";
	
	public static final String DELETE = "DELETE FROM "+ TABLE_ANIMATEURS +" WHERE "+COL_ANIMATEUR_ID+" =?";
}
