/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Locale;
import repository.LogicRepository;
import view.Menu;

/**
 *
 * @author MINH TUAN
 */
public class LogicManagement extends Menu<String> {

    static String[] menu = {"Vietnamese", "English", "Exit"};
    LogicRepository lr = new LogicRepository();
    Locale localeVi = new Locale("vi");
    Locale localeEn = new Locale("en");

    public LogicManagement() {
        super("-------- Login Program --------", menu);
    }

    @Override
    public void execute(int n) throws Exception {
        switch (n) {
            case 1:
                lr.Logic(localeVi);
                break;
            case 2:
                lr.Logic(localeEn);
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                this.stop();
        }
    }

}
