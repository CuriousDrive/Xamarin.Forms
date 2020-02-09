package com.org.panthers.framework;

import javax.ws.rs.core.UriInfo;

import com.org.panthers.entity.Todo;

public class busTodoResource extends busLink {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public busTodoResource(UriInfo info, Todo todo) {
        super(info, todo);
        put("name", todo.getName());
        put("done", todo.isDone());
        put("created", todo.getCreated());
        //put("user", new Link(getFullyQualifiedContextPath(info), todo.getUser()));
    }
}
