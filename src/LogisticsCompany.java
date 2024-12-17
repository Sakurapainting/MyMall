import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogisticsCompany {
    public void processOrder(String orderJsonData) {
        try {
            Gson gson = GsonProvider.getGson();

            // 反序列化 Order 对象
            Order order = gson.fromJson(orderJsonData, Order.class);

            // 生成物流单
            DeliveryNote deliveryNote = createDeliveryNote(order);
            // 打印物流单
            System.out.println("物流单：");
            System.out.println(deliveryNote);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("处理订单时出错。");
        }
    }

    private DeliveryNote createDeliveryNote(Order order) {
        String contactPerson = order.getContactPerson(); 
        String contactPhone = order.getContactPhone(); 
        String address = order.getAddress();
        return new DeliveryNote(order, contactPerson, contactPhone, address);
    }
}
