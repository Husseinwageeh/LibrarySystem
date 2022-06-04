package com.example.librarysystem;

public class Book implements iBook{
    String Title, Author, Language, Publisher;
    int Quantity , Book_ID;
    int numAvailable;
    int numBorrowed;
    // int pages must be added
    public Book( String title, String author, String language, String publisher, int quantity, int numAvailable,
                int numBorrowed) {
        Title = title;
        Author = author;
        Language = language;
        Publisher = publisher;
        Quantity = quantity;
        this.numAvailable = numAvailable;
        this.numBorrowed = numBorrowed;
    }
    public Book( int Id,String title, String author, String language, String publisher, int quantity, int numAvailable,
                 int numBorrowed) {
        this.Book_ID=Id;
        Title = title;
        Author = author;
        Language = language;
        Publisher = publisher;
        Quantity = quantity;
        this.numAvailable = numAvailable;
        this.numBorrowed = numBorrowed;
    }



    public int getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(int book_ID) {
        Book_ID = book_ID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getNumBorrowed() {
        return numBorrowed;
    }

    public void setNumBorrowed(int numBorrowed) {
        this.numBorrowed = numBorrowed;
    }

    @Override
    public String getTitle() {
        return Title;
    }

    @Override
    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public int getQuantity() {
        return Quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }



    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }


}
