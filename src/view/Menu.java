/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author MINH TUAN
 */
import common.Library;
import java.util.ArrayList;
import java.util.Locale;

public abstract class Menu<T> {

    protected String title;
    protected Locale locale;
    protected ArrayList<T> menuChoice;
    private boolean isStop;
    Library l = new Library();

    //------------------------------------------------------
    public Menu(String tT, String[] mC) {
        this.locale = Locale.getDefault();
        title = tT;
        menuChoice = new ArrayList<>();
        for (String s : mC) {
            menuChoice.add((T) s);
        }
    }

    //------------------------------------------------------
    public Menu() {
        this.isStop = false;
    }

    //------------------------------------------------------
    public void displayMenu() {
        System.out.println(title);
        System.out.println("-------------------------------");
        for (int i = 0; i < menuChoice.size(); i++) {
            System.out.println((i + 1) + "." + menuChoice.get(i));
        }
        System.out.println("-------------------------------");
    }

    //------------------------------------------------------
    public int getSelected() {
        displayMenu();
        return l.getInt(locale, 1, this.menuChoice.size());
    }

    //------------------------------------------------------
    public abstract void execute(int n) throws Exception;

    //------------------------------------------------------
    protected void stop() {
        this.isStop = true;
    }
    //------------------------------------------------------

    public void run() throws Exception {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > menuChoice.size()) {
                break;

            }
        }
    }
}
