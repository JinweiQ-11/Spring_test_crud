package com.itheima.aop.anno;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/20 23:49
 * @description：
 * @modified By：
 * @version: $
 */
public class AsTargeta implements Itargeta {
    @Override
    public void save() {
            System.out.println("save taget!!");

    }
}
