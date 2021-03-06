package com.moonzhou.actualcase.removeif;

import com.moonzhou.actualcase.removeif.Strategy.firstversion.*;
import com.moonzhou.actualcase.removeif.Strategy.secondversion.StrategyFactory;

/**
 * 策略封装的上下文<br>
 *
 * @author moon zhou
 * @Date: 2019/12/14 17:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DiscountBizScene {
    /**
     * 通过if直接进行计算
     * @param money
     * @param userType
     * @return
     */
    public static double getDiscountPriceByIf(double money, String userType) {
        double result = money;

        if (money >= 1000) {

            if (UserType.SILVER_VIP.getCode().equals(userType)) {

                System.out.println("白银会员，优惠￥50");
                result = money - 50;
            } else if (UserType.GOLD_VIP.getCode().equals(userType)) {

                System.out.println("黄金会员，8折优惠");
                result = money * 0.8;
            } else if (UserType.PLATINUM_VIP.getCode().equals(userType)) {

                System.out.println("白金会员，优惠50元，再打7折");
                result = (money - 50) * 0.7;
            } else {

                System.out.println("普通会员，不打折");
                result = money;
            }
        }

        return result;
    }

    /**
     * 抽象具体优惠方法到策略接口里
     * @param money
     * @param userType
     * @return
     */
    public static double getDiscountPriceByIfStrategy(double money, String userType) {
        if (money < 1000) {
            return money;
        }

        DiscountStrategy discountStrategy = null;

        if (money >= 1000) {

            if (UserType.SILVER_VIP.getCode().equals(userType)) {

                discountStrategy = new SilverStrategy();
            } else if (UserType.GOLD_VIP.getCode().equals(userType)) {

                discountStrategy = new GoldStrategy();
            } else if (UserType.PLATINUM_VIP.getCode().equals(userType)) {

                discountStrategy = new PlatinumStrategy();
            } else {

                discountStrategy = new OrdinaryStrategy();
            }
        }

        return discountStrategy.discount(money);
    }

    /**
     * 抽象具体优惠方法到策略接口里
     * @param money
     * @param userType
     * @return
     */
    public static double getDiscountPriceByIfStrategyInContext(double money, String userType) {
        if (money < 1000) {
            return money;
        }

        DiscountContext discountContext = null;

        if (money >= 1000) {

            if (UserType.SILVER_VIP.getCode().equals(userType)) {

                discountContext = new DiscountContext(new SilverStrategy());
            } else if (UserType.GOLD_VIP.getCode().equals(userType)) {

                discountContext = new DiscountContext(new GoldStrategy());
            } else if (UserType.PLATINUM_VIP.getCode().equals(userType)) {

                discountContext = new DiscountContext(new PlatinumStrategy());
            } else {

                discountContext = new DiscountContext(new OrdinaryStrategy());
            }
        }

        return discountContext.getResult(money);
    }


    /**
     * 通过Stream + 策略模式，简化业务主逻辑的if
     * @param money
     * @param userType
     * @return
     */
    public static double getDiscountPriceByStreamStrategy(double money, String userType) {

        if (money < 1000) {
            return money;
        }

        com.moonzhou.actualcase.removeif.Strategy.secondversion.DiscountStrategy strategy = StrategyFactory.getInstance().get(userType);

        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }

        return strategy.discount(money);
    }
}
