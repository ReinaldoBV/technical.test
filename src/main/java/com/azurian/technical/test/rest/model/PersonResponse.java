
package com.azurian.technical.test.rest.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The Class PersonResponse.
 */
public class PersonResponse {

    /** The embedded. */
    @SerializedName("_embedded")
    private Embedded embedded;
    
    /** The links. */
    @SerializedName("_links")
    private Links__1 links;
    
    /** The page. */
    private Page page;

    /**
     * Gets the embedded.
     *
     * @return the embedded
     */
    public Embedded getEmbedded() {
        return embedded;
    }

    /**
     * Sets the embedded.
     *
     * @param embedded the new embedded
     */
    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    /**
     * Gets the links.
     *
     * @return the links
     */
    public Links__1 getLinks() {
        return links;
    }

    /**
     * Sets the links.
     *
     * @param links the new links
     */
    public void setLinks(Links__1 links) {
        this.links = links;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public Page getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(Page page) {
        this.page = page;
    }

}
