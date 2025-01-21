package com.jackgdn;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Member {
    private int memberId;
    private String name;
    private List<Book> onLoanBooksList = new ArrayList<Book>();

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public List<Book> getOnloanBooksList() {
        return this.onLoanBooksList;
    }

    public void borrowBook(Book book) {
        this.onLoanBooksList.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        this.onLoanBooksList.remove(book);
        book.returnBook();
    }

    @Override
    public String toString() {
        String name = this.name;
        String onLoanBooks;
        if (this.onLoanBooksList.isEmpty()) {
            onLoanBooks = "-";
        } else {
            onLoanBooks = this.onLoanBooksList
                    .stream()
                    .map(Book::getBookTitle)
                    .collect(Collectors.joining("\n"));
        }
        return String.format("%s\nOn loan book(s):\n%s", name, onLoanBooks);
    }
}
