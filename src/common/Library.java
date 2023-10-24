/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import dataAccess.TPBankAccess;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author MINH TUAN
 */
public class Library {

    public String getString(Locale locale) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                TPBankAccess.Instance().getLocalizedString(locale, "checkEmptyString");
            } else {
                return result;
            }
        }
    }

    public int getInt(Locale locale, int min, int max) {
        int number = 0;

        while (true) {
            System.out.print("Enter selection: ");
            try {
                String input = getString(locale);
                number = Integer.parseInt(input);

                if (number >= min && number <= max) {
                    return number;
                } else {
                    TPBankAccess.Instance().getLocalizedString(locale, "checkNumberRange");
                }
            } catch (NumberFormatException e) {
                TPBankAccess.Instance().getLocalizedString(locale, "checkInputAgain");
            }
        }
    }
}
