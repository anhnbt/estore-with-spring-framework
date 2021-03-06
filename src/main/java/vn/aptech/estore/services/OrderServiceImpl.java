package vn.aptech.estore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.aptech.estore.entities.Order;
import vn.aptech.estore.repositories.OrderRepository;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Ba Tuan Anh <anhnbt.it@gmail.com>
 * Date: 8/22/2021
 * Time: 11:59 AM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = {SQLException.class})
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
