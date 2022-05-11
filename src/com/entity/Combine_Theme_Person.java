package com.entity;

public class Combine_Theme_Person {
    Theme_Post theme_post;
    Person person;

    public void setTheme_post(Theme_Post theme_post) {
        this.theme_post = theme_post;
    }

    public Theme_Post getTheme_post() {
        return theme_post;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Combine_Theme_Person{" +
                "theme_post=" + theme_post +
                ", person=" + person +
                '}';
    }
}
