import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Mall {
    private List<Commodity> commodities;

    public void loadCommodities(String filePath) {
        try {
            Gson gson = new Gson();
            Type listype = new TypeToken<List<Commodity>>(){}.getType();
            commodities = gson.fromJson(new FileReader(filePath), listype); 
        } catch (Exception e) {
            e.printStackTrace();
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
