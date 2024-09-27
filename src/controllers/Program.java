package controllers;

import dto.I_Program;
import util.Util;
import java.util.ArrayList;

public class Program extends ArrayList<String> implements I_Program {

    public Program() {
    }

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        return Util.getInt("Please input your choice: ");
    }

    @Override
    public void showMenu() {
        for(String s: this){
            System.out.println(s);
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        return Util.confirmYesNo(welcome);
    }

}