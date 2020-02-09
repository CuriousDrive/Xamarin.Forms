package com.org.panthers.framework;

import javax.ws.rs.core.UriInfo;


public abstract class cdoBase<E> {
	
	//methods to be implemented!!!
	public abstract int insert();
	public abstract int delete();
	public abstract int update();
	public abstract int get();
	public abstract void loadCreatedByProperties();
	public abstract void loadModifiedByProperties();
	public abstract E getObject(UriInfo info, int id);
	
}
