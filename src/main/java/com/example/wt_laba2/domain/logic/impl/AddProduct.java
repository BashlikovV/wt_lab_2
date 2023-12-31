package com.example.wt_laba2.domain.logic.impl;

import com.example.wt_laba2.domain.exceptions.CommandException;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.ICommand;
import com.example.wt_laba2.domain.model.JSPNameList;
import com.example.wt_laba2.domain.service.ProductService;
import com.example.wt_laba2.util.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * The AddProduct class implements ICommand to handle adding a new product functionality.
 * It retrieves necessary parameters from the HttpServletRequest and adds a new product to the database.
 */
public class AddProduct implements ICommand {

    /**
     * Executes the action to add a new product based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the product to be added.
     * @return A String representing the JSP name to navigate after adding the product.
     * @throws CommandException             If an error occurs while executing the add product action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                  If an I/O exception occurs during execution.
     * @throws DAOException                 If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        InputStream inputStream = null;
        ProductService productService;
        try {
            productService = ServiceFactory.getInstance().getProductService();
            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            String productCategory = request.getParameter("productCategory");
            Part filePart = request.getPart("productImage");
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
            productService.AddProduct(productName, productPrice, productCategory, inputStream);

        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while adding a product to the database.");
        } catch (ServletException ex) {
            throw new CommandException("Incorrect file format or error during file upload.");
        }

        return JSPNameList.ADMINISTRATOR_PAGE;
    }
}
