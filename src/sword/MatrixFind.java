package sword;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/02/22 20:58
 **/
public class MatrixFind {
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},
                       {2,4,9,12},
                       {4,7,10,13},
                       {6,8,11,15}};
        System.out.println(find(7,arr));
    }

    public static boolean find(int target, int[][] array) {

        int i = 0;
        int j = array[0].length - 1;

        while (i <= array.length - 1 && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }

        return false;

    }
}
