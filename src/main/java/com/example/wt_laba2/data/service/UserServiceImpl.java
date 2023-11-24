package com.example.wt_laba2.data.service;

import com.example.wt_laba2.data.local.model.User;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.UserDao;
import com.example.wt_laba2.domain.service.UserService;
import com.example.wt_laba2.util.DAOFactory;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String login, String password) throws ServiceException {
        User user;
        UserDao userDao;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (login == null || password == null) {
                throw new ServiceException("Incorrect password or login");
            }
            user = userDao.signIn(login, password);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return user;
    }

    @Override
    public int registration(User user) throws ServiceException {
        UserDao userDao;
        int id;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (user.getPassword() == null || user.getLogin() == null) {
                throw new ServiceException("Incorrect password or login");
            }
            id = userDao.registration(user);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return id;
    }

    @Override
    public Boolean SetBan(int userId) throws ServiceException {
        UserDao userDao;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (userId <= 0) {
                throw new ServiceException("Incorrect user ID");
            }

            userDao.SetBan(userId);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return true;
    }

    @Override
    public Boolean removeBan(int userId) throws ServiceException {
        UserDao userDao;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (userId <= 0) {
                throw new ServiceException("Incorrect user ID");
            }

            userDao.removeBan(userId);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return true;

    }
}
