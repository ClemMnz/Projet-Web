package fr.eni.dao;

import static fr.eni.dao.contract.IAnimateurContract.COL_ANIMATEUR_ID;
import static fr.eni.dao.contract.IAnimateurContract.COL_ANIMATEUR_NOM;
import static fr.eni.dao.contract.IAnimateurContract.COL_ANIMATEUR_PRENOM;
import static fr.eni.dao.contract.IAnimateurContract.COL_ANIMATEUR_MAIL;
import static fr.eni.dao.contract.IAnimateurContract.COL_ANIMATEUR_MOT_DE_PASSE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.dao.contract.IAnimateurContract;
import fr.eni.dao.contract.IFormationContract;
import fr.eni.dao.utils.BddUtils;
import fr.eni.dao.utils.ICrud;
import fr.eni.model.Animateur;
import fr.eni.model.Formation;
import fr.eni.utils.MonLogger;

public class AnimateurDao implements ICrud<Animateur>{

	private Logger monLogger = MonLogger.getLogger(this.getClass().getSimpleName());
	protected Connection cnx = null;
	
	@Override
	public boolean Create(Animateur item) {
		monLogger.info("Debut Insert()");
		int nombreLignesAffecté = 0;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IAnimateurContract.INSERT);
			requete.setInt(1, item.getId());
			requete.setString(2, item.getAdresseMail());
			requete.setString(3, item.getMotDePasse());
			requete.setString(4, item.getNom());
			requete.setString(5, item.getPrenom());
			
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté) > 0;
	}

	@Override
	public List<Animateur> Get() {
		monLogger.info("Debut Get()");
		List<Animateur> liste = new ArrayList<>();
		try (Connection cnx = BddUtils.getConnexion()) {
			Statement requete = cnx.createStatement();
			ResultSet rs = requete.executeQuery(IAnimateurContract.SELECT_ALL);
			while (rs.next()) {
				liste.add(itemBuilder(rs));
			}
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}

		return liste;
	}

	@Override
	public Animateur Get(int id) {
		monLogger.info("Debut Get()");
		Animateur result = null;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IAnimateurContract.SELECT_BY_ID);
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
	
	public Animateur GetByMail(String mail) {
		monLogger.info("Debut GetbyMail()");
		Animateur result = null;
		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IAnimateurContract.SELECT_BY_MAIL);
			requete.setString(1, mail);
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
	public boolean Update(Animateur item) {
		monLogger.info("Debut Insert()");
		int nombreLignesAffecté = 0;

		try (Connection cnx = BddUtils.getConnexion()) {
			PreparedStatement requete = cnx.prepareStatement(IAnimateurContract.UPDATE);

			requete.setString(1, item.getAdresseMail());
			requete.setString(2, item.getMotDePasse());
			requete.setString(2, item.getNom());
			requete.setString(2, item.getPrenom());
			
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
			PreparedStatement requete = cnx.prepareStatement(IAnimateurContract.DELETE);
			requete.setInt(1, id);
			nombreLignesAffecté = requete.executeUpdate();
		} catch (Exception ex) {
			monLogger.severe(ex.getMessage());
		}
		return (nombreLignesAffecté > 0);
	}

	@Override
	public boolean Delete(Animateur item) {
		return this.Delete(item.getId());
	}

	@Override
	public Animateur itemBuilder(ResultSet rs) throws SQLException {
		Animateur animateur = new Animateur(); 
		animateur.setId(rs.getInt(COL_ANIMATEUR_ID));
		animateur.setAdresseMail(rs.getString(COL_ANIMATEUR_MAIL));
		animateur.setMotDePasse(rs.getString(COL_ANIMATEUR_MOT_DE_PASSE));
		animateur.setNom(rs.getString(COL_ANIMATEUR_NOM));
		animateur.setPrenom(rs.getString(COL_ANIMATEUR_PRENOM));
		return animateur;
	}
	
	
	
	
	
	

}
