package com.example.wt_laba2.domain.logic.impl;

import com.example.wt_laba2.domain.exceptions.CommandException;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.CartItem;
import com.example.wt_laba2.domain.model.ICommand;
import com.example.wt_laba2.domain.model.JSPNameList;
import com.example.wt_laba2.domain.model.OrderDao;
import com.example.wt_laba2.domain.service.OrderService;
import com.example.wt_laba2.util.DAOFactory;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ProcessOrder class implements ICommand to handle processing user orders.
 * It interacts with the OrderDao to create an order based on the products in the user's cart.
 */
public class ProcessOrder implements ICommand {

    /**
     * Executes the action to process an order based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the user's order.
     * @return A String representing the JSP name to navigate after processing the order.
     * @throws CommandException             If an error occurs while executing the order processing action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                  If an I/O exception occurs during execution.
     * @throws DAOException                 If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        OrderDao orderDao = null;
        OrderService orderService = null;
        try {
            String address = request.getParameter("address");
            orderDao = DAOFactory.getFactory().getOrderDao();
            List<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");

            orderService.createOrder(address, cart);

            request.getSession().removeAttribute("cart");
        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while processing the order.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

