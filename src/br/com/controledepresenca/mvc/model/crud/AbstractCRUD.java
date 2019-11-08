package br.com.controledepresenca.mvc.model.crud;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;

public abstract class AbstractCRUD {

	public abstract void insert();
	public abstract void delete();
	public abstract void update();
	public abstract ArrayList<AbstractPersistentObject> retrive(PreparedStatement stm);
}
