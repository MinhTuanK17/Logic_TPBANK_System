/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.Library;
import common.LogicValidator;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author MINH TUAN
 */
public class TPBankAccess {

    LogicValidator lv = new LogicValidator();

    private static TPBankAccess instance = null;

    public static TPBankAccess Instance() {
        if (instance == null)
            synchronized (TPBankAccess.class) {
            if (instance == null) {
                instance = new TPBankAccess();
            }
        }
        return instance;
    }

    public void getLocalizedString(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("languageSources/language", locale);
        System.out.print(labels.getString(key));
    }

    public String generateCaptcha() {
        int length = 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public void runTPBank(Locale locale) {
        lv.getAccount(locale);
        lv.getPassword(locale);
        lv.getCaptcha(locale);
    }

}
