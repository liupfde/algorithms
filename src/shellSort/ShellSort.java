package shellSort;

public class ShellSort {
    public static void main(String args[]) {
        int a[] = {1, 23, 4, 5, 76, 34, 2, 2, 2, 13, 78};
        shellSort(a);
    }

    public static void shellSort(int a[]) {
        int increment = a.length;   //增量序列
        do {
            increment = increment / 3 + 1;//具体情况视数据的长度而定
            for (int i = increment + 1; i < a.length; i++) {
                if (a[i] < a[i - increment]) {
                    /*将a[i]插入有序增量子表*/
                    a[0] = a[i];
                    int j;
                    for (j = i - increment; j > 0 && a[0] < a[j]; j -= increment) {
                        a[j + increment] = a[j];
                    }
                    a[j + increment] = a[0];
                }
            }
            for (int r : a) {
                System.out.print(r + " ");
            }
            System.out.println("");
        } while (increment > 1);

    }
}