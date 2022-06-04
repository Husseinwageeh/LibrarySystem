package com.example.librarysystem;

public class Member extends iMember
{
    String FullName, ContactNumber, Address, NationalID, Gender, Borrowedbook;
    int Age, MemberID;
    String Date;

    public Member(String fullName, String contactNumber, String address, String nationalID, int age, String gender,
                  int memberid, String borrowedbook, String date)
    {
        super();
        FullName = fullName;
        ContactNumber = contactNumber;
        Address =  address;
        NationalID = nationalID;
        Gender = gender;
        Age = age;
        MemberID = memberid;
        Borrowedbook = borrowedbook;
        Date = date;
    }
    public Member(String fullName, String contactNumber, String address, String nationalID, int age, String gender)
    {
        super();
        FullName = fullName;
        ContactNumber = contactNumber;
        Address =  address;
        NationalID = nationalID;
        Gender = gender;
        Age = age;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBorrowedbook() {
        return Borrowedbook;
    }

    public void setBorrowedbook(String borrowedbook) {
        Borrowedbook = borrowedbook;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) {
        MemberID = memberID;
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
    public void knowMinor(String Name, int age)
    {
        if(age<21)
            System.out.println(Name + "is minor!");
        else
            System.out.println(Name+ "is Major ehehehheehe!");
    }

    public void knowMinor(int age)
    {
        if(age<21)
            System.out.println(this.FullName + "is minor!");
        else
            System.out.println(this.FullName+"is Major ehehehheehe!");
    }



}
