import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {
    private static final Gson gson = createGson();

    private static Gson createGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        RuntimeTypeAdapterFactory<Commodity> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Commodity.class, "__type") 
            .registerSubtype(DailyNecessity.class, "日用品")
            .registerSubtype(HomeAppliance.class, "家电")
            .registerSubtype(ElectronicProduct.class, "电子产品")
            .registerSubtype(Food.class, "食品")
            .registerSubtype(Stationery.class, "文具")
            .registerSubtype(Computer.class, "电脑")
            .registerSubtype(Laptop.class, "笔记本电脑")
            .registerSubtype(Desktop.class, "台式机")
            .registerSubtype(AllInOne.class, "一体机")
            .registerSubtype(Tablet.class, "平板电脑")
            .registerSubtype(MobilePhone.class, "手机")
            .registerSubtype(Headphone.class, "耳机")
            .registerSubtype(HardDrive.class, "移动硬盘")
            .registerSubtype(BluetoothDevice.class, "蓝牙设备")
            .registerSubtype(BluetoothHeadphone.class, "蓝牙耳机")
            .registerSubtype(BluetoothLaptop.class, "蓝牙笔记本")
            .registerSubtype(BluetoothWatch.class, "蓝牙手表")
            .registerSubtype(AirConditioner.class, "空调")
            .registerSubtype(Refrigerator.class, "电冰箱")
            .registerSubtype(Fan.class, "风扇")
            .registerSubtype(WaterHeater.class, "热水器")
            .registerSubtype(Humidifier.class, "加湿器")
            .recognizeSubtypes(); // 启用子类型识别

        gsonBuilder.registerTypeAdapterFactory(runtimeTypeAdapterFactory);
        return gsonBuilder.create();
    }

    public static Gson getGson() {
        return gson;
    }
}
