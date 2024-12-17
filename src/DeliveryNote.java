import java.util.List;

public class DeliveryNote {
    private int orderNumber;
    private String contactPerson;
    private String contactPhone;
    private String address;
    private List<Commodity> commodities;

    public DeliveryNote(Order order, String contactPerson, String contactPhone, String address) {
        this.orderNumber = order.getOrderNumber();
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.address = address;
        this.commodities = order.getCommodities();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("订单号：").append(orderNumber).append("\n");
        sb.append("联系人：").append(contactPerson).append("\n");
        sb.append("联系电话：").append(contactPhone).append("\n");
        sb.append("收货地址：").append(address).append("\n");
        sb.append("商品列表：\n");
        for (Commodity commodity : commodities) {
            sb.append(commodity).append("\n");
        }
        return sb.toString();
    }
}
