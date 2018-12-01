package heapsort;

/**
 * @author :liupf
 * @description :最大堆  使用数组实现
 *   定义:
 *     1、必须是一棵完全二叉树
 *     2、任何一个结点的值都不大于它的父节点
 * @date :2018/11/04 20:39
 **/
public class MaxHeap {

    /**
     * 数组容量
     */
    private int[] data;
    /**
     * 数组实际大小
     */
    private int count;

    public MaxHeap(int capacity){

        data = new int[capacity+1];
        count = 0;
    }

    /**
     * 通过构造函数直接构造堆
     * @param arr
     * @param n
     */
    public MaxHeap(int[] arr,int n){
        data = new int[n+1];
        for(int i = 0;i<n;i++){
            data[i] = arr[i];
        }
        count = n;
        //对于一棵完全二叉树,第一个非叶子结点就是 当前结点个数/2
        for (int i=count/2; i>=1; i--){
            siftDown(i);
        }
    }

    public int getSize(){
        return this.count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void insert(int e){
        if(count == data.length){
            resize(2*data.length);
        }
        data[count+1] = e;
        count++;
        siftUp(count);
    }

    public int extractMax(){
        if(count<0){
            throw new RuntimeException("数组容量错误");
        }
        int i = data[1];
        int temp = data[1];
        data[1] = data[count];
        data[count] = temp;
        count--;

        siftDown(1);

        return i;
    }

    /**
     * 判断新插入的结点是否符合当前定义(比父节点大)
     * 若不符合 则上移
     * @param k
     */
    private void siftUp(int k){
        while (k>1&&data[k]>data[k/2]){
            int temp;
            temp = data[k];
            data[k] = data[k/2];
            data[k/2] = temp;
            k /= 2;
        }
    }

    private void siftDown(int k){
        //当前k这个结点应该有孩子 在一个完全二叉树中 只要有左孩子就一定有孩子
        while(2*k <= count){
            //j表示当前的父节点要与孩子交换的孩子结点
            int j = 2*k;
            //如果右孩子存在且右孩子比左孩子大
            if(j+1 <= count && data[j+1] > data[j]){
                //让j等于右孩子
                j += 1;
            }
            if(data[k] > data[j]){
                break;
            }

            int temp = data[k];
            data[k] = data[j];
            data[j] = temp;
            //向下移动索引位置
            k = j;
        }
    }

    private void resize(int newCapacity){
        int[] newData = new int[newCapacity];
        for (int i = 0;i<data.length;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
