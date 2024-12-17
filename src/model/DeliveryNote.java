package model;

import java.util.List;

public class DeliveryNote {
    private int orderNumber;
    private String contactPerson;
    private String contactPhone;
    private String address;
    private List<Commodity> commodities;

    private double totalPrice;
    private String discountType;

    public DeliveryNote(Order order, String contactPerson, String contactPhone, String address) {
        this.orderNumber = order.getOrderNumber();
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.address = address;
        this.commodities = order.getCommodities();
        this.totalPrice = order.getTotalPrice();
        this.discountType = order.getDiscountType();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("订单号：").append(orderNumber).append("\n");
        sb.append("联系人：").append(contactPerson).append("\n");
        sb.append("联系电话：").append(contactPhone).append("\n");
        sb.append("收货地址：").append(address).append("\n");
        sb.append("折扣类型：").append(discountType).append("\n");
        sb.append("折扣后的总价：").append(totalPrice).append("\n");
        sb.append("商品列表：\n");
        for (Commodity commodity : commodities) {
            sb.append(commodity).append("\n");
        }
        return sb.toString();
    }
}
