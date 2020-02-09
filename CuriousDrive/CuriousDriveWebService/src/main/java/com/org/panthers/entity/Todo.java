/*
 * Copyright (C) 2012 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.org.panthers.entity;

import java.util.Date;

public class Todo extends Entity_Class {

    public String toString() {
		return "Todo [name=" + name + ", done=" + done + ", created=" + created
				+ ", user=" + user + "]";
	}

	private String name;
    private boolean done;
    private Date created;
    private doUser user;

    public Todo(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public doUser getUser() {
        return user;
    }

    public void setUser(doUser user) {
        this.user = user;
    }
}
