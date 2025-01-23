package com.jackgdn;

public class Main {
    public static void main(String[] args) {
        System.out.println("Question 1:");
        Question1();
        System.out.println("Question 2:");
        Question2();
        System.out.println("Question 3:");
        Question3();
        System.out.println("Question 4:");
        Question4();
        System.out.println("Question 5:");
        Question5();
        System.out.println("Question 6:");
        Question6();
        System.out.println("Question 7:");
        Question7();
        System.out.println("Question 8:");
        Question8();
        System.out.println("Question 9:");
        Question9();
        System.out.println("Question 10:");
        Question10();
    }

    public static void Question1() {
        Book b1 = new Book("QS12.03.001", "The Lord Of The Rings");
        System.out.println(String.format("%s %s %s", b1.getBookCode(), b1.getBookTitle(), b1.isAvailable()));
        Book b2 = new Book("QK12.04.002", "The Hitchhiker's Guide To The Galaxy");
        System.out.println(String.format("%s %s %s", b2.getBookCode(), b2.getBookTitle(), b2.isAvailable()));
        /*
         * Output:
         * QS12.03.001 The Lord Of The Rings true
         * QK12.04.002 The Hitchhiker's Guide To The Galaxy true
         */

    public static void Question2() {
        Book b1 = new Book("QS12.03.001", "The Lord Of The Rings");
        System.out.println(b1);
        Book b2 = new Book("QK12.04.002", "The Hitchhiker's Guide To The Galaxy");
        System.out.println(b2);
        b2.borrowBook();
        System.out.println();
        System.out.println(b2);
        /*
         * Output:
         * The Lord Of The Rings, QS12.03.001 (Available)
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (Available)
         *
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (On Loan)
         */
    }

    public static void Question3() {
        Member m1 = new Member(1001, "Michael");
        System.out.println(String.format("%s %d", m1.getName(), m1.getMemberId()));
        Member m2 = new Member(1002, "Paul");
        System.out.println(String.format("%s %d", m2.getName(), m2.getMemberId()));
        /*
         * Output:
         * Michael 1001
         * Paul 1002
         */
    }

    public static void Question4() {
        Member m1 = new Member(1001, "Michael");
        Member m2 = new Member(1002, "Paul");
        Book b1 = new Book("QS12.03.001", "The Lord Of The Rings");
        Book b2 = new Book("QK12.04.002", "The Hitchhiker's Guide To The Galaxy");
        Book b3 = new Book("QS12.02.003", "The Dune Chronicles");
        m1.borrowBook(b1);
        m1.borrowBook(b2);
        m1.borrowBook(b3);
        m1.returnBook(b1);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        /*
         * Output:
         * Michael
         * On loan book(s):
         * The Hitchhiker's Guide To The Galaxy
         * The Dune Chronicles
         *
         * Paul
         * On loan book(s):
         * -
         */
    }

    public static void Question5() {
        Member m1 = new Member(1001, "Michael");
        Book b1 = new Book("QS12.03.001", "The Lord Of The Rings");
        Book b2 = new Book("QK12.04.002", "The Hitchhiker's Guide To The Galaxy");
        Book b3 = new Book("QS12.02.003", "The Dune Chronicles");
        Record r1 = new Record(b1, m1, "2020-08-12");
        System.out.println(
                String.format("%d %s %s %s", r1.getMemberId(), r1.getBookCode(), r1.getIssueDate(), r1.isOnLoan()));
        System.out.println();
        System.out.println(m1);
        System.out.println();
        System.out.println(b1);
        /*
         * Output:
         * 1001 QS12.03.001 2020-08-12 true
         *
         * Michael
         * On loan book(s):
         * The Lord Of The Rings
         *
         * The Lord Of The Rings, QS12.03.001 (On Loan)
         */
    }

    public static void Question6() {
        Member m1 = new Member(1001, "Michael");
        Book b1 = new Book("QS12.03.001", "The Lord Of The Rings");
        Book b2 = new Book("QK12.04.002", "The Hitchhiker's Guide To The Galaxy");
        Book b3 = new Book("QS12.02.003", "The Dune Chronicles");
        Record r1 = new Record(b1, m1, "2020-08-12");
        System.out.println(r1);
        Record r2 = new Record(b3, m1, "2020-08-15");
        System.out.println(r2);
        r1.returnBook();
        System.out.println();
        System.out.println(r1);
        System.out.println();
        System.out.println(b1);
        System.out.println();
        System.out.println(m1);
        /*
         * Output:
         * Michael, The Lord Of The Rings, QS12.03.001 (On Loan), issued date=2020-08-12
         * Michael, The Dune Chronicles, QS12.02.003 (On Loan), issued date=2020-08-15
         *
         * Michael, The Lord Of The Rings, QS12.03.001 (Available), issued
         * date=2020-08-12
         *
         * The Lord Of The Rings, QS12.03.001 (Available)
         *
         * Michael
         * On loan book(s):
         * The Dune Chronicles
         */
    }

    public static void Question7() {
        MyLibrary library = new MyLibrary("simple_books.txt");
        System.out.println();
        library.showAllBooks();
        /*
         * Output:
         * 5 books loaded.
         *
         * The Lord Of The Rings, QS12.03.001 (Available)
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (Available)
         * The Dune Chronicles, QS12.02.003 (Available)
         * A Song Of Ice And Fire Series, QA12.04.004 (Available)
         * The Foundation Trilogy, QS12.01.005 (Available)
         */
    }

    public static void Question8() {
        MyLibrary library = new MyLibrary("simple_books.txt");
        System.out.println();
        Book b1 = library.findBook("QS12.02.003");
        Member m1 = new Member(1001, "Michael");
        library.borrowBook(b1, m1, "2020-08-12");
        System.out.println();
        Book b2 = library.findBook("QA12.04.004");
        library.borrowBook(b2, m1, "2020-08-12");
        System.out.println();
        library.showAvailableBooks();
        System.out.println();
        System.out.println(m1);
        /*
         * Output:
         * 5 books loaded.
         *
         * The Dune Chronicles is borrowed by Michael.
         *
         * A Song Of Ice And Fire Series is borrowed by Michael.
         *
         * The Lord Of The Rings, QS12.03.001 (Available)
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (Available)
         * The Foundation Trilogy, QS12.01.005 (Available)
         *
         * Michael
         * On loan book(s):
         * The Dune Chronicles
         * A Song Of Ice And Fire Series
         */
    }

    public static void Question9() {
        MyLibrary library = new MyLibrary("simple_books.txt");
        System.out.println();
        Book b1 = library.findBook("QS12.02.003");
        Member m1 = new Member(1001, "Michael");
        Book b2 = library.findBook("QK12.04.002");
        library.borrowBook(b1, m1, "2020-08-12");
        System.out.println();
        library.borrowBook(b2, m1, "2020-08-15");
        System.out.println();
        Record r1 = library.findRecord("QK12.04.002");
        library.returnBook(r1);
        System.out.println();
        library.showAvailableBooks();
        System.out.println();
        System.out.println(m1);
        System.out.println();
        System.out.println(b2);
        /*
         * Output:
         * 5 books loaded.
         *
         * The Dune Chronicles is borrowed by Michael.
         *
         * The Hitchhiker's Guide To The Galaxy is borrowed by Michael.
         *
         * QK12.04.002 is returned successfully.
         *
         * The Lord Of The Rings, QS12.03.001 (Available)
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (Available)
         * A Song Of Ice And Fire Series, QA12.04.004 (Available)
         * The Foundation Trilogy, QS12.01.005 (Available)
         *
         * Michael
         * On loan book(s):
         * The Dune Chronicles
         *
         * The Hitchhiker's Guide To The Galaxy, QK12.04.002 (Available)
         */
    }

    public static void Question10() {
        MyLibrary library = new MyLibrary("simple_books.txt");
        Member m1 = new Member(1001, "Michael");
        library.borrowBook(library.findBook("QS12.02.003"), m1, "2020-08-12");
        library.borrowBook(library.findBook("QK12.04.002"), m1, "2020-08-15");
        library.showOnLoanRecords();
        /*
         * Output:
         * 5 books loaded.
         * The Dune Chronicles is borrowed by Michael.
         * The Hitchhiker's Guide To The Galaxy is borrowed by Michael.
         * Michael, The Dune Chronicles, QS12.02.003 (On Loan), issued date=2020-08-12
         * Michael, The Hitchhiker's Guide To The Galaxy, QK12.04.002 (On Loan), issued
         * date=2020-08-15
         */
    }
}