package discount;

import java.util.List;
import model.*;

public class NationalDayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Commodity> commodities) {
        double total = 0.0;
        for (Commodity commodity : commodities) {
            if (commodity instanceof HomeAppliance || commodity instanceof ElectronicProduct) {
                total += commodity.getPrice() * 0.8;
            } else {
                total += commodity.getPrice();
            }
        }
        return total;
    }

    @Override
    public String getHolidayName() {
        return "国庆节";
    }
}
