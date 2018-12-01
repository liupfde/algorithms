package binarySearch;

public class BinarySearch {

    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        int i = binarySearch(arr,0,arr.length,6);
        System.out.println(i);
    }

    /**
     * @param arr
     * @param target
     * 在[l...r]的范围中查找
     * @return
     */
    public static int binarySearch(int arr[],int low,int high,int target){
        int r = high-1;
        while(low<=r){//当l=r时,区间[l...r]依然是有效的
            int mid = low+(r-low)/2;//避免整型溢出
            if(target==arr[mid]){
                return mid;
            }else if(target>arr[mid]){
                low = mid+1;
                binarySearch(arr,low,high,target);
            }else if(target<arr[mid]){
                r = mid-1;
                binarySearch(arr,low,r,target);
            }else {
                return 0;
            }
        }
        return 0;
    }
}
