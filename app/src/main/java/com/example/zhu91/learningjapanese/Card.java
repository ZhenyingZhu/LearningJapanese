package com.example.zhu91.learningjapanese;

/**
 * Created by Zhu91 on 10/18/2015.
 */
public class Card {
    private String word;
    private String content;
    private boolean correct = false;

    public Card(String word, String content) {
        this.word = word;
        this.content = content;
    }

    public String getWord() {
        return word;
    }

    public String getContent() {
        return content;
    }

    public void setCorrect() {
        correct = true;
    }

    public boolean getCorrect() {
        return correct;
    }
}
