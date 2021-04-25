package SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //1.0版使用过程编程，2.0版本再使用OOP编程
    //化繁为简
    //step1 完成显示菜单，并可以选择菜单，给出对应提示信息（先把架子搭起来）
    //step2 完成零钱通明细功能
    //step3 完成收益入账
    //step4 完成消费情况
    //step5 退出程序
    //step6优化 退出提示信息、收益消费金额逻辑、画面对齐等

    public static void main(String[] args){

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

        do{
            System.out.println("\n===============零钱通菜单============");
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
                    System.out.println(details); //直接打印details
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    //money的值应该校验 -> 先搭主框架，再完善
                    //老韩编程思路：在我们进行一系列判断时候，尽量找不正确条件
                    //不要想正确的，只要找出不正确金额的条件，给出提示，直接break
                    //如果先找出正确的金额，后面还是需要增加一段不正确的条件代码
                    if(money <= 0){
                        System.out.println("收益入账金额需大于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息到details
                    date = new Date();//获取当前日期
                    //System.out.println(sdf.format(date));
                    details += "\n收益入账\t+" +money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
                    break;
                case "3":
                    System.out.print("请输入消费金额：");
                    money = scanner.nextDouble();
                    //money的值应该校验
                    //同上，找出金额不正确的情况
                    if(money <= 0 || money > balance){
                        System.out.println("您消费的金额应该在：0-"+balance);
                        break;
                    }
                    System.out.print("请输入消费品项：");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息到details
                    date = new Date();//获取当前日期
                    details += "\n" +note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
                    break;
                case "4":
                    //定义变量，接收用户输入
                    //使用 while + break，处理接收到的输入是 y 或者 n
                    //退出while后，再判断choice是y还是n，再做处理
                    //老韩编程思想：一段代码完成一个小功能(越小越好)，尽量不要混在一起，
                    // 这样写耦合性较小，阅读性高，扩展性也比较好。

                    String choice = "";
                    while(true) {
                        System.out.println("您确定要退出吗？y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }

                    //当用户退出while后，再进行判断
                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新选择");
            }

        }while(loop);

        System.out.println("==========您退出了零钱通系统 ：）=============");

    }

}
