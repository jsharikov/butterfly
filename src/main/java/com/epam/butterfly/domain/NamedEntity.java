package com.epam.butterfly.domain;

import java.io.Serializable;

/**
 * Named entity.
 *
 * @author Artsiom_Buyevich
 */
public class NamedEntity implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" + "name='" + name + '\'' + '}';
    }
}
