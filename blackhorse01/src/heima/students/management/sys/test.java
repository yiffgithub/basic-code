package heima.students.management.sys;

import java.util.ArrayList;
import java.util.Random;

public class test {


    public static void main(String[] args) {
        getcode();

    }

    private static String getcode() {
        //1添加一个集合创建所有的大写和小写字母
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+ i));
            list.add((char)('A'+ i));



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

        char [] arr = sb.toString().toCharArray();
       // 设置一个临时变量,shi 一个随机的索引（因为你可以i改变字符串中任意位置的字母或者数字）
        int randomindex = r.nextInt(arr.length);
        char temp = arr[randomindex];
        arr[randomindex] = arr[arr.length-1]; // 这一行是随机索引指向的值等于最后一个值
       // System.out.println(arr[arr.length-1]);
        arr[arr.length-1]= temp;
        System.out.println("生成的随机验证码为：");
        System.out.println(arr);


        return new String(arr);
    }
}
