package vn.aptech.estore.services;

import vn.aptech.estore.entities.Product;

import java.math.BigDecimal;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Ba Tuan Anh <anhnbt.it@gmail.com>
 * Date: 8/20/2021
 * Time: 8:10 PM
 */
public interface ShoppingCartService {
    void addToCart(Product product);

    void updateCart(Long id, Product product);

    void removeProduct(Product product);

    void removeProductById(Long id);

    void removeAll();

    Hashtable<Long, Product> getItems();

    double getTotal();

    int getNumberOfItems();
}
