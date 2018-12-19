package fr.eni.dao;

import static fr.eni.dao.contract.IStagiaireContract.COL_STAGIAIRE_ID;
import static fr.eni.dao.contract.IStagiaireContract.COL_STAGIAIRE_NOM;
import static fr.eni.dao.contract.IStagiaireContract.COL_STAGIAIRE_PRENOM;
import static fr.eni.dao.contract.IStagiaireContract.COL_STAGIAIRE_MAIL;
import static fr.eni.dao.contract.IStagiaireContract.COL_STAGIAIRE_MOTDEPASSE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.dao.contract.IAnimateurContract;
import fr.eni.dao.contract.IStagiaireContract;
import fr.eni.dao.utils.BddUtils;
import fr.eni.dao.utils.ICrud;
import fr.eni.model.Animateur;
import fr.eni.model.Formation;
import fr.eni.model.Stagiaire;
import fr.eni.utils.MonLogger;
/**
 * Représente  la classe StagiaireDao
 * Donne accès aux données.
 * 
 * @author cmenez2016
 *
 */
public class StagiaireDao implements  ICrud<Stagiaire>{

	private Logger monLogger = MonLogger.getLogger(this.getClass().getSimpleName());
	protected Connection cnx = null;
	@Override
	public boolean Create(Stagiaire item) {
		monLogger.info("Debut Insert()");
		int nombreLignesAffecté = 0;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IStagiaireContract.INSERT);
			
			requete.setString(1, item.getNom());
			requete.setString(2, item.getPrenom());
			requete.setString(3, item.getMail());
			requete.setString(4, item.getMotDePasse());
			
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté) > 0;
	}
	

	@Override
	public List<Stagiaire> Get() {
		monLogger.info("Debut Get() liste");
		List<Stagiaire> liste = new ArrayList<>();
		try (Connection cnx = BddUtils.getConnexion()) {
			Statement requete = cnx.createStatement();
			ResultSet rs = requete.executeQuery(IStagiaireContract.SELECT_ALL);
			while (rs.next()) {
				liste.add(itemBuilder(rs));
			}
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}

		return liste;
	}

	@Override
	public Stagiaire Get(int id) {
		monLogger.info("Debut Get()");
		Stagiaire result = null;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IStagiaireContract.SELECT_BY_ID);
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

	@Override
	public boolean Update(Stagiaire item) {
		monLogger.info("Debut Insert()");
		int nombreLignesAffecté = 0;

		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IStagiaireContract.UPDATE);

			requete.setString(1, item.getNom());
			requete.setString(2, item.getPrenom());
			requete.setString(3, item.getMail());
			requete.setString(4, item.getMotDePasse());
			
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté > 0);
		
	}

	@Override
	public boolean Delete(int id) {
		monLogger.info("Début delete()");

		int nombreLignesAffecté = 0;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IStagiaireContract.DELETE);
			requete.setInt(1, id);
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté > 0);
	}
	

	@Override
	public boolean Delete(Stagiaire item) {
		return this.Delete(item.getId());
	}

	@Override
	public Stagiaire itemBuilder(ResultSet rs) throws SQLException {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setId(rs.getInt(COL_STAGIAIRE_ID));
		stagiaire.setNom(rs.getString(COL_STAGIAIRE_NOM));
		stagiaire.setPrenom(rs.getString(COL_STAGIAIRE_PRENOM));
		stagiaire.setMail(rs.getString(COL_STAGIAIRE_MAIL));
		stagiaire.setMotDePasse(rs.getString(COL_STAGIAIRE_MOTDEPASSE));
		return stagiaire;
	}



}
