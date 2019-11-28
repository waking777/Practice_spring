package com.itheima.factory;

import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * <p>
 * Bean：在计算机英语中有可重用组件的含义。
 * JavaBean：用Java语言编写的可重用组件。
 * <p>
 * 他就是创建我们的Service和dao对象的。
 * 第一个：需要一个配置文件来配置我们的service和dao
 * 第二个：通过来读取配置文件的配置内容，反射创建对象
 */
public class BeanFactory {
    //定义一个properties
    private static Properties props;

    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名字来获取bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanpath = props.getProperty(beanName);
            System.out.println(beanpath);
            bean = Class.forName(beanpath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
