package com.example.librarysystem;

public class Member implements iMember{
    String FullName, ContactNumber;

    public Member(String fullName, String contactNumber) {
        FullName = fullName;
        ContactNumber = contactNumber;
    }

    @Override
    public String getFullName() {
        return FullName;
    }

    @Override
    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String getContactNumber() {
        return ContactNumber;
    }

    @Override
    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    @Override
    public void AddBook(iBook book) {

    }

    @Override
    public void DeleteBook(iBook book) {

    }


}
