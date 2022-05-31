package com.example.librarysystem;

public interface iBook {
    String getTitle();
    void setTitle(String Title);
    int[] getQuantity();
    void setQuantity(int [] number);
    void addBorrower(iMember member);
    void deleteBorrower(iMember member);

}
