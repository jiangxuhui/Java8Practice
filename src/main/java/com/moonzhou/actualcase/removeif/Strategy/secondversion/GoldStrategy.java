package com.moonzhou.actualcase.removeif.Strategy.secondversion;

import com.moonzhou.actualcase.removeif.Strategy.secondversion.DiscountStrategy;
import com.moonzhou.actualcase.removeif.UserType;

/**
 * 黄金会员优惠方法
 *
 * @author moon-zhou
 * @Date: 2019/12/14 21:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoldStrategy implements DiscountStrategy {
    /**
     * 优惠抽象方法
     *
     * @param money
     * @return
     */
    @Override
    public double discount(double money) {
        System.out.println("黄金会员，8折优惠");
        return money * 0.8;
    }

    /**
     * 返回用户类型
     *
     * @return
     */
    @Override
    public String getUserTypeCode() {
        return UserType.GOLD_VIP.getCode();
    }
}
