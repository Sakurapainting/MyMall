package discount;

import java.util.List;
import model.*;

public class ProgrammerDayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Commodity> commodities) {
        double total = 0.0;
        for (Commodity commodity : commodities) {
            // 电子产品打九折
            if (commodity instanceof ElectronicProduct) {
                total += commodity.getPrice() * 0.9 * commodity.getQuantity();
            } else {
                total += commodity.getPrice() * commodity.getQuantity();
            }
        }
        return total;
    }

    @Override
    public String getHolidayName() {
        return "程序员节";
    }
}
