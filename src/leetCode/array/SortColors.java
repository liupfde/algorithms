package leetCode.array;

/**
 * leetCode第75号题目
 */
public class SortColors {
    public static void main(String args[]){
        int arr[] = {0,0,1,0,2,1,2,2,0,1,1,2,0,1};
        sortColors(arr);
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }

    public static void sortColors(int arr[]){

        if(arr.length==0||arr==null){
            return;
        }

        int j = 0,k = 0,l = 0;

        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                j++;
            }
            if(arr[i] == 1){
                k++;
            }
            if(arr[i] == 2){
                l++;
            }

        }

        int index = 0;
        for(int i = 0;i<j;i++){
            arr[index++] = 0;
        }
        for(int i = 0;i<k;i++){
            arr[index++] = 1;
        }
        for(int i = 0;i<l;i++){
            arr[index++] = 2;
        }
        /*for(int i = 0;i<j;i++){
            arr[i] = 0;
        }
        for(int m = j;m<k+j;m++){
            arr[m] = 1;
        }
        for(int n = k+j;n<arr.length;n++){
            arr[n] = 2;
        }*/
    }
}
