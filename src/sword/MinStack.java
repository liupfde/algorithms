package sword;

import java.util.Stack;

/**
 * @author :liupf
 * @description :TODO
 * @date :2019/02/28 11:38
 **/
public class MinStack {
    public static void main(String[] args) {

    }
    Stack<Integer> minStack = new Stack<>();
    Integer[] array = new Integer[16];
    int size = 0;
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        if (size == array.length) {
            resize(2*array.length);
        }
        if (node <= min) {
            minStack.push(node);
            min = minStack.peek();
        } else {
            minStack.push(min);
        }
        array[size] = node;
        size++;
    }

    public void pop() {
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
    }

    public int top() {
        return array[0];
    }

    public int min() {
        return min;
    }

    private void resize(int newCapacity) {
        Integer[] newArray = new Integer[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
