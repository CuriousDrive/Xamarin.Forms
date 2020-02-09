package com.org.panthers.framework;

import com.org.panthers.entity.Entity_Class;
import com.org.panthers.entity.Todo;

public enum busResourcePath {

    todos(busLink.VOTES, Todo.class);
    //users(Link.USERS, User.class);

    final String path;
    final Class<? extends Entity_Class> associatedClass;

    private busResourcePath(String elt, Class<? extends Entity_Class> clazz) {
        path = elt;
        associatedClass = clazz;
    }

    public static busResourcePath forClass(Class<? extends Entity_Class> clazz) {
        for (busResourcePath rp : values()) {
            //Cannot use equals because of hibernate proxied object
            //Cannot use instanceof because type not fixed at compile time
            if (rp.associatedClass.isAssignableFrom(clazz)) {
                return rp;
            }
        }
        throw new IllegalArgumentException("No ResourcePath for class '" + clazz.getName() + "'");
    }

    public String getPath() {
        return path;
    }

    public Class<? extends Entity_Class> getAssociatedClass() {
        return associatedClass;
    }
}
