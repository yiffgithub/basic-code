import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class jubenshapaixu {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("小红", "小蓝", "小粉", "小紫");

        while (true) {
            Collections.shuffle(list);

            if (checkOrder(list)) {
                break;
            }
        }

        System.out.println(list);
    }

    public static boolean checkOrder(List<String> list) {
        int redIndex = list.indexOf("小红");
        int blueIndex = list.indexOf("小蓝");
        int pinkIndex = list.indexOf("小粉");
        int purpleIndex = list.indexOf("小紫");

        if (blueIndex < redIndex && pinkIndex < purpleIndex && purpleIndex < redIndex) {
            return true;
        } else {
            return false;
        }
    }
}
//上传到github
