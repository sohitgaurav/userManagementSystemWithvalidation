package com.geekster.userManagementSystem.repository;


import com.geekster.userManagementSystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private List<User> userList;

    public UserDao(){
        userList= new ArrayList<>();
        userList.add(new User("0","Dummy name","Dummy@userid","India","1001" ));
    }
    public List<User>  getAllUserFromDao(){
        return userList;
    }
    public boolean save(User user){
        userList.add(user);
        return true;

    }
    public boolean remove(User user){
        userList.remove(user);
        return true;
    }
    public boolean update( String id, String userName){
        boolean updateStatus=false;
        for(User user: userList){

            if (user.getUserId().equals(id)) {

                //todo remove
                remove(user);
                //change this user now

                user.setUsername(userName);
                // add this new todo
                save(user);

                return true;
            }


        }
        return false;
    }


}
