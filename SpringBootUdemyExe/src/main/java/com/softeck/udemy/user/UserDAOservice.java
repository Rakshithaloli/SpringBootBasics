package com.softeck.udemy.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class UserDAOservice {

    private static List<UserDAO> userDAOS=new ArrayList<>();

    int userCount=3;
    static {
      userDAOS.add(new UserDAO(1,"loli",new Date()));
        userDAOS.add(new UserDAO(2,"Ammu",new Date()));
        userDAOS.add(new UserDAO(4,"Pramod",new Date()));
    }

   public UserDAO save(UserDAO dao) {
       if(dao.getId() == null) {

            dao.setId(++userCount);
        }
        userDAOS.add(dao);
        return dao;
    }

    public List<UserDAO> findAll()
    {
        return userDAOS;
    }

    public static UserDAO findOne(int id)
    {
        for(UserDAO userDAO: userDAOS)
        {
            if(userDAO.getId() == id)
            {
                return userDAO;
            }
        }
        return null;
    }


    public UserDAO deleteByID(int id) {
        Iterator<UserDAO> iterator=userDAOS.iterator();
        while (iterator.hasNext())
        {
            UserDAO userDAO=iterator.next();
            if(userDAO.getId()==id)
            {
                iterator.remove();
                return userDAO;
            }
        }
        return null;
    }
}
