package discount;

import java.util.List;
import model.*;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Commodity> commodities) {
        double total = 0.0;
        // 无折扣
        for (Commodity commodity : commodities) {
            total += commodity.getPrice();
        }
        return total;
    }

    @Override
    public String getHolidayName() {
        return "无折扣";
    }
}
