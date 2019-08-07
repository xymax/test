package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstracCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends AbstracCommand { //货物更新命令

    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品");
        System.out.println("请输入更新商品的编号");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if (goods == null) {
            System.out.println("此编号商品不存在");
            return;
        } else {
            System.out.println("商品原信息如下");
            System.out.println(goods);
            System.out.println("请输入更新的商品简介");
            String introduce = scanner.next();
            System.out.println("请输入商品库存");
            int stock = scanner.nextInt();
            System.out.println("商品单位：包，个，箱...");
            String unit = scanner.next();
            System.out.println("请输入商品价格：单位（分）");
            int price = new Double(100 * scanner.nextInt()).intValue();
            System.out.println("请输入商品折扣");
            int discount = scanner.nextInt();
            System.out.println("是否确认更新 y/n");
            String confirm = scanner.next();
            if ("y".equals(confirm)) {
                goods.setDiscount(discount);
                goods.setIntroduce(introduce);
                goods.setPrice(price);
                goods.setDiscount(discount);
                goods.setUnit(unit);
                boolean effect = this.goodsService.updateGoods(goods);
                if (effect) {
                    System.out.println("商品更新成功");
                } else {
                    System.out.println("商品更新失败");
                }
            } else {
                System.out.println("退出更新");
            }
        }
    }
}

