package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.UserListView;

import javax.swing.*;
import java.util.ArrayList;

public class UserListController {
    public final UserListView view;
    public final UserTableModel model;

    public ExpertUserPersistenceController expertUserPersistenceController;
    public ArrayList<User> users;
    public UserListController(UserTableModel model, UserListView view){
        this.view = view;
        this.model = model;
        this.expertUserPersistenceController = new ExpertUserPersistenceController();
        this.users = (ArrayList<User>) this.expertUserPersistenceController.getExperts();
        this.model.setUsers(this.users);
        this.model.fireTableRowsInserted(0,this.users.size());
        this.view.form.getUserTable().setModel(this.model);
        UserController userController = new UserController();
        userController.setUsers(this.users);
        ExpertUserController expertUserController = new ExpertUserController(userController,this);
        StudentUserController studentUserController = new StudentUserController(userController,this);
        this.view.repaint();
        this.view.revalidate();

        this.view.form.getQuitButton().addActionListener(x -> {
            this.expertUserPersistenceController.setExperts(this.users);
            this.expertUserPersistenceController.writeExpertsFile();
            System.exit(1);
        });

        this.view.form.getAddExpertButton().addActionListener(x -> {
            this.view.setVisible(false);
            expertUserController.view.setVisible(true);
        });

        /**
         * this.view.form.getAddStudentButton().addActionListener(x -> {
         *             this.view.setVisible(false);
         *             studentUserController.view.setVisible(true);
         *         });
         *  This is not functional for this assignment
         */

        this.view.form.getShowDetailsButton().addActionListener(x -> {
           int index = this.view.form.getUserTable().getSelectedRow();
           if(index<0){
               JOptionPane.showMessageDialog(this.view, "No User Selected", "No User Selected", JOptionPane.INFORMATION_MESSAGE);
           }else{
               User user = userController.getUsers().get(index);
               if(user.getType() == Type.STUDENT){
                   StudentUser student = (StudentUser) user;
                   studentUserController.view.form.getNameValue().setText(student.getName());
                   studentUserController.view.form.getSchoolNameValue().setText(student.getSchoolName());
                   switch (student.getSchoolType()){
                       case HighSchool -> studentUserController.view.form.getSchoolTypeComboBox().setSelectedIndex(0);
                       case Undergraduate -> studentUserController.view.form.getSchoolTypeComboBox().setSelectedIndex(1);
                       case Graduate -> studentUserController.view.form.getSchoolTypeComboBox().setSelectedIndex(2);
                       case Master -> studentUserController.view.form.getSchoolTypeComboBox().setSelectedIndex(3);
                       default -> studentUserController.view.form.getSchoolTypeComboBox().setSelectedIndex(-1);
                   }
                   switch (student.getYear()){
                       case 1 -> studentUserController.view.form.getYearComboBox().setSelectedIndex(0);
                       case 2 -> studentUserController.view.form.getYearComboBox().setSelectedIndex(1);
                       case 3 -> studentUserController.view.form.getYearComboBox().setSelectedIndex(2);
                       case 4 -> studentUserController.view.form.getYearComboBox().setSelectedIndex(3);
                       default -> studentUserController.view.form.getYearComboBox().setSelectedIndex(-1);
                   }
                   this.view.setVisible(false);
                   studentUserController.view.setVisible(true);
               }else{
                   ExpertUser expert = (ExpertUser) user;
                   expertUserController.view.form.getNameValue().setText(expert.getName());
                   expertUserController.view.form.getCompanyValue().setText(expert.getCompany());
                   expertUserController.view.form.getYearsOfExperienceValue().setSelectedIndex(expert.getYearsOfExperience()-1);
                   expertUserController.view.form.getUserTextArea().setText(expert.toString() + "\nCurrent Index: "+(expertUserController.users.indexOf(expert)+1));
                   expertUserController.view.setVisible(true);
                   this.view.setVisible(false);
               }
               this.expertUserPersistenceController.setExperts(this.users);
               this.expertUserPersistenceController.writeExpertsFile();
           }

        });

    }
}
