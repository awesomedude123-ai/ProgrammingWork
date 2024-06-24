package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.ExpertUserView;
import edu.psu.ist.view.RecommendationListView;
import edu.psu.ist.view.SkillListView;
import edu.psu.ist.view.StudentUserView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserController implements SkillManager{
    private ArrayList<User> users;

    private UserFilter filter;
    private String filterText;

    public UserController() {
        this.users=new ArrayList<User>();
        this.filter=null;
        this.filterText=null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public UserFilter getFilter() {
        return filter;
    }

    public void setFilter(UserFilter filter) {
        this.filter = filter;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }
    public String toString() {
        //Filter and FilterText are not needed in the ToString method so I did not add them.
        String answer = "";
        for(User user: users) {
            answer=answer+user.toString()+"-".repeat(20);
        }
        return answer;
    }

    public ArrayList<User> filter(UserFilter filter, String filterText) {
        ArrayList<User> li = new ArrayList<>();
        switch(filter) {
            case ID -> {
                int value = Integer.parseInt(filterText);
                for(User user: users) {
                    if(user.getId() == value){
                        li.add(user);
                    }
                }
            }//end case ID
            case NAME -> {
                for(User user: users) {
                    if(user.getName().equals(filterText)){
                        li.add(user);
                    }//end if statement
                }//end for loop
            }//end case NAME
            case YEAR -> {
                int value = Integer.parseInt(filterText);
                for(User user:users){
                    if(user instanceof StudentUser){
                        StudentUser user1 = (StudentUser) user;
                        if(user1.getYear() == value){
                            li.add(user);
                        }
                    }//end if statement
                }//end for loop
            }//end case YEAR
            case COMPANY -> {
                for(User user:users){
                    if(user instanceof ExpertUser){
                        ExpertUser user1 = (ExpertUser) user;
                        if(user1.getCompany().equals(filterText)){
                            li.add(user);
                        }
                    }//end if statement
                }//end for loop
            }//end case COMPANY
            case SCHOOLTYPE -> {
                for(User user:users) {
                    if(user instanceof StudentUser) {
                        StudentUser user1 = (StudentUser) user;
                        switch(filterText){
                            case "HIGHSCHOOL"-> {
                                if(user1.getSchoolType().equals(SchoolType.HighSchool)){
                                    li.add(user);
                                }//end if statement
                            }//end case HIGHSCHOOL
                            case "UNDERGRADUATE" -> {
                                if(user1.getSchoolType().equals(SchoolType.Undergraduate)) {
                                    li.add(user);
                                }//end if statement
                            }//end case UNDERGRADUATE
                            case "GRADUATE" -> {
                                if(user1.getSchoolType().equals(SchoolType.Graduate)) {
                                    li.add(user);
                                }//end if statement
                            }//end case GRADUATE
                            case "MASTER" -> {
                                if(user1.getSchoolType().equals(SchoolType.Master)){
                                    li.add(user);
                                }//end if statement
                            }//end case MASTER
                        }
                    }
                }
            }//end case SCHOOLTYPE
            case SCHOOLNAME -> {
                for(User user: users){
                    if(user instanceof StudentUser){
                        StudentUser user1 = (StudentUser) user;
                        if(user1.getSchoolName().equals(filterText)){
                            li.add(user);
                        }//end if statement
                    }//end if statement
                }//end for loop
            }//end case SCHOOLNAME
            case TYPE -> {
                for(User user: users){
                    if(filterText.equals("STUDENT")){
                        if(user.getType().equals(Type.STUDENT)){
                            li.add(user);
                        }//end if statement
                    }else if(filterText.equals("EXPERT")) {
                        if(user.getType().equals(Type.EXPERT)){
                            li.add(user);
                        }//edn if statement
                    }//end if statement
                }//end for loop
            }//end case TYPE
        }//end switch/case
        return li;
    }//end filter method


    public void addExpertUser(ExpertUser user) {
        users.add(user);
    }
    public void addStudentUser(StudentUser user){
        users.add(user);
    }

    @Override
    public boolean remove(String name) { //Modified SkillManager Interface Method
        for(User user: users) {
            if(user.getName().equals(name)){
                users.remove(user);
                break;
            }
        }//end for loop
        return false;
    }

    @Override
    public void update(int id,String param, String newValue) { //Modified SkillManager Interface Method
        if(users.get(id-1).getType() == Type.STUDENT){
            StudentUser user = (StudentUser) users.get(id-1);
            switch (param) {
                case "Name" -> user.setName(newValue);
                case "Year" -> user.setYear(Integer.parseInt(newValue));
                case "School Type" -> {
                    ;
                    SchoolType school = switch (newValue) {
                        case "High School":
                            yield SchoolType.HighSchool;
                        case "Graduate":
                            yield SchoolType.Graduate;
                        case "Master":
                            yield SchoolType.Master;
                        default:
                            yield SchoolType.Undergraduate;
                    };
                    user.setSchoolType(school);
                }
                case "School Name" -> user.setSchoolName(newValue);
            }//end switch case statement
        }else{
            ExpertUser user = (ExpertUser) users.get(id-1);
            switch (param) {
                case "Name" -> user.setName(newValue);
                case "Company" -> user.setCompany(newValue);
                case "Years of Experience" -> user.setYearsOfExperience(Integer.parseInt(newValue));
            }
        }
    }

    @Override
    public String view() { //Modified SkillManager Interface Method
        String value = "";
        for(User user: users) {
            value = value+user.toString()+"\n";
        }
        return value;
    }
}


class ExpertUserController{
    public final ExpertUserView view;

    private UserController userController;
    private ArrayList<ExpertUser> users;

    public final SkillTableController skillTableController;

    private UserListController userListController;

    private ExpertUser currentUser=null;

    private static int index = 0;

    public ExpertUserController(UserController userController, UserListController userListController){
        this.view = new ExpertUserView();
        this.users = new ArrayList<>();
        this.userController = userController;
        this.skillTableController = new SkillTableController(new SkillTableModel(new ArrayList<>()), new SkillListView(),this);
        this.userListController = userListController;

        this.view.form.getUserTextArea().setWrapStyleWord(true);
        this.view.form.getUserTextArea().setLineWrap(true);
        this.view.form.getInstructionsTextArea().setWrapStyleWord(true);
        this.view.form.getInstructionsTextArea().setLineWrap(true);

        this.view.form.getInstructionsTextArea().setText("Instructions\n" +
                "This is a simple view being used to create, modify, delete, view the expert users. \n" +
                "While the real implementation may be different slightly,\n" +
                "this is the general idea of how it works.\n\n" +
                "To use the add button, you need to enter in values for each criterion. \n" +
                "If the user is not present, then the skill will be added.\n" +
                "If it is, the new user will not be added.\n\n" +
                "To use the delete button, simply enter the name of the user you wish to delete. \n" +
                "If it is present, then it will delete it from the list.\n\n" +
                "To use the modify button, simply enter the name of the user you wish to modify \n" +
                "and enter in one of the criteria. \n" +
                "If user is present, then change will be made\n" +
                "i.e. Name Sri Company Microsoft \n\n" +
                "Next button will simply move forward in the list and loop around the list if it is at the end.\n\n" +
                "Previous button will simply move backward in the last and loop around the list if it at the beginning.\n\n" +
                "The text area below will display your actions.\n" +
                "i.e. Adding a new user will display the new user, deleting the user will display the last user in the list, \n" +
                "updating will display the modified user, etc");

        this.view.form.getUserTextArea().setText("No Expert Users in the List");

        for(int i = 0; i <= 100; i++){
            this.view.form.getYearsOfExperienceValue().addItem(i);
        }
        this.view.form.getYearsOfExperienceValue().setSelectedIndex(-1);

        this.view.form.getAddButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"Missing Name Value", "No Name Value", JOptionPane.ERROR_MESSAGE);
            }else{
                boolean isThere = false;
                for(ExpertUser user : this.users){
                    if(user.getName().equals(name)){
                        JOptionPane.showMessageDialog(this.view, "Expert User with Name already exists", "Name already exists", JOptionPane.INFORMATION_MESSAGE);
                        isThere = true;
                        break;
                    }
                }
                if(!isThere){
                    String company = this.view.form.getCompanyValue().getText();
                    if(company.isEmpty()){
                        JOptionPane.showMessageDialog(this.view,"Missing Company Value","No Company Value", JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(this.view.form.getYearsOfExperienceValue().getSelectedItem()==null){
                            JOptionPane.showMessageDialog(this.view,"Missing Years of Experience Value","No Years of Experience Value", JOptionPane.ERROR_MESSAGE);
                        }else{
                            int yearsOfExperience = (int) this.view.form.getYearsOfExperienceValue().getSelectedItem();
                            ExpertUser expertUser = new ExpertUser(name,company,yearsOfExperience);
                            this.users.add(expertUser);this.userController.addExpertUser(expertUser);
                            index+=1;
                            this.userListController.model.setUsers(this.userController.getUsers());
                            this.userListController.model.fireTableRowsInserted(this.userController.getUsers().size()-1,this.userController.getUsers().size());
                            this.view.form.getNameValue().setText("");
                            this.view.form.getCompanyValue().setText("");
                            this.view.form.getYearsOfExperienceValue().setSelectedIndex(-1);
                            this.view.form.getUserTextArea().setText(this.users.get(index-1).toString() + "\nCurrent Index: "+index);
                            currentUser = expertUser;
                        }//end if else statement
                    }//end if else statement
                }
            }//end if else statement
        });//end add button

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });//end quit button

        this.view.form.getNextButton().addActionListener(x -> {
            if(users.isEmpty()) {
                JOptionPane.showMessageDialog(this.view, "No Expert Users Found", "No Expert Users", JOptionPane.ERROR_MESSAGE);
                currentUser = null;
            }else{
                index++;
                if(index>this.users.size()){
                    index=1;
                }
                this.view.form.getUserTextArea().setText(this.users.get(index-1).toString() + "\nCurrent Index: "+index);
                currentUser = this.users.get(index-1);
            }
        });//end next button
        this.view.form.getPreviousButton().addActionListener(x -> {
            if(users.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"No Expert Users Found", "No Expert Users", JOptionPane.ERROR_MESSAGE);
                currentUser = null;
            }else{
                index--;
                if(index<=0){
                    index=this.users.size();
                }
                this.view.form.getUserTextArea().setText(this.users.get(index-1).toString() + "\nCurrent Index: "+index);
                currentUser = this.users.get(index-1);
            }//end if else statement
        });//end previous button

        this.view.form.getDeleteButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(this.view, "No Name Value Found","No Name Value", JOptionPane.ERROR_MESSAGE);
            }else{
                boolean isThere = false;
                int index1=0;
                for(ExpertUser user : this.users){
                    if(user.getName().equals(name)){
                        isThere=true;
                        this.users.remove(index1);
                        this.userController.remove(name);
                        this.userListController.model.setUsers(this.userController.getUsers());
                        this.userListController.model.fireTableRowsDeleted(index1,index1++);
                        break;
                    }
                    index1++;
                }
                if(isThere==false){
                    JOptionPane.showMessageDialog(this.view,"No User with Name Found", "No Found User", JOptionPane.ERROR_MESSAGE);
                }//end if else statement
                this.view.form.getNameValue().setText("");
                if(this.userController.getUsers().size()==0){
                    this.view.form.getUserTextArea().setText("No Expert Users in the List");
                    currentUser = null;
                }else{
                    this.view.form.getUserTextArea().setText(this.userController.getUsers().get(this.userController.getUsers().size()-1).toString());
                    currentUser = (ExpertUser) this.userController.getUsers().get(this.userController.getUsers().size()-1);
                }
            }
        });//end delete button

        this.view.form.getUpdateButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view, " No Name Value Found", "No Name Value",JOptionPane.ERROR_MESSAGE);
            }else{
                ExpertUser mainUser = null;
                int index1 = 0;
                for(ExpertUser user: this.users){
                    if(user.getName().equals(name)){
                        mainUser = user;break;
                    }
                    index1++;
                }//end for loop
                if(mainUser != null){
                    String company = this.view.form.getCompanyValue().getText();
                    if(!company.isEmpty()){
                        mainUser.setCompany(company);
                    }
                    int yearsOfExperience = (int) this.view.form.getYearsOfExperienceValue().getSelectedItem();
                    if(yearsOfExperience != -1){
                        mainUser.setYearsOfExperience(yearsOfExperience);
                    }//end if statement
                    this.users.set(index1,mainUser);

                    this.view.form.getNameValue().setText("");
                    this.view.form.getCompanyValue().setText("");
                    this.view.form.getYearsOfExperienceValue().setSelectedIndex(-1);
                    this.userListController.model.setUsers(this.userController.getUsers());
                    this.userListController.model.fireTableRowsUpdated(index1,index1++);
                    this.view.form.getUserTextArea().setText(mainUser.toString() + "\nCurrent Index: "+index1);
                    index=index1;
                    currentUser = mainUser;
                }//end if else statement
            }//end if else statement
        });//end update button

        this.view.form.getShowSkillListButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"No Name Value Entered.", "No Name Value",JOptionPane.INFORMATION_MESSAGE);
            }else{
                ExpertUser expert = null;
                boolean isThere = false;
                for(ExpertUser user : this.users){
                    if(user.getName().equals(name)){
                        expert = user;
                        isThere = true;break;
                    }
                }//end for loop
                if(isThere){
                    this.currentUser=expert;
                    this.skillTableController.setCurrentUserList(expert.getSkills());
                    this.skillTableController.model.setSkills(this.skillTableController.getCurrentUserList());
                    this.skillTableController.model.fireTableRowsUpdated(0,this.skillTableController.getCurrentUserList().size());
                    this.skillTableController.view.form.getTableValues().setModel(this.skillTableController.model);
                    this.view.setVisible(false);
                    this.skillTableController.view.setVisible(true);
                }
            }//end elsestatement

        });

        this.view.form.getShowUserListButton().addActionListener(x -> {
            this.view.setVisible(false);
            this.userListController.view.form.getUserTable().setModel(this.userListController.model);
            userListController.view.setVisible(true);
        });
    }//end constructor

    public ExpertUser getCurrentUser(){
        return this.currentUser;
    }

    public void setCurrentUser(ExpertUser currentUser) {
        int ind = this.users.indexOf(this.currentUser);
        this.users.set(ind, currentUser);
        this.currentUser = currentUser;
        index = ind+1;
        this.view.form.getUserTextArea().setText(currentUser.toString() + "\nCurrent Index: "+index);
    }
}//end class



class StudentUserController{
    public final StudentUserView view;

    private UserController userController;

    private ArrayList<StudentUser> students;

    public final RecommendationTableController recommendationTableController;

    private UserListController userListController;

    private StudentUser currentUser = null;

    private static int index = 0;

    public StudentUserController(UserController userController, UserListController userListController){
        this.view = new StudentUserView();
        this.userController = userController;
        this.userListController = userListController;
        students = new ArrayList<>();

        this.recommendationTableController = new RecommendationTableController(new RecommendationListView(), new RecommendationTableModel(),this);

        this.recommendationTableController.view.validate();this.recommendationTableController.view.repaint();

        this.view.form.getUserTextArea().setLineWrap(true);
        this.view.form.getUserTextArea().setWrapStyleWord(true);
        this.view.form.getInstructionsTextArea().setLineWrap(true);
        this.view.form.getInstructionsTextArea().setWrapStyleWord(true);

        this.view.form.getInstructionsTextArea().setText("Instructions\n" +
                "This is a simple view being used to create, modify, delete, view the expert users. \n" +
                "While the real implementation may be different slightly,\n" +
                "this is the general idea of how it works.\n\n" +
                "To use the add button, you need to enter in values for each criterion. \n" +
                "If the user is not present, then the skill will be added.\n" +
                "If it is, the new user will not be added.\n\n" +
                "To use the delete button, simply enter the name of the user you wish to delete. \n" +
                "If it is present, then it will delete it from the list.\n\n" +
                "To use the modify button, simply enter the name of the user you wish to modify \n" +
                "and enter in one of the criteria. \n" +
                "If user is present, then change will be made\n" +
                "i.e. Name Sri School Name PSU \n\n" +
                "Next button will simply move forward in the list and loop around the list if it is at the end.\n\n" +
                "Previous button will simply move backward in the last and loop around the list if it at the beginning.\n\n" +
                "The text area below will display your actions.\n" +
                "i.e. Adding a new user will display the new user, deleting the user will display the last user in the list, \n" +
                "updating will display the modified user, etc");

        this.view.form.getUserTextArea().setText("No Student User in the list.");

        for(Object o : SchoolType.values()){
            this.view.form.getSchoolTypeComboBox().addItem(o);
        }

        for(int i=1;i<=12;i++) {
            this.view.form.getYearComboBox().addItem(i);
        }
        this.view.form.getSchoolTypeComboBox().setSelectedIndex(-1);
        this.view.form.getYearComboBox().setSelectedIndex(-1);


        this.view.form.getAddButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view, "No Name Value Entered", "No Name Value", JOptionPane.INFORMATION_MESSAGE);
            }else{
                boolean isThere = false;
                for(StudentUser user : this.students){
                    if(user.getName().equals(name)){
                        JOptionPane.showMessageDialog(this.view,"Student User with Name already exists", "User Already Exists", JOptionPane.INFORMATION_MESSAGE);
                        isThere = true; break;
                    }
                }
                if(!isThere){
                    String schoolName = this.view.form.getSchoolNameValue().getText();
                    if(schoolName.isEmpty()){
                        JOptionPane.showMessageDialog(this.view,"No School Name Value Entered", "No School Name", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        SchoolType schoolType = (SchoolType) this.view.form.getSchoolTypeComboBox().getSelectedItem();
                        if(schoolType == null){
                            JOptionPane.showMessageDialog(this.view, "No School Type Value Selected", "No School Type", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            int year = (int) this.view.form.getYearComboBox().getSelectedItem();
                            if(year<0){
                                JOptionPane.showMessageDialog(this.view,"No Year Value Selected","No Year Value", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                StudentUser studentUser = new StudentUser(name,year,schoolType,schoolName);
                                this.students.add(studentUser);
                                this.userController.addStudentUser(studentUser);
                                index++;
                                this.userListController.model.setUsers(this.userController.getUsers());
                                this.userListController.model.fireTableRowsInserted(this.userController.getUsers().size()-1, this.userController.getUsers().size());
                                this.view.form.getUserTextArea().setText(studentUser.toString() + "\nCurrent Index: " + index);
                                this.view.form.getNameValue().setText("");
                                this.view.form.getYearComboBox().setSelectedIndex(-1);
                                this.view.form.getSchoolTypeComboBox().setSelectedIndex(-1);
                                this.view.form.getSchoolNameValue().setText("");
                            }//end if else
                        }//end if else
                    }//end if else
                }
            }//end if else
        });

        this.view.form.getDeleteButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view, "No Name Value Entered", "No Name Value", JOptionPane.INFORMATION_MESSAGE);
            }else{
                boolean isThere = false;
                int index1=0;
                for(User user : this.userController.getUsers()) {
                    if(user.getName().equals(name)){
                        ArrayList<User> users = userController.getUsers();
                        users.remove(index1);
                        this.userController.setUsers(users);
                        this.userListController.model.setUsers(users);
                        this.userListController.model.fireTableRowsDeleted(index1,index1+1);
                        isThere = true;
                        break;
                    }
                    index1++;
                }//end for loop
                if(!isThere){
                    JOptionPane.showMessageDialog(this.view, "No User with Name Found", "No User Found",JOptionPane.INFORMATION_MESSAGE);
                }
                this.view.form.getNameValue().setText("");
                this.view.form.getYearComboBox().setSelectedIndex(-1);
                this.view.form.getSchoolTypeComboBox().setSelectedIndex(-1);
                this.view.form.getSchoolNameValue().setText("");
                if(this.students.isEmpty()) {
                    this.view.form.getUserTextArea().setText("No Student Users in List.");
                    index=0;
                }else{
                    this.view.form.getUserTextArea().setText(this.students.get(this.students.size()-1).toString() + "\nCurrent Index: "+this.students.size());
                    index=this.students.size();
                }
            }//end if else statement
        });

        this.view.form.getUpdateButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"No Name Value Entered", "No Name Value",JOptionPane.INFORMATION_MESSAGE);
            }else{
                boolean isThere = false;
                int index1 = 0;
                for(StudentUser user : this.students){
                    if(user.getName().equals(name)){
                        isThere = true;break;
                    }//end if else
                    index1++;
                }//end for loop
                if(!isThere){
                    JOptionPane.showMessageDialog(this.view,"No User Found with Name", "No User Found", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    StudentUser user = this.students.get(index1);
                    int userIndex = 0;
                    for(User user1 : this.userController.getUsers()){
                        if(user1==user) {
                            break;
                        }
                        userIndex++;
                    }
                    int year = -1;
                    if(this.view.form.getYearComboBox().getSelectedItem()!=null) {
                        year = (int) this.view.form.getYearComboBox().getSelectedItem();
                    }
                    if(year>=1){
                        user.setYear(year);
                    }//end if statement

                    SchoolType schoolType = (SchoolType) this.view.form.getSchoolTypeComboBox().getSelectedItem();
                    if(schoolType != null) {
                        user.setSchoolType(schoolType);
                    }

                    String schoolName = this.view.form.getSchoolNameValue().getText();
                    if(!schoolName.isEmpty()) {
                        user.setSchoolName(schoolName);
                    }
                    ArrayList<User> list = new ArrayList<>();
                    List<User> list1 = this.userController.getUsers();
                    list1.set(userIndex,user);
                    for(User y : list1) {
                        list.add(y);
                    }

                    this.students.set(index1, user); this.userController.setUsers(list);
                    this.userListController.model.setUsers(this.userController.getUsers());
                    this.userListController.model.fireTableRowsUpdated(userIndex,userIndex+1);
                    this.userListController.view.form.getUserTable().setModel(this.userListController.model);
                    index=index1+1;
                    this.view.form.getUserTextArea().setText(this.students.get(index1).toString() + "\nCurrent Index: " + index);
                }//end if else statement
            }//end if else
        });

        this.view.form.getNextButton().addActionListener(x -> {
            if(this.students.size() == 0) {
                JOptionPane.showMessageDialog(this.view, "No Student Users in List", "No Users", JOptionPane.INFORMATION_MESSAGE);
            }else{
                index++;
                if(index > this.students.size()) {
                    index=1;
                }
                this.view.form.getUserTextArea().setText(this.students.get(index-1) + "\nCurrent Index: "+index);
            }
        });

        this.view.form.getPreviousButton().addActionListener(x -> {
            if(this.students.isEmpty()) {
                JOptionPane.showMessageDialog(this.view, "No Student Users in List", "No Users", JOptionPane.INFORMATION_MESSAGE);
            }else{
                index--;
                if(index<=0){
                    index = this.students.size();
                }
                this.view.form.getUserTextArea().setText(this.students.get(index-1) + "\nCurrent Index: "+index);
            }//end if else statement
        });

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });

        this.view.form.getShowRecommendationListButton().addActionListener(x -> {
            if(this.view.form.getNameValue().getText().isEmpty()) {
                JOptionPane.showMessageDialog(this.view,"No Name Value Entered", "No Name Value", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String name = this.view.form.getNameValue().getText();
                for(int i=0;i<this.students.size();i++){
                    if(this.students.get(i).getName().equals(name)){
                        this.currentUser=this.students.get(i);
                        index=i+1;
                    }
                }//end for loop
                if(this.currentUser==null){
                    JOptionPane.showMessageDialog(this.view,"No Student with Name Found", "No Student Found", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    this.recommendationTableController.setRecommendations(this.currentUser.getRecommendations());
                    this.recommendationTableController.model.setRecommendations(this.currentUser.getRecommendations());
                    this.recommendationTableController.model.fireTableRowsUpdated(0,this.currentUser.getRecommendations().size());
                    this.recommendationTableController.view.form.getRecommendationListTable().setModel(this.recommendationTableController.model);
                    this.view.setVisible(false);
                    this.recommendationTableController.view.setVisible(true);
                }
            }

        });

        this.view.form.getShowUserListButton().addActionListener(x -> {
            this.view.setVisible(false);
            this.userListController.view.form.getUserTable().setModel(this.userListController.model);
            this.userListController.view.setVisible(true);
        });
    }//end controller


    public ArrayList<StudentUser> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentUser> students) {
        this.students = students;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        StudentUserController.index = index;
    }

    public StudentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(StudentUser currentUser) {
        this.currentUser = currentUser;
    }
}//end StudentUser Class
