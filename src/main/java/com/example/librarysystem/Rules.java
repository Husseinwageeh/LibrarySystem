package com.example.librarysystem;

import javafx.css.Rule;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Rules {
    @FXML
    static Label RulesLabel;
    private Rules (String Rules)
    {
        this.RulesLabel.setText(Rules);
    }

    static Rules singleton(String Rules)
    {
        if(Rules == null)
        {
            Rules rules = new Rules("\t\t\t\tRules for Library\n" +
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
                    "---------------------------------------------------------------------------------------");
        }
        return "Rule";
    }
}
