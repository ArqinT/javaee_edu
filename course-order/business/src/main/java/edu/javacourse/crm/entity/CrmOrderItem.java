package edu.javacourse.crm.entity;

/**
 * Created by artemtursunov on 14.12.16.
 */
public class CrmOrderItem {

    private Long orderIteId;
    private CrmOrder order;
    private CrmProduct product;
    private Double price;
    private Integer quantity;

    public Long getOrderIteId() {
        return orderIteId;
    }

    public void setOrderIteId(Long orderIteId) {
        this.orderIteId = orderIteId;
    }

    public CrmOrder getOrder() {
        return order;
    }

    public void setOrder(CrmOrder order) {
        this.order = order;
    }

    public CrmProduct getProduct() {
        return product;
    }

    public void setProduct(CrmProduct product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
