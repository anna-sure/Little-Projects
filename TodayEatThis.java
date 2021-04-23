package day4;

import javax.swing.JOptionPane;

public class TodayEatThis {

        public static void main(String[] args) {

            //用数组保存 餐馆名字
            String [] foodName = {"面","炒饭","空气","海南鸡饭","麦当劳","肯德基","綠豆湯"};
            //得到arr長度，用作隨機最大數
            int count = foodName.length;
            //int轉整數，最小數為1，得到arr長度內的隨機數
            int count2 = (int)(Math.random() * count + 1);
            //根據arr的index，字符印出
            String ans = foodName[count2 - 1];

            JOptionPane.showInternalMessageDialog(null, "今天吃 " + ans);


        }

    }

