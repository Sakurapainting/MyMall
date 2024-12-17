package discount;

import java.time.LocalDate;

public class DiscountFactory {
    public static DiscountStrategy getDiscountStrategy() {
        LocalDate today = LocalDate.now();
        if (today.getMonthValue() == 10 && today.getDayOfMonth() == 1) { // 国庆节
            return new NationalDayDiscount();
        } else if (today.getMonthValue() == 11 && today.getDayOfMonth() == 11) { // 双十一
            return new Double11Discount();
        } else if (today.getMonthValue() == 10 && today.getDayOfMonth() == 24) { // 程序员节
            return new ProgrammerDayDiscount();
        } else {
            return new NoDiscount(); // 无折扣
        }
    }
}
