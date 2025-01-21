package com.jackgdn;

public class Record {
    private Book book;
    private Member member;
    private boolean isOnLoan = true;
    private String issueDate;

    public Record(Book book, Member member, String issueDate) {
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.member.borrowBook(this.book);
    }

    public int getMemberId() {
        return this.member.getMemberId();
    }

    public String getBookCode() {
        return this.book.getBookCode();
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public boolean isOnLoan() {
        return this.isOnLoan;
    }

    public void returnBook() {
        this.isOnLoan = false;
        this.member.returnBook(this.book);
    }

    @Override
    public String toString() {
        String name = this.member.getName();
        String title = this.book.toString();
        String issueDate = this.issueDate;
        return String.format("%s, %s, issued date=%s", name, title, issueDate);
    }
}
