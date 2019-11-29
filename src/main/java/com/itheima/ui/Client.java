package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * 模拟一个表现层，调用业务层
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id来获取对象
     *
     **ApplicationContext的三个常用实现类
     *     ClassPathXmlApplicationContext      :他可以加载类路径下的配置文件，要求配置文件必须在类路径下,不在的加载不了
     *     FileSystemXmlApplicationContext     :他可以加载磁盘任意路径下的配置文件，必须有访问权限。
     *     AnnotationConfigApplicationContext  :他是用于读取注解创建容器的。
     * @param args
     */
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
//        for(int i=0 ;i<5;i++ ) {
//            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
//            System.out.println(as);
//        }
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");  //常用
        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\develop\\idea\\IdeaProjects\\xinjian" +
                "\\Practice_spring\\src\\main\\resources\\bean.xml");
        //2.根据ID来获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
//        as.saveAccount();
    }
}
