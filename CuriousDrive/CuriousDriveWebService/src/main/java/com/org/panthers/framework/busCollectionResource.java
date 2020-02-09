package com.org.panthers.framework;

import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busLink;

import java.util.Collection;
import java.util.Collections;

public class busCollectionResource extends busLink {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_LIMIT = 25;

    public busCollectionResource(UriInfo info, String subPath, Collection<?> c) {
        this(info, subPath, c, 0, getLimit(c));
    }

    public busCollectionResource(UriInfo info, String subPath, Collection<?> c, int offset, int limit) {
        super(info, subPath);
        put("offset", offset);
        put("limit", getLimit(limit));
        put("items", c != null ? c : Collections.emptyList());
    }

    private static int getLimit(Collection<?> c) {
        return getLimit(c != null ? c.size() : 0);
    }

    private static int getLimit(int limit) {
        return Math.max(DEFAULT_LIMIT, limit);
    }

}
