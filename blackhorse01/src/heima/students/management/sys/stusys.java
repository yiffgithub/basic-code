package heima.students.management.sys;

import java.util.ArrayList;
import java.util.Scanner;


public class stusys {
    public static void main(String[] args) {
        ArrayList<dog> list = new ArrayList<>();


        infinityloop:while (true) {
            System.out.println("----------------好想做一条狗啊---------------");
            System.out.println("1: 添加一只舔狗");
            System.out.println("2: 删除一只舔狗");
            System.out.println("3: 修改一只舔狗");
            System.out.println("4: 查询一只舔狗");
            System.out.println("5: 我不在做舔狗");
            System.out.println("告诉我你的选择你这只舔狗:");
            Scanner input = new Scanner(System.in);
            String choose = input.next();

        switch (choose){
            case "1"-> adddog( list);
            case "2"-> deletedog(list);
            case "3"-> modifydog(list);
            case "4"-> searchdog(list);
            case "5"-> {System.out.println("期待您下次再做舔狗");
                break infinityloop;}
            default -> System.out.println("写的什么玩意，舔狗都做不明白");
        }
        }
        System.out.println("exiting");


    }


    public static void adddog( ArrayList<dog> list) {


        System.out.println("正在添加一只舔狗");
        dog d = new dog();
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println("输入你的狗牌：");
            String id = input.next();
            boolean flag = contains(list,id);
            //如果是true，就说明id重复了
            if (flag==true){
                System.out.println("这只舔狗已存在");
            }else{
                //没有重复
                d.setId(id);
                break;

            }
        }


        System.out.println("输入你的狗名：");
        String name = input.next();
        d.setName(name);

        System.out.println("输入你的狗龄：");
        int age = input.nextInt();
        d.setAge(age);

        System.out.println("输入你的狗窝：");
        String address = input.next();
        d.setAddress(address);

        list.add(d);
        System.out.println("这只舔狗我们要了！");







    }
    public static void deletedog( ArrayList<dog> list) {
        Scanner input = new Scanner(System.in);
        String id = input.next();
        int index = getindex(list,id);
        if (index == -1)
        {System.out.println("没有这只舔狗你删nm呢");
        }else {list.remove(index);



        System.out.println("正在删除一只舔狗");
        System.out.println("id为"+ index+"的舔狗已经没辣");}


    }
    public static void modifydog( ArrayList<dog> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要修改的狗牌");
        String id = input.next();
        int index = getindex(list, id);
        if (index== -1)
        {
            System.out.println("目前舔狗管理中心还没有收录这只舔狗");
        return;
        }
        dog newdog = list.get(index);
        System.out.println("输入新的狗牌:");
        String newid = input.next();
        newdog.setId(newid);

        System.out.println("输入新的狗名:");
        String newname = input.next();
        newdog.setName(newname);

        System.out.println("输入新的狗龄:");
        int newage = input.nextInt();
        newdog.setAge(newage);

        System.out.println("输入新的狗窝:");
        String newaddress = input.next();
        newdog.setAddress(newaddress);

        System.out.println("舔狗进化成功");








        System.out.println("正在修改一只舔狗");

    }
    public static void searchdog( ArrayList<dog> list) {
        System.out.println("正在查询一只舔狗");
        if (list.size() == 0){
            System.out.println("现在还没有舔狗呢");
            return;
        }else {
            //打印表头信息
            /*System.out.println("狗牌\t\t狗名\t狗龄\t狗窝");*/
            System.out.printf("%-10s %-10s %-10s %-10s\n", "狗牌", "狗名", "狗龄", "狗窝");
            for (dog d : list) {
                System.out.printf("%-10s %-10s %-10d %-10s\n", d.getId(), d.getName(), d.getAge(), d.getAddress());


            }

        }

    }

    public static boolean contains(ArrayList<dog> list, String id) {
      /*  for (int i = 0; i < list.size(); i++) {
            dog d = list.get(i);
            String sid = d.getId();
            if(sid.equals(id)){
                return true;
            }

        }
        return false;
*/
        return getindex(list,id)>=0;

    }

    public static int getindex(ArrayList<dog> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            dog d = list.get(i);
            String sid = d.getId();
            if (sid.equals(id))
                return i;
            //exist

        }
        return -1;
    }





}
