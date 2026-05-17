package main;

import controller.RecruitController;
import model.RecruitDAO;
import view.RecruitView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class Main {
    public static void main(String[] args) {
        RecruitView view = new RecruitView();
        RecruitDAO dao = new RecruitDAO();
        new RecruitController(view, dao);
        
        view.setVisible(true);
    }
}
