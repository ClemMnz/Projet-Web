package fr.eni.dao.contract;


public interface IFormationContract {

public static final String TABLE_FORMATIONS = "FORMATIONS";
	
	public static final String COL_FORMATION_ID = "Id";
	public static final String COL_FORMATION_LIBELLE = "libelle";
	public static final String COL_FORMATION_DESCRIPTION = "description";

	public static final String SELECT_ALL = "SELECT * FROM " + TABLE_FORMATIONS;
	
	public static final String INSERT = "INSERT INTO " + TABLE_FORMATIONS + 
			  " VALUES("+
			  " ?, ?)";
	
	public static final String SELECT_BY_ID =SELECT_ALL
			  +" WHERE "+ COL_FORMATION_ID+" =?"; 
	
	public static final String UPDATE = "UPDATE "+ TABLE_FORMATIONS+ " SET "+
			COL_FORMATION_LIBELLE +" =? ," +
			COL_FORMATION_DESCRIPTION +" =? "
			+ " WHERE "+ COL_FORMATION_ID +"=?";
	
	public static final String DELETE = "DELETE FROM "+ TABLE_FORMATIONS +" WHERE "+COL_FORMATION_ID+" =?";
}
