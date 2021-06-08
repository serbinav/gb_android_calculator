package com.example.calculator;


public enum ApplicationThemes {

    ONE_THEMES(R.style.Theme_Calculator, "first_themes"),
    TWO_THEMES(R.style.Theme_Calculator_Another, "second_themes"),
    THREE_THEMES(R.style.Theme_Calculator_Light, "third_themes");

    ApplicationThemes(int resource, String key){
        this.resource = resource;
        this.key = key;
    }

    private int resource;
    private String key;

    public int getResource() {
        return resource;
    }

    public String getKey() {
        return key;
    }
}
