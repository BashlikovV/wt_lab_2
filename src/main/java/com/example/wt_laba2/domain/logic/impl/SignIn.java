package com.example.wt_laba2.domain.logic.impl;

import com.example.wt_laba2.data.local.model.User;
import com.example.wt_laba2.domain.exceptions.CommandException;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.ICommand;
import com.example.wt_laba2.domain.model.JSPNameList;
import com.example.wt_laba2.domain.model.SessionAtributes;
import com.example.wt_laba2.domain.service.UserService;
import com.example.wt_laba2.util.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The SignIn class implements ICommand to handle user sign-in functionality.
 * It interacts with the UserDao to sign in a user based on provided login credentials.
 */
public class SignIn implements ICommand {

    /**
     * Executes the action to sign in a user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information for user sign-in.
     * @return A String representing the JSP name to navigate after signing in the user.
     * @throws CommandException             If an error occurs while executing the sign-in action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                  If an I/O exception occurs during execution.
     * @throws DAOException                 If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, DAOException, IOException {
        UserService userService = null;
        try {
            userService = ServiceFactory.getInstance().getUserService();

            User user = userService.signIn(request.getParameter("Login"), request.getParameter("Password"));
            request.setAttribute("SomeMessage", "Successful LogIn");
            request.getSession().setAttribute(SessionAtributes.Authorized, true);
            request.getSession().setAttribute(SessionAtributes.UserId, user.getId());
            request.getSession().setAttribute(SessionAtributes.isAdmin, user.getRole());

        } catch (ServiceException ex) {
            throw new CommandException("Incorrect Login or password.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

