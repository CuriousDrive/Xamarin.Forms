package com.org.panthers.framework;


public abstract class doBase<E> {

	public String istrMode;
	public int iintUserId;
	
	public abstract int insert();
	public abstract int delete();
	public abstract int update();
	public abstract E get();
	public abstract void loadCreatedByProperties();
	public abstract void loadModifiedByProperties();
}
