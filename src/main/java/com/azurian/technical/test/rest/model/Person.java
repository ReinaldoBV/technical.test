
package com.azurian.technical.test.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Person.
 */
public class Person {

    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The links. */
    @SerializedName("_links")
    private Links links;

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the links.
     *
     * @return the links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * Sets the links.
     *
     * @param links the new links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

}
