package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class AutreAventure {

    /**
     * Declaration des Aventure
     */
    private String title;
    private String url;

    /**
     * Accesseurs du title de l'aventure
     *
     * @return (String) le title de l'aventure.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mutateur de title
     *
     * @param title, le title de l'aventure
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accesseurs d'url de l'aventure
     *
     * @return (String) l'url de l'aventure.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Mutateur d'url
     *
     * @param url, l'url de l'aventure
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
