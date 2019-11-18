package br.com.controledepresenca.mvc.model.crud;

import java.util.List;
import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;

public abstract class AbstractCRUD {

	public abstract void insert(Object o);
	public abstract void delete(Object o);
	public abstract void update(Object o);
	public abstract List<AbstractPersistentObject> read(Object o);
}
