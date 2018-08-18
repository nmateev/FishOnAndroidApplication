package com.mateev.fishon.models;

import java.io.Serializable;

public class Quote implements Serializable {


    public String quoteText;
    public String author;

    public Quote() {

    }

    public Quote(String quoteText, String author) {
        setQuoteText(quoteText);
        setAuthor(author);
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getAuthor() {
        return author;
    }

    private void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }


    private void setAuthor(String author) {
        this.author = author;
    }
}
