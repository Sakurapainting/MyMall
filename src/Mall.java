import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Mall {
    private List<Commodity> commodities;

    public void loadCommodities(String filePath) {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            RuntimeTypeAdapterFactory<Commodity> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Commodity.class, "type")
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
                .registerSubtype(BluetoothWatch.class, "蓝牙手表");

            gsonBuilder.registerTypeAdapterFactory(runtimeTypeAdapterFactory);
            Gson gson = gsonBuilder.create();

            Type listType = new TypeToken<List<Commodity>>(){}.getType();
            commodities = gson.fromJson(new FileReader(filePath), listType); 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("反序列化商品信息时出错，需要检查 JSON 数据和类的定义。");
        }
    }
    public void showAllCommodities() {
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    public Commodity getCommodityById(int id) {
        for (Commodity commodity : commodities) {
            if (commodity.getId() == id) {
                return commodity;
            }
        }
        return null;
    }

    public List<Commodity> findBlueTooth() {
        List<Commodity> bluetoothCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.hasBluetooth()) {
                bluetoothCommodities.add(commodity);
            }
        }
        return bluetoothCommodities;
    }
}
