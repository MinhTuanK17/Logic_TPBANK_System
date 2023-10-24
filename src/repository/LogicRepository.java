/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.TPBankAccess;
import java.util.Locale;

/**
 *
 * @author MINH TUAN
 */
public class LogicRepository implements ILogicRepository{

    @Override
    public void Logic(Locale language) {
        TPBankAccess.Instance().runTPBank(language);
    }
    
}
