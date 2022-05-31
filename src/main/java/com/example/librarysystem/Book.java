package com.example.librarysystem;

public class Book implements iBook{
    String Title;
    int [] Quantity;
    int numAvailable;


    @Override
    public String getTitle() {
        return Title;
    }

    @Override
    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public int[] getQuantity() {
        return Quantity;
    }

    @Override
    public void setQuantity(int [] quantity) {
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
