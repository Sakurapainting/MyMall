package discount;

import java.util.List;
import model.Commodity;

public interface DiscountStrategy {
    double applyDiscount(List<Commodity> commodities);
    String getHolidayName();
}
