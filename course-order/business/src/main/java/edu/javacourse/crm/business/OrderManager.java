package edu.javacourse.crm.business;

import edu.javacourse.crm.dao.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by artemtursunov on 14.12.16.
 */
public class OrderManager {

    private static final Logger  log = LoggerFactory.getLogger(OrderManager.class);

    private OrderDAO dao;

    public void updateOrder() {
        int counter = 10;
        log.info("Info: {} {} {}", counter, counter, counter);
        System.out.println("HELLO");
    }
}
