package discount;

import java.util.List;
import model.Commodity;

public class Double11Discount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<Commodity> commodities) {
        double total = 0.0;
        // 全部打七折
        for (Commodity commodity : commodities) {
            total += commodity.getPrice() * 0.7;
        }
        return total;
    }

    @Override
    public String getHolidayName() {
        return "双十一";
    }
}
