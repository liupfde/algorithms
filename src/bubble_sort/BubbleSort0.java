package bubble_sort;


/**
 * 冒泡排序的最初级写法
 * 交换排序
 * 不断的比较
 * @author liupfde
 */
public class BubbleSort0 {
    public static void main(String args[]){
        int b[] = {23,12,43,4,5,33,3,6,6,24,20,909,76,1080,1024};
        bubbleSort0(b);
    }

    public static void bubbleSort0(int b[]){
        for (int i = 0;i<b.length;i++){
            for(int j = i+1;j<b.length;j++){
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                    for (int m:b) {
                        System.out.print(m+" ");
                    }
                    System.out.println("--------------");
                }
            }
        }
    }
}
