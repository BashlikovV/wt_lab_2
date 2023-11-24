package com.example.wt_laba2.tests;

import com.example.wt_laba2.data.local.model.User;
import com.example.wt_laba2.data.local.pool.ConnectionPool;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.model.UserDao;
import com.example.wt_laba2.util.ConnectionPoolFactory;
import com.example.wt_laba2.util.DAOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SQLUserDAOTest {

    @Test
    void signIn() throws DAOException {
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        } catch (Exception ex) {
            Assertions.fail("Problem with connection");
        }
        DAOFactory daoFactory = DAOFactory.getFactory();
        UserDao userDAO = daoFactory.getUserDao();
        User user = userDAO.signIn("KotVMeshke", "2003Fvbl");

        assertNotNull(user);
    }

    @Test
    void registration() throws DAOException {
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        } catch (Exception ex) {
            Assertions.fail("Problem with connection");
        }
        DAOFactory daoFactory = DAOFactory.getFactory();
        UserDao userDAO = daoFactory.getUserDao();
        User user = new User();
        user.setPassword("12345");
        user.setLogin("TestUser");
        long id = userDAO.registration(user);

        assertTrue(id > 0);
    }

    @Test
    void setBan() throws DAOException {
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        } catch (Exception ex) {
            Assertions.fail("Problem with connection");
        }
        DAOFactory daoFactory = DAOFactory.getFactory();
        UserDao userDAO = daoFactory.getUserDao();

        assertTrue(userDAO.SetBan(3));
    }

    @Test
    void removeBan() throws DAOException {
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        } catch (Exception ex) {
            Assertions.fail("Problem with connection");
        }
        DAOFactory daoFactory = DAOFactory.getFactory();
        UserDao userDAO = daoFactory.getUserDao();

        assertTrue(userDAO.removeBan(3));
    }
}