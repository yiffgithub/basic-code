package heima.students.management.sys;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<User>();
        while (true) {
            System.out.println("欢迎来流浪舔狗管理中心"

            );
            System.out.println("请选择操作：1登录 2注册 3忘记密码 4退出");
            Scanner input = new Scanner(System.in);
            String choose = input.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> signin(list);
                case "3" -> forgetpassword(list);
                case "4" -> {
                    System.out.println("get out! dumbass!");
                    System.exit(0);
                }


                default -> {
                    System.out.println("invalid command, dumbass!");

                }
            }
        }
    }

    private static void login(ArrayList<User> list) {
        for (int i = 0; i < 3; i++) {
            System.out.println("log in");
            System.out.println("give me your dog name");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("用户名位注册，请先注册再登录");
                return;

            }
            System.out.println("type your fking passcode.");
            String passcode = sc.next();

            while (true) {
                // yanzhengma ceshi
                String rightcode = getcode();
                System.out.println("the is the test code sillb:" + rightcode);
                System.out.println("输入你的验证码");

                String code = sc.next();
                if (rightcode.equalsIgnoreCase(code)) {
                    System.out.println("damn right !");
                    break;
                } else {
                    System.out.println("验证码错误，请重新输入");
                    continue;
                }
            }
            //验证用户名和密码是否正确=验证集合中是否包含用户名和密码
            //定义一个方法

            //封装思想的应用：
            //我们可以把一些零散的数据，封装成一个对象
            //这样子在以后想要传递参数的时候，只要传递一整个整体就可以了，
            // 不需要这些零散 的数据
            User userinfo = new User(username, passcode, null, null);
            boolean result = checkuserinfo(list, userinfo);
            if (result) {
                System.out.println("恭喜你小舔狗，你登陆成功了");
                break;

            } else {
                System.out.println("登陆失败，用户名或者密码错误");
                if (i == 2) {
                    System.out.println("current username" + username + "is locked, please contact administer : xxxxxxxx  ");

                } else {
                    System.out.println("用户名或者密码错误，你还剩下+" + (2 - i) + "次机会");
                }
            }


        }


    }

    private static boolean checkuserinfo(ArrayList<User> list, User userinfo) {
        //遍历集合，如何userinfo存在list里，就成功，否则失败
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            /*if (user.equals(userinfo)){
                return true;
            }*/
            //上面这不行，因为参数都有，只不过后面两个参数是null，list里面的user后面两个参数不是null
            if (user.getUsername().equals(userinfo.getUsername()) && user.getPassword().equals(userinfo.getPassword())) {
                return true;
            }

        }
        return false;
    }

    private static void signin(ArrayList<User> list) {
        User u = new User();
        System.out.println("sign in");
        //用户名，密码，身份证号码和手机密码放到用户对象里面去
        //把用户对象加到集合里
        //先用键盘录入用户名
        Scanner sc = new Scanner(System.in);
        //设置用户名
        while (true) {
            System.out.println("tell me your fking username bitch");
            String username = sc.next();
            //用户名唯一，长度在3-15位，只能是字母和数字的组合，但是不能是纯数字
            boolean flag1 = Checkedusername(username);
            /*  boolean flag2 = contains(list, username);*/
            if (!flag1) {
                // System.out.println("用户名满足条件，继续检查用户名是否唯一");
               /* if (flag2==false){
                    System.out.println("用户名已经存在");

                }else {
                    System.out.println("用户名"+username+"可用！");
                }*/

                System.out.println("用户不满足条件,重新输入");
                continue;

            }
            //检查用户名的唯一性wo
            boolean flag2 = contains(list, username);
            if (flag2) {
                System.out.println("用户名已经存在");

            } else {
                System.out.println("用户名" + username + "可用！");
                u.setUsername(username);
                break;


            }
        }

        //2.键盘输入密码，注册密码，两次密码必须完全一样
        while (true) {
            System.out.println("请输入您的舔狗注册密码");
            //Scanner sc = new Scanner(System.in);
            String passcode = sc.next();
            System.out.println("请在此输入您的舔狗密码");
            String passcodeagain = sc.next();
            if (passcodeagain.equals(passcode)) {
                System.out.println("密码可用，注册成功，恭喜你成为一名臭舔狗");
                u.setPassword(passcodeagain);
                break;
            } else {

                System.out.println("两次密码不一致，loser");
                continue;
            }
        }

        //3.键盘录入身份证号码
        /*长度为18
                不能0开头
                前17位必须都是数字
                        最后一位可以是数字也可以是大写x或者小写x*/
        while (true) {
            System.out.println("请录入你的狗证号码");
            String dogid = sc.next();
            boolean flag = Checkdogid(dogid);
            if (flag) {
                System.out.println("狗证号码录入成功，小舔狗");
                u.setPersonalid(dogid);
                break;

            } else {
                System.out.println("狗证有误，请重新录入");
                continue;

            }
            //4.验证手机号码

        }
        while (true) {
            System.out.println("请输入你的爪机号码");
            String phonenum = sc.next();

            boolean flag = Checkphonenum(phonenum);
            if (flag) {
                System.out.println("your pawphonenumber is correct, u sucker");
                u.setPhonenumber(phonenum);
                System.out.println("Congratulations! u sucker");

                break;

            } else {
                System.out.println("pawnumber is wrong, sillyb");
                continue;

            }
        }
        //用户名，密码，身份证号码和手机密码放到用户对象里面去
        //把用户对象加到集合里

        list.add(u);
        //这里还有一种添加user的方法， 不是用u.setxxxx,而是用标准的 User u = new User(username, passcode, phonenum,dogid )的方式，但是你的传入变量
        //也就是username, passcode, phonenum,dogid 必须定义为全局变量，不可以事局部变量，也就是不可以是在while循环里面

        //写一个遍历集合的方法
        printlist(list);


    }

    private static void printlist(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(user.getUsername() + ',' + user.getPassword() + ',' + user.getPersonalid() + ',' + user.getPhonenumber());

        }
    }

    private static boolean Checkphonenum(String phinenum) {
        //长度为11
        if (phinenum.length() != 11) return false;
        //不能0开头
        if (phinenum.startsWith("0")) return false;
        //must be int for phine number
        for (int i = 0; i < phinenum.length(); i++) {
            char c = phinenum.charAt(i);

            if (!(c >= '0' && c <= '9'))
                return false;


        }
        return true;


    }

    private static boolean Checkdogid(String dogid) {

        //3.键盘录入身份证号码
        /*长度为18


                不能0开头
                前17位必须都是数字
                        最后一位可以是数字也可以是大写x或者小写x*/
        if (dogid.length() != 18)
            return false;
        //不可以是0开头，2种写法
        // char c = dogid.charAt(0);
        boolean flag = dogid.startsWith("0");
        if (flag)
            return false;
        for (int i = 0; i < dogid.length() - 1; i++) {
            char c = dogid.charAt(i);
            if ((c > '9' || c < '0'))
                return false;


        }
        char endchar = dogid.charAt(dogid.length() - 1);
        if ((endchar >= '0' && endchar <= '9') || (endchar == 'x' || endchar == 'X'))
            return true;
        else
            return false;


    }

    private static boolean contains(ArrayList<User> list, String username) {
        //循环遍历得到list里每一个对象，在拿出用户名中的对象作比较
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String rightusername = user.getUsername();
            if (rightusername.equals(username)) {
                return true;
            }

        }
        return false;
    }

    private static boolean Checkedusername(String username) {
        //首先判断长度
        int length = username.length();
        if (length < 3 || length > 15) {
            return false;

        }
        //长度是合适的

        //我需要他们只能是数字和字母的组合，不能出现其他符号
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }

        }//到这里我的用户名还差不能全是数字
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }

    private static String getcode() {
        //1添加一个集合创建所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));


        }
        StringBuilder sb = new StringBuilder();

        //  sb.append(list);
        // randomly extract 4 letters
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //获取随机索引
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);

        }
        // add a random number at the end
        int number = r.nextInt(10);
        sb.append(number);
        //System.out.println(sb);

        //修改字符串中的内容

        // 先把字符串转换为char数组，然后在数组里修改，然后在转陈该字符串

        char[] arr = sb.toString().toCharArray();
        // 设置一个临时变量,shi 一个随机的索引（因为你可以i改变字符串中任意位置的字母或者数字）
        int randomindex = r.nextInt(arr.length);
        char temp = arr[randomindex];
        arr[randomindex] = arr[arr.length - 1]; // 这一行是随机索引指向的值等于最后一个值
        // System.out.println(arr[arr.length-1]);
        arr[arr.length - 1] = temp;
        // System.out.println(arr);


        return new String(arr);
    }


    private static void forgetpassword(ArrayList<User> list) {
        System.out.println("forget my password");
        Scanner sc = new Scanner(System.in);
        System.out.println("type your username");
        String username = sc.next();
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("current user " + username + " is not registered !");
            return;
        }

        //键盘录入身份证号和手机号
        System.out.println("what is your dogid?");
        String dogid = sc.next();
        System.out.println("what's your phone number?");
        String phonenum = sc.next();
        //——————————————————————————————需要把用户对象先从list里拿出来在做比较——————————————————————//
        int index = findindex(list,username);
        User user = list.get(index);
        if (!user.getPhonenumber().equals(phonenum)&& user.getPersonalid().equals(dogid)){
            System.out.println("phone number or dog id is wrong, you can't modify passcode!");
            return;
        }
        //当代码到这里表示输入的信息全部符合，可以修改代码
        String newpasscode;
        while (true){
            System.out.println("what's your new passcode?");
            newpasscode = sc.next();
            System.out.println("please confirm your new passcode !");
            String passcodeagain = sc.next();
            if (passcodeagain.equals(newpasscode)){
                System.out.println("they are identical, good job! ");
                break;
            }else {
                System.out.println("your two new passcode are not the same, plz set the again");
                continue;
            }
        }

        //modify the passcode
        user.setPassword(newpasscode);
        System.out.println(" congrats, your passcode modified successfully");







    }

    private static int findindex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);

            if (user.getUsername().equals(username))



                return i;


        }
        return -1;
    }

}



