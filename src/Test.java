import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :liupf
 * @description :TODO
 * @date :2018/10/27 16:58
 **/
public class Test {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个矩阵的行数！");
        int m=sc.nextInt();
        System.out.println("请输入第一个矩阵的列数以及第二个矩阵的行数！");
        int s=sc.nextInt();
        System.out.println("请输入第二个矩阵的列数！");
        int n=sc.nextInt();

        int [][]firstMartrix;
        int [][]secondMartrix = new int [s][n];
        int [][]thirdMartrix = new int[m][n];

        InputMatrix im=new InputMatrix();
        System.out.println("请输入第一个矩阵！");
        firstMartrix=im.input(m,s);
        System.out.println(Arrays.deepToString(firstMartrix));






        int[] arr = {2,1,3,4,6,5,7,8,9,10,11};
        bubbleSort(arr);
        //System.out.printf(Arrays.toString(arr));

        //int a = input(5,6);
        //System.out.println(a);
    }

    public static void bubbleSort(int[] arr){
        boolean flag = true;
        for(int i = 0;i<arr.length&&flag;i++){
            flag = false;
            //只需要交换到i的位置  因为i之前的位置一定都是排好序的
            for(int j = arr.length-2;j>=i;j--){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }
    }

    public static int input(int x,int y){
        int[][] matrix = new int[x][y];
        Scanner scanner = new Scanner(System.in);
        for(int a=0;a<x;a++){
            for (int b = 0;b<y;b++){
                matrix[x-1][y] = scanner.nextInt();
            }
        }
        return matrix[x-1][y];
    }
}

class InputMatrix {
    public int[][] input(int x,int y){
        int[][] matrix= new int [x][y];
        Scanner sc=new Scanner(System.in);
        for (int a=0;a < x;a++){
            for (int b=0;b < y;b++){
                matrix[a][b]=sc.nextInt();
            }
        }
        return matrix;
    }
}