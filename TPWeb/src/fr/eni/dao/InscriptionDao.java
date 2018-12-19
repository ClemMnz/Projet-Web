package fr.eni.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.dao.utils.ICrud;
import fr.eni.model.Inscription;

public class InscriptionDao implements ICrud<Inscription>{

	@Override
	public boolean Create(Inscription item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Inscription> Get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inscription Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(Inscription item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Inscription item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Inscription itemBuilder(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
