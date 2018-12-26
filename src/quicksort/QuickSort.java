package quicksort;

import java.util.Arrays;


/**
 * @author liupfde
 */
public class QuickSort {
    /**
     *对于枢纽值的选取 使用随机算法选取整个数组的随机值 避免快速排序算法退化为O(n^2)级别的算法
     * 但枢纽值必须位于数组的第一个位置
     */
    public static void main(String[] args){
        int[] arr = {20,15,14,18,21,36,40,10};
        int[] arr1 = {20,15,14,18,21,36,40,10};

        //选取随机枢纽值
//        int rand = (int)(Math.random()*arr1.length);
//        int temp = arr1[rand];
//        arr1[rand] = arr1[0];
//        arr1[0] = temp;

        quickSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * @param arr
     * 对arr[l...r] 前闭后闭的区间进行排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        //在此可使用插入排序优化
        if (l >= r) {
            return;
        }
        int partition = __quickSort(arr, l, r);

        quickSort(arr, l, partition - 1);
        quickSort(arr, partition + 1, r);

        //三路快排的partition并不是一个  不方便返回 直接在函数内递归处理
        //__quickSort3Ways(arr,l,r);
    }

    /**
     * 存在的问题: 排序时 在近乎有序的数组下可能造成左右子树的不平衡
     *           极端情况下可能造成某一端的子树高度为n,每一次排序的时间复杂度为O(n),
     *           这样总的时间复杂度就会退化为O(n^2)
     *            解决办法:随机选择枢纽值
     * 返回p 使得arr[l...p-1]<arr[p] arr[p+1...r]>arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int __quickSort(int[] arr,int l,int r){
        //arr[l+1...j]<v  arr[j+1...r)>v r为当前正在指向的元素
        //已经是随机元素
        int v = arr[l];
        //一开始相当于左边的区间为空
        int j = l;
        //一开始相当于右边的区间为空
        /**
         * j相当于大于和小于的分界点
         * 1、当i大于v时  则直接在右边部分i++就行了
         * 2、当i小于v时  则当前元素要和大于v部分的第一个元素交换位置即 i与 j++交换位置
         * 最后arr[l]和小于v部分的最后一个元素交换位置
         *    并不需要考虑小于v部分的最后一个元素是不是最小的
         *    在以后的递归过程中会一部分一部分的解决 最终 每一部分最后一步交换到第一个位置的元素一定是最小的
         */
        for(int i = l+1;i<=r;i++){
            if(arr[i]<v){
                int temp = arr[j+1];
                arr[j+1] = arr[i];
                arr[i] = temp;
                j++;
                //以上两行代码可以合并为swap(arr[++j],arr[i])
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }
    /**
     * 在有大量重复的值的时候,未经过优化的快速排序容易退化为O(n^2)级别的算法 所以进行优化-->
     * 把区间用i和j分成两段  而不在一端进行判断  中间的就是重复的元素
     *
     * 这种方式是两边扫描 与三路快排的排序思想不一样 所以 j=l+1 而不是j=l
     * 三路快排那种和最原始的排序方式有点相似  不过他是分成了三部分 而不是从一端判断
     */
    private static int __fasterSort(int[] arr,int l,int r){
        //待排序数组的第一个元素
        int v = arr[l];
        //数组排序时左边的第一个元素 它的范围是arr[l+1...j-1]
        int j = l+1;
        //数组从右边扫描时的第一个元素 它的范围是arr[i...r]
        int i = r;
        while (true){
            while (j<=r&&arr[j]<v){
                j++;
            }
            while (i>=l+1&&arr[i]>v){
                i--;
            }
            if(j>i){
                break;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
            i--;
        }
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;
        return i;
    }

    /**
     * 三路快排
     * 分成三部分  小于v 等于v 大于v
     *
     * 1、如果当前元素==v  直接当前元素i++
     * 2、如果当前元素<v   则当前元素与等于v部分的第一个元素交换(i与lt+1)
     *    这样就相当于当前元素到了小于v的最后一个元素
     * 3、如果当前的元素大于v 则当前的元素和大于v部分的第一个元素的前一个元素交换位置
     *    这样当前元素就成为大于v部分的第一个元素
     *    而i指向的当前元素则是换过来的未知元素  所以i指针并不需要移动 还是在原地  因为他还要处理该未知元素
     *
     * 在有大量重复数据的时候  三路快排优势明显高于上边的快排及归并
     * 当元素重复量较少时 三路快排稍慢于上边的快排  但性能也是可以的
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void  __quickSort3Ways(int[] arr,int l,int r){

        //枢纽值
        int v = arr[l];
        //小于v的部分的第一个索引 一开始为空    arr[l+1...lt]<v
        int lt = l;
        //大于v的索引  一开始为空 arr[gt...r]>v
        int gt = r+1;
        //arr[lt+1...i)==v  是正在考察的元素 不在数组内
        int i = l+1;
        while (i<gt){
            if (arr[i] < v) {
                int temp = arr[lt + 1];
                arr[lt + 1] = arr[i];
                arr[i] = temp;
                i++;
                lt++;
            } else if (arr[i] > v) {
                int temp = arr[i];
                arr[i] = arr[gt - 1];
                arr[gt - 1] = temp;
                gt--;
            } else {
                //当前值等于v
                i++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[lt];
        arr[lt] = temp;
        //partition并不是唯一的所以在本方法中递归调用
        __quickSort3Ways(arr,l,lt-1);
        __quickSort3Ways(arr,gt,r);
    }
}
