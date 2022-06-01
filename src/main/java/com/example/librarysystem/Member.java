package com.example.librarysystem;

public class Member implements iMember
{
    String FullName, ContactNumber, Address, NationalID, Gender;
    int Age;

    public Member(String fullName, String contactNumber,String address, String nationalID, String gender, int age)
    {
        FullName = fullName;
        ContactNumber = contactNumber;
        Address =  address;
        NationalID = nationalID;
        Gender = gender;
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNationalID() {
        return NationalID;
    }

    public void setNationalID(String nationalID) {
        NationalID = nationalID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
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
