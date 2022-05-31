package com.example.librarysystem;

public class Rules {

    static private Rules r;
    public String getRules="\t\t\t\tRules for Library\n" +
            "\t\t\t------------------------------\n" +
            "The Ultimate Rule: لو انت بتاخد سكشن مع م/ محمد فوزي يحق لك استعارة اي كتاب في اي وقت\n" +
            "\n" +
            "Normal Rules: \n" +
            "1- Keep books clean and dry \n" +
            "2- No food or drinks near the books\n" +
            "3- keep books away from pets and babies (3ala asas enna hnd5al pets ya kosmk)\n" +
            "4- Do not color or draw in books\n" +
            "5- If you want to borrow a book you must become a member first\n" +
            "6- when you enter the library you must salute the portrait of Mohamed Fawzy\n" +
            "7- Do not fuck with or in the library\n" +
            "---------------------------------------------------------------------------------------";

    private Rules()
    {

    }

    static Rules getInstance()
    {
        if(r == null)
        {
           return new Rules();
        }
        return r;
    }
}
