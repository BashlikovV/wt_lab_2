package com.example.wt_laba2.util;

import com.example.wt_laba2.data.service.OrderServiceImpl;
import com.example.wt_laba2.data.service.ProductServiceImpl;
import com.example.wt_laba2.data.service.UserServiceImpl;
import com.example.wt_laba2.domain.service.OrderService;
import com.example.wt_laba2.domain.service.ProductService;
import com.example.wt_laba2.domain.service.UserService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ProductService productService = new ProductServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public UserService getUserService() {
        return userService;
    }
}
