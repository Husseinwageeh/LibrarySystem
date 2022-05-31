package com.example.librarysystem;

public interface iMember {
    String getFullName();
    void setFullName(String name);
    String getContactNumber();
    void setContactNumber(String contactNumber);
    void AddBook(iBook book);
    void DeleteBook(iBook book);


}
