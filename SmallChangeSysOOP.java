package SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP完成
 * 将各个功能对应一个方法
 */
public class SmallChangeSysOOP {
    //---1.0版本的变量都变成对象的属性，黏贴如下：---
    //定义变量
    boolean loop = true;
    //至少显示一次的菜单，so use "do"loop
    Scanner scanner = new Scanner(System.in);
    String key = "";//接收用户选择

    // step2思路：现只有收入和支出功能，1.可以把收益和消费保存到数组，但是需要动态增加元素
    //      2.可以使用对象  3.简单的话可以使用String拼接，先选择这一种

    String details = "---------------零钱通明细-------------";

    // step3思路：定义新的变量（完成功能驱动程序员增加新的变量和代码）
    double money = 0;
    double balance = 0;
    Date date = null; // 引入Util.Date包
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //用于日期时间格式化

    // step4思路：定义新变量，保存消费原因
    String note = "";

    //step1 完成显示菜单，并可以选择菜单，给出对应提示信息
    public void mainMenu(){
        do{
            System.out.println("\n===============零钱通OOP菜单============");
            System.out.println("\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t2. 收益入账");
            System.out.println("\t\t\t3. 消费情况");
            System.out.println("\t\t\t4. 退    出");
            //写到这里，自然需要用户输入选项 -> line 15

            System.out.print("请选择(1-4)：");
            key = scanner.next();

            //使用switch 分支控制
            switch(key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，请重新选择");
            }

        }while(loop);
    }

    //step2 完成零钱通明细功能
    public void detail(){
        System.out.println(details);
    }

    //step3 完成收益入账
    public void income(){
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        //money的值应该校验 -> 先搭主框架，再完善
        //老韩编程思路：在我们进行一系列判断时候，尽量找不正确条件
        //不要想正确的，只要找出不正确金额的条件，给出提示，直接return
        //如果先找出正确的金额，后面还是需要增加一段不正确的条件代码
        if(money <= 0){
            System.out.println("收益入账金额需大于0");
            return;//在方法中不再使用break，用return退出方法
        }
        balance += money;
        //拼接收益入账信息到details
        date = new Date();//获取当前日期
        //System.out.println(sdf.format(date));
        details += "\n收益入账\t+" +money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
    }

    //step4 完成消费情况
    public void pay(){
        System.out.print("请输入消费金额：");
        money = scanner.nextDouble();
        //money的值应该校验
        //同上，找出金额不正确的情况
        if(money <= 0 || money > balance){
            System.out.println("您消费的金额应该在：0-"+balance);
            return;
        }
        System.out.print("请输入消费品项：");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到details
        date = new Date();//获取当前日期
        details += "\n" +note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
    }

    //step5 退出程序
    public void exit() {
        String choice = "";
        while (true) {
            System.out.println("您确定要退出吗？y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }

        //当用户退出while后，再进行判断
        if (choice.equals("y")) {
            loop = false;
            System.out.println("==========您退出了零钱通系统 ：）=============");
        }

    }
}
