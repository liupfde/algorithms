package acm;

/**
 * @author :liupf
 * @description :TODO
 * @date :2018/11/11 15:17
 **/
public class Main {
    public static void main(String[] args) {
        String str;
        for (int i = 0; i < 1000; i++){
            str = i+"";
            if (str.contains("7") && i%7 == 0){
                System.out.println(i);
            }
        }
    }
}
