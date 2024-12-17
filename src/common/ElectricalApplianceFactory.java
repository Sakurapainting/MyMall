import model.*;

public class ElectricalApplianceFactory {
    public static ElectricalAppliance createAppliance(String type, int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        switch (type) {
            case "电冰箱":
                return new Refrigerator(id, name, price, quantity, model, isWithBluetooth);
            case "空调":
                return new AirConditioner(id, name, price, quantity, model, isWithBluetooth);
            case "风扇":
                return new Fan(id, name, price, quantity, model, isWithBluetooth);
            case "热水器":
                return new WaterHeater(id, name, price, quantity, model, isWithBluetooth);
            case "加湿器":
                return new Humidifier(id, name, price, quantity, model, isWithBluetooth);
            default:
                System.out.println("未知的电器类型：" + type);
                return null;
        }
    }
}
