package com.lizheblogs.demo.data;

import com.google.gson.reflect.TypeToken;
import com.lizheblogs.demo.bean.MainBean;
import com.lizheblogs.demo.common.utils.GsonUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by LiZhe on 2019-09-27.
 * com.lizheblogs.demo.data
 */
public class TestFlowData {

    public static ArrayList<MainBean> getTestData() {
        Type listType = new TypeToken<ArrayList<MainBean>>() {
        }.getType();
        ArrayList<MainBean> list = GsonUtils.jsonToObject(flowdata, listType);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    private final static String flowdata = "[{\"ord\":1,\"Name\":\"客户名称\",\"Value\":\"达五伊粒昂天有限公司\"},{\"ord\":2,\"Name\":\"订单编号\",\"Value\":\"XD-20181226-002\"},{\"ord\":3,\"Name\":\"订单日期\",\"Value\":\"2018-12-26\"},{\"ord\":4,\"Name\":\"订单状态\",\"Value\":\"已交付\"},{\"ord\":5,\"Name\":\"材质\",\"Value\":\"2E_1B\"},{\"ord\":6,\"Name\":\"单张面积\",\"Value\":\"0.35\"},{\"ord\":7,\"Name\":\"总面积\",\"Value\":\"2535.29\"},{\"ord\":8,\"Name\":\"尺寸\",\"Value\":\"460*755\"},{\"ord\":9,\"Name\":\"张数\",\"Value\":\"7300\"},{\"ord\":10,\"Name\":\"单价\",\"Value\":\"1.16\"},{\"ord\":11,\"Name\":\"压线类型\",\"Value\":\"无限压到压不上为止\"},{\"ord\":12,\"Name\":\"压线\",\"Value\":\"1000\"},{\"ord\":13,\"Name\":\"期望交货日期\",\"Value\":\"2018-12-28\"},{\"ord\":14,\"Name\":\"客户单号\",\"Value\":\"185498854874166849485\"},{\"ord\":15,\"Name\":\"打包方式\",\"Value\":\"大盒简易包装\"},{\"ord\":16,\"Name\":\"生产备注\",\"Value\":\"要严格按照标准生成茶农品\"},{\"ord\":17,\"Name\":\"送货要求\",\"Value\":\"要最快的速度送到到指定位置\"},{\"ord\":18,\"Name\":\"排程数\",\"Value\":\"7300\"},{\"ord\":19,\"Name\":\"生产数\",\"Value\":\"7300\"},{\"ord\":20,\"Name\":\"生管完工数\",\"Value\":\"0\"},{\"ord\":21,\"Name\":\"PDA入库数\",\"Value\":\"0\"},{\"ord\":22,\"Name\":\"理货数\",\"Value\":\"7300\"},{\"ord\":23,\"Name\":\"装车数\",\"Value\":\"7300\"},{\"ord\":24,\"Name\":\"库存数\",\"Value\":\"0\"},{\"ord\":25,\"Name\":\"发货数\",\"Value\":\"7300\"},{\"ord\":26,\"Name\":\"出库单草稿数\",\"Value\":\"0\"},{\"ord\":27,\"Name\":\"未发货数\",\"Value\":\"0\"},{\"ord\":28,\"Name\":\"实时库存\",\"Value\":\"0\"},{\"ord\":29,\"Name\":\"订单呆滞天数\",\"Value\":\"0\"},{\"ord\":30,\"Name\":\"订货单价\",\"Value\":\"1.16\"}]";
}
