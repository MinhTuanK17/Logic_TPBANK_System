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
public class LogicValidator {

    protected Scanner sc;
    Library l;

    public LogicValidator() {
        sc = new Scanner(System.in);
        l = new Library();
    }

    public String getAccount(Locale locale) {
        String account = "";
        boolean flag = true;

        while (flag) {
            TPBankAccess.Instance().getLocalizedString(locale, "inputAccount");
            account = l.getString(locale);
            if (account.matches("\\d{10}")) {
                flag = false;
            } else {
                TPBankAccess.Instance().getLocalizedString(locale, "wrongAccount");
            }
        }
        return account;
    }

    public String getPassword(Locale locale) {
        String password = "";
        boolean flag = true;

        while (flag) {
            TPBankAccess.Instance().getLocalizedString(locale, "inputPassword");
            password = l.getString(locale);
            if (password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,31}$")) {
                flag = false;
            } else {
                TPBankAccess.Instance().getLocalizedString(locale, "wrongPassword");
            }
        }
        return password;
    }

    public String getCaptcha(Locale locale) {
        boolean flag = true;
        String captchaInput = "";
        String captchaGenerated = "";

        while (flag) {
            captchaGenerated = TPBankAccess.Instance().generateCaptcha();
            System.out.println(captchaGenerated);

            TPBankAccess.Instance().getLocalizedString(locale, "inputCaptcha");
            captchaInput = l.getString(locale);

            if (captchaGenerated.equals(captchaInput)) {
                TPBankAccess.Instance().getLocalizedString(locale, "loginSuccess");
                flag = false;
            } else {
                TPBankAccess.Instance().getLocalizedString(locale, "wrongCaptcha");
            }
        }

        return captchaInput;
    }

}
