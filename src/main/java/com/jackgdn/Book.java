package com.jackgdn;

public class Book {
    private String code;
    private String title;
    private boolean status = true;

    public Book(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getBookCode() {
        return this.code;
    }

    public String getBookTitle() {
        return this.title;
    }

    public boolean isAvailable() {
        return this.status;
    }

    public void borrowBook() {
        this.status = false;
    }

    public void returnBook() {
        this.status = true;
    }

    @Override
    public String toString() {
        String title = this.title;
        String code = this.code;
        String status = this.status ? "Available" : "On Loan";
        return String.format("%s, %s (%s)", title, code, status);
    }
}
