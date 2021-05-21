package com.sarm.konnex.ui.announcement;

public class writingsModel {
    private String title;

    public writingsModel(String title) {
        this.title = title;
    }

    public writingsModel() {
    }

    public String getWritings() {
        return title;
    }

    public void setWritings(String writings) {
        this.title = writings;
    }
}
