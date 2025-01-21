package com.jackgdn;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyLibrary {
    private List<Book> booksList = new ArrayList<>();
    private List<Record> onLoanRecordsList = new ArrayList<>();
    private List<Record> allRecordsList = new ArrayList<>();

    public MyLibrary(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                this.booksList.add(new Book(tokens[0], tokens[1]));
                count++;
            }
            System.out.println(String.format("%d books loaded.", count));
        } catch (IOException e) {
            System.out.println(String.format("ERROR: The file '%s' does not exist.", filename));
        }
    }

    public void showAllBooks() {
        for (Book book : this.booksList) {
            System.out.println(book);
        }
    }

    public Book findBook(String code) {
        return this.booksList
                .stream()
                .filter(book -> (book.getBookCode().equals(code) && book.isAvailable()))
                .findFirst()
                .orElse(null);
    }

    public void borrowBook(Book book, Member member, String issueDate) {
        if (this.booksList.contains(book) && book.isAvailable()) {
            Record record = new Record(book, member, issueDate);
            this.onLoanRecordsList.add(record);
            this.allRecordsList.add(record);
            System.out.println(String.format("%s is borrowed by %s.", book.getBookTitle(), member.getName()));
        } else {
            System.out.println("ERROR: could not issue the book.");
        }
    }

    public void showAvailableBooks() {
        for (Book book : this.booksList) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public Record findRecord(String code) {
        return this.onLoanRecordsList
                .stream()
                .filter(record -> record.getBookCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public void returnBook(Record record) {
        if (this.onLoanRecordsList.contains(record)) {
            record.returnBook();
            this.onLoanRecordsList.remove(record);
            System.out.println(String.format("%s is returned successfully.", record.getBookCode()));
        } else {
            System.out.println("ERROR: could not return the book.");
        }
    }

    public void showOnLoanRecords() {
        for (Record record : this.onLoanRecordsList) {
            System.out.println(record);
        }
    }

    public void showAllRecords() {
        for (Record record : this.allRecordsList) {
            System.out.println(record);
        }
    }
}
