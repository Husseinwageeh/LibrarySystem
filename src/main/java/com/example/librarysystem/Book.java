package com.example.librarysystem;

public class Book implements iBook{
    String Title, Author, Language, Publisher;
    int Quantity , Book_ID;
    int numAvailable;
    int numBorrowed;

    public Book(int book_ID, String title, String author, String language, String publisher, int quantity, int numAvailable,
                int numBorrowed) {
        Book_ID = book_ID;
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

    @Override
    public void addBorrower(iMember member) {

    }

    @Override
    public void deleteBorrower(iMember member) {

    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

}
