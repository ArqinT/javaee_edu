package edu.javacourse.crm.entity;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by artemtursunov on 14.12.16.
 */
public class CrmOrder {

    //private static final Logger log = LoggerFactory.getLogger(CrmOrder.class);

    private Long orderId;
    private String orderNumber;
    private String user;
    private Date orderDate;
//
//    public static Logger getLog() {
//        return log;
//    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
