package com.example.wt_laba2.data.service;

import com.example.wt_laba2.data.local.model.Product;
import com.example.wt_laba2.domain.exceptions.DAOException;
import com.example.wt_laba2.domain.exceptions.ServiceException;
import com.example.wt_laba2.domain.model.ProductDao;
import com.example.wt_laba2.domain.service.ProductService;
import com.example.wt_laba2.util.DAOFactory;

import java.io.InputStream;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> GetProductListByCat(String category) throws ServiceException {
        List<Product> list = null;
        try {
            if (category != null) {
                ProductDao productDao = DAOFactory.getFactory().getProductDao();
                list = productDao.GetProductListByCat(category);

            }
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

        return list;
    }

    @Override
    public List<Product> GetAllProduct() throws ServiceException {
        List<Product> list;
        try {

            ProductDao productDao = DAOFactory.getFactory().getProductDao();
            list = productDao.GetAllProduct();


        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

        return list;
    }

    @Override
    public boolean SetDiscount(int productId, int discountSize) throws ServiceException {
        try {
            if (productId <= 0) {
                throw new ServiceException("Incorrect product id");
            }
            ProductDao productDao = DAOFactory.getFactory().getProductDao();
            if (discountSize < 0) {
                discountSize = 0;
            } else if (discountSize > 100) {
                discountSize = 100;
            }

            productDao.SetDiscount(productId, discountSize);


        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

        return false;
    }

    @Override
    public boolean AddProduct(String name, String price, String category, InputStream file) throws ServiceException {
        try {
            ProductDao productDao = DAOFactory.getFactory().getProductDao();
            if (name == null || price == null || category == null || file == null) {
                throw new ServiceException("Incorrect value in product add");
            }
            productDao.AddProduct(name, price, category, file);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

        return true;
    }

    @Override
    public Product GetProductById(int id) throws ServiceException {
        Product product;
        try {
            if (id <= 0) {
                throw new ServiceException("Incorrect id");
            }
            ProductDao productDao = DAOFactory.getFactory().getProductDao();
            product = productDao.GetProductById(id);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return product;
    }
}
