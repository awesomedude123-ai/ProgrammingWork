package edu.psu.ist.controller;

import edu.psu.ist.model.ExpertUser;
import edu.psu.ist.model.SchoolType;
import edu.psu.ist.model.StudentUser;
import edu.psu.ist.model.User;

import java.util.HashMap;

//Hold All Users/Skills
public class HashMapController {
    private HashMap<Integer, User> userList;

    public HashMapController(){
        userList = new HashMap<Integer, User>();

        User user = new ExpertUser("Sri","Microsoft",10);
        User user1 = new StudentUser("Ryan",1, SchoolType.Graduate,"Penn State");


        System.out.println("-------------------------Adding Users------------------------");
        addUser(user);
        addUser(user1);
        System.out.println("-------------------------Getting Users-------------------------");
        System.out.println(getUser(1));
        System.out.println();
        System.out.println(getUser(2));
        System.out.println("-------------------------Updating User-------------------------");
        user.setName("Sri Mukk");
        user1.setName("Ryan We");
        System.out.println("-------------------------Getting User-------------------------");
        System.out.println(getUser(1));
        System.out.println();
        System.out.println(getUser(2));
        System.out.println("-------------------------Removing User-------------------------");
        removeUser(user);
        removeUser(user1);
        System.out.println("-------------------------Getting User-------------------------");
        System.out.println(getUser(1));
        System.out.println();
        System.out.println(getUser(2));
    }

    public void addUser(User user){
        if(userList.isEmpty()){
            userList.put(1,user);
        }else{
            boolean isThere = false;
            for(int i=1;i<=userList.size();i++){
                if(userList.get(i).getName().equals(user.getName())){
                    isThere=true;
                    break;
                }
            }
            if(!isThere){
                this.userList.put(userList.size()+1,user);
            }
        }
    }

    public void removeUser(User user){
        for(int i=1;i<=userList.size();i++){
            if(userList.get(i).getName().equals(user.getName())){
                userList.remove(i);
                for(int j=i;j<=userList.size();j++){
                    User user1 = this.userList.get(j+1);
                    this.userList.remove(j+1);
                    if(this.userList.size()!=1){
                        this.userList.put(j, user1);
                    }
                }
                break;
            }
        }
    }

    public void updateUser(User user, User newUser){
        for(int i=1;i<=this.userList.size();i++){
            if(this.userList.get(i).getName().equals(user.getName())){
                this.userList.replace(i,user,newUser);
                break;
            }//end if statement
        }//end for loop
    }

    public User getUser(int index){
        return this.userList.get(index);
    }
}
