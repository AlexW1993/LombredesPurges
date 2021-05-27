package com.example.lombredespurges.domaine.entité.aventuresTéléchargeables;

public class AventureTéléchargeable {

    private String title;
    private Chapters [] chapters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Chapters[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapters [] chapters) {
        this.chapters = chapters;
    }
}
