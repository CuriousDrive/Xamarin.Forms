package com.org.panthers.framework;

import javax.ws.rs.core.UriInfo;

import com.org.panthers.entity.Entity_Class;

import java.util.LinkedHashMap;

public class busLink extends LinkedHashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PATH_SEPARATOR = "/";

	public static final String USERS = PATH_SEPARATOR + "users";
	public static final String CODES = PATH_SEPARATOR + "codes";
	public static final String QUESTIONS = PATH_SEPARATOR + "questions";
	public static final String ADMIN = PATH_SEPARATOR + "admin";
	public static final String VOTES = PATH_SEPARATOR + "votes";
	public static final String ANNOUNCEMENTS = PATH_SEPARATOR + "announcements";

	public busLink(UriInfo info, Entity_Class entity) {
		this(getFullyQualifiedContextPath(info), entity);
	}

	public busLink(String fqBasePath, Entity_Class entity) {
		String href = createHref(fqBasePath, entity);
		put("href", href);
	}

	public busLink(UriInfo info, String subPath) {
		this(getFullyQualifiedContextPath(info), subPath);
	}

	public busLink(String fqBasePath, String subPath) {
		String href = fqBasePath + subPath;
		put("href", href);
	}

	protected static String getFullyQualifiedContextPath(UriInfo info) {
		String fq = info.getBaseUri().toString();
		if (fq.endsWith("/")) {
			return fq.substring(0, fq.length() - 1);
		}
		return fq;
	}

	protected String createHref(String fqBasePath, Entity_Class entity) {
		StringBuilder sb = new StringBuilder(fqBasePath);
		busResourcePath path = busResourcePath.forClass(entity.getClass());
		sb.append(path.getPath()).append(PATH_SEPARATOR).append(entity.getId());
		return sb.toString();
	}

	public String getHref() {
		return (String) get("href");
	}

}
