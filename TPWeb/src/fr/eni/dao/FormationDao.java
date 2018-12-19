package fr.eni.dao;

import static fr.eni.dao.contract.IFormationContract.COL_FORMATION_DESCRIPTION;
import static fr.eni.dao.contract.IFormationContract.COL_FORMATION_ID;
import static fr.eni.dao.contract.IFormationContract.COL_FORMATION_LIBELLE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import fr.eni.dao.contract.IFormationContract;
import fr.eni.dao.utils.BddUtils;
import fr.eni.dao.utils.ICrud;
import fr.eni.model.Formation;
import fr.eni.utils.MonLogger;

/**
 * Représente la classe FormationDao
 *  qui donne accès à la BDD 
 * @author cmenez2016
 *
 */

public class FormationDao implements ICrud<Formation> {

	private Logger monLogger = MonLogger.getLogger(this.getClass().getSimpleName());
	protected Connection cnx = null;

	public List<Formation> Get() {
		monLogger.info("Début Get()");
		List<Formation> liste = new ArrayList<>();
		try (Connection cnx = BddUtils.getConnexion()) {
			Statement requete = cnx.createStatement();
			ResultSet rs = requete.executeQuery(IFormationContract.SELECT_ALL);
			while (rs.next()) {
				liste.add(itemBuilder(rs));
			}
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}

		return liste;
	}

	public boolean Create(Formation item) {
		monLogger.info("Debut Insert()");
		int nombreLignesAffecté = 0;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IFormationContract.INSERT);
			requete.setString(1, item.getLibelle());
			requete.setString(2, item.getDescription());
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté) > 0;

	}

	public Formation Get(int id) {
		monLogger.info("Debut Get()");
		Formation result = null;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IFormationContract.SELECT_BY_ID);
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();
			if (rs.next()) {
				result = itemBuilder(rs);
			}
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return result;
	}

	public boolean Update(Formation item) {
		monLogger.info("Début Update() avec " + item);
		int nombreLignesAffecté = 0;

		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IFormationContract.UPDATE);

			requete.setString(1, item.getLibelle());
			requete.setString(2, item.getDescription());
			requete.setInt(3,item.getCodeFormation());
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté > 0);
	}

	public boolean Delete(int id) {

		int nombreLignesAffecté = 0;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IFormationContract.DELETE);
			requete.setInt(1, id);
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté > 0);
	}

	public boolean Delete(Formation item) {
		return this.Delete(item.getCodeFormation());
	}

	public Formation itemBuilder(ResultSet rs) throws SQLException {
		Formation formation = new Formation();
		formation.setCodeFormation(rs.getInt(COL_FORMATION_ID));
		formation.setLibelle(rs.getString(COL_FORMATION_LIBELLE));
		formation.setDescription(rs.getString(COL_FORMATION_DESCRIPTION));
		return formation;
	}
}
