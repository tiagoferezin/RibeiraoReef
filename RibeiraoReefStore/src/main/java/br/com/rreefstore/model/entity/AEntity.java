/**
 * 
 */
package br.com.rreefstore.model.entity;

import java.util.Calendar;

import br.com.rreefstore.model.interfaces.IEntity;

/**
 * @author Windows 7
 *
 */
public abstract class AEntity<T> implements IEntity {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isEmptyId() {
		return ((getId() == null) || (getId() == 0L));
	}

}
