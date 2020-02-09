
package com.org.panthers.framework;

/**
 *
 */
public class busUnknownResourceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public busUnknownResourceException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public busUnknownResourceException(String s) {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public busUnknownResourceException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public busUnknownResourceException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
