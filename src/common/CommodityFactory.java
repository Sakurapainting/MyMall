package common;

import model.*;

public class CommodityFactory {
    public static Commodity createCommodity(String type, int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        switch (type) {
            case "电子产品":
                return new ElectronicProduct(id, name, price, quantity, model, isWithBluetooth);
            case "日用品":
                return new DailyNecessity(id, name, price, quantity, model, isWithBluetooth);
            case "食品":
                return new Food(id, name, price, quantity, model, isWithBluetooth);
            case "文具":
                return new Stationery(id, name, price, quantity, model, isWithBluetooth);
            case "家电":
                return new HomeAppliance(id, name, price, quantity, model, isWithBluetooth);
            case "电脑":
                return new Computer(id, name, price, quantity, model, isWithBluetooth);
            case "手机":
                return new MobilePhone(id, name, price, quantity, model, isWithBluetooth);
            case "笔记本电脑":
                return new Laptop(id, name, price, quantity, model, isWithBluetooth, false);
            case "台式机":
                return new Desktop(id, name, price, quantity, model, isWithBluetooth);
            case "一体机":
                return new AllInOne(id, name, price, quantity, model, isWithBluetooth);
            case "平板电脑":
                return new Tablet(id, name, price, quantity, model, isWithBluetooth);
            case "耳机":
                return new Headphone(id, name, price, quantity, model, isWithBluetooth);
            case "移动硬盘":
                return new HardDrive(id, name, price, quantity, model, isWithBluetooth);
            case "蓝牙设备":
                return new BluetoothDevice(id, name, price, quantity, model);
            case "蓝牙耳机":
                return new BluetoothHeadphone(id, name, price, quantity, model);
            case "蓝牙笔记本":
                return new BluetoothLaptop(id, name, price, quantity, model);
            case "蓝牙手表":
                return new BluetoothWatch(id, name, price, quantity, model);
            default:
                System.out.println("未知的商品类型：" + type);
                return null;
        }
    }
}
