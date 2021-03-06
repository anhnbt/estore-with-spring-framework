package vn.aptech.estore.services;

import org.springframework.stereotype.Service;
import vn.aptech.estore.entities.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Ba Tuan Anh <anhnbt.it@gmail.com>
 * Date: 8/20/2021
 * Time: 8:11 PM
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private double total;
    private final Map<Long, Product> items;
    private int numberOfItems;

    public ShoppingCartServiceImpl() {
        this.items = new HashMap<>();
    }

    @Override
    public Map<Long, Product> getItems() {
        return items;
    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> products = new HashSet<>();
        for (Map.Entry<Long, Product> entry : items.entrySet()) {
            Product product = entry.getValue();
            products.add(product);
        }
        return products;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void addToCart(Product product) {
        Long id = product.getId();
        if (items.containsKey(id)) {
            // Neu ton tai san pham thi cap nhat lai so luong
            this.updateCart(id, product);
            System.out.println("Da cap nhat so luong gio hang!");
        } else {
            // Them san pham vao gio hang
            items.put(id, product);
            System.out.println("Thêm vào giỏ hàng thành công!!");
        }
    }

    @Override
    public void updateCart(Long id, Product product) {
        Product prod = items.get(id);
        prod.setUnitsInStock(prod.getUnitsInStock() + product.getUnitsInStock());
        items.put(id, prod);
    }

    @Override
    public void removeProduct(Product product) {
        items.remove(product.getId());
    }

    @Override
    public void removeProductById(Long id) {
        items.remove(id);
    }

    @Override
    public void removeAll() {
        items.clear();
        total = 0;
        numberOfItems = 0;
    }

    @Override
    public int getNumberOfItems() {
        for (Map.Entry<Long, Product> entry : items.entrySet()) {
            Product product = entry.getValue();
            total += product.getUnitsInStock() * product.getUnitPrice();
            numberOfItems += product.getUnitsInStock();
        }
        return numberOfItems;
    }
}
