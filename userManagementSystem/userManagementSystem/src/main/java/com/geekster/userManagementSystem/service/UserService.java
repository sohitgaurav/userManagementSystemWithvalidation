package com.geekster.userManagementSystem.service;


import com.geekster.userManagementSystem.model.User;
import com.geekster.userManagementSystem.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

public List<User> getAllUser(){
  return   userDao.getAllUserFromDao();

    }
    public String addMyUser(User user){
        boolean insertionStatus= userDao.save(user);
        if(insertionStatus){
            return "Todo Add Successfully....";     // in our case always true
        }
        else{
            return "failed....Todo not Possible";    // in case of Database error ...will see later
        }

    }
    public User getUserBasedOnId(String userId){
      List<User> listRightNow= userDao.getAllUserFromDao();
      for(User user : listRightNow)
          if(user.getUserId().equals(userId)){
              return user;
          }
      return null;

    }
         public String removeUserById(String id){
        boolean deleteResponse=false;
        String status;
        if(id != null) {
            List<User> userListRightNow = userDao.getAllUserFromDao();

            for (User user : userListRightNow) {
                if (user.getUserId().equals(id)) {
                    deleteResponse= userDao.remove(user);
                    if(deleteResponse){
                        status="user with id"+id+" was deleted...!!!";
                    }
                    else{
                        status="userwith id"+id+" was  not deleted...!!!";
                    }
                    return status;
                }


            }
            return "user with id"+id+" does not exist...!!!";
        }
        else{
            return "user id .....cant accept null id ...!";
        }
    }

    public String updateUserNameById(String id , String userName){
        boolean updateStatus= userDao.update(id,userName);

        if(updateStatus){
            return "user with id "+id+" was updated";
        }
        else{
            return "user with id "+id+" was not updated";
        }

    }

}
