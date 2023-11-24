package com.example.wt_laba2.data.service;

import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.CartItem;
import com.example.wt_laba2.domain.model.OrderDao;
import com.example.wt_laba2.domain.service.OrderService;
import com.example.wt_laba2.util.DAOFactory;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(String address, List<CartItem> cart) throws ServiceException {
        try {
            if (address != null && cart != null) {
                OrderDao orderDao = DAOFactory.getFactory().getOrderDao();
                orderDao.CreateOrder(address, cart);
            }
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

    }
}
