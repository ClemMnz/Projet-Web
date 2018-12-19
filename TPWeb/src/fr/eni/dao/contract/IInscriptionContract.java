package fr.eni.dao.contract;

public interface IInscriptionContract {

public static final String TABLE_INSCRIPTIONS = "INSCRIPTIONS";
	
	public static final String COL_INSCRIPTION_ID = "id";
	public static final String COL_INSCRIPTION_ID_FORMATION = "idFormation";
	public static final String COL_INSCRIPTION_ID_STAGIAIRE = "idStagiaire";

	public static final String SELECT_ALL = "SELECT * FROM " + TABLE_INSCRIPTIONS;
	
	public static final String INSERT = "INSERT INTO " + TABLE_INSCRIPTIONS + 
			  " VALUES("+
			  " ?, ?)";
	
	public static final String SELECT_BY_ID_INSCRIPTION =SELECT_ALL
			  +" WHERE "+ COL_INSCRIPTION_ID +" =?"; 
	SELECT  ins.id,ins.idFormation,ins.idStagiaire, sta.nom,sta.prenom,sta.mail,form.description, form.libelle
	FROM INSCRIPTIONS ins 
	FULL JOIN STAGIAIRES sta on 
	sta.id= ins.idStagiaire
	FULL JOIN FORMATIONS form on
	form.Id=ins.idFormation 
	
	public static final String UPDATE = "UPDATE "+ TABLE_INSCRIPTIONS+ " SET "+
			COL_FORMATION_ID +" =? ," +
			COL_FORMATION_DESCRIPTION +" =? "
			+ " WHERE "+ COL_INSCRIPTION_ID +"=?";
	
	public static final String DELETE = "DELETE FROM "+ TABLE_INSCRIPTIONS +" WHERE "+COL_INSCRIPTION_ID+" =?";
	
}
