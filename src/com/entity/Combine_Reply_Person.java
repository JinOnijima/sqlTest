package com.entity;

public class Combine_Reply_Person {
    Reply_Post reply_post;
    Person person;

    public void setReply_post(Reply_Post reply_post) {
        this.reply_post = reply_post;
    }

    public Reply_Post getReply_post() {
        return reply_post;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Combine_Reply_Person{" +
                "reply_post=" + reply_post +
                ", person=" + person +
                '}';
    }
}
