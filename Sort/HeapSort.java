import org.junit.Test;

public class HeapSort {
    @Test
    public void buildMaxHeapTest() {
        //0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1
        int[] arr = new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0,5,2,16,12};
        buildMaxHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for (int i = arr.length; i > 0; ) {
            swap(arr, 0, --i);
            adjustHeap(arr, 0, i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    @Test
    public void test1() {
        int[] arr = new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
        buildMaxHeap(arr);
        for (int i = arr.length; i > 0;) {
            swap(arr, 0, --i);
            adjustHeap(arr, 0, i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void arrayTest() {
        int[] arr = new int[]{};
        System.out.println(arr.length);
    }

    private void buildMaxHeap(int[] arr) {
        int parentIndex = arr.length / 2 - 1;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if (arr.length == 0) return;
        if (arr[parentIndex] < arr[leftChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
        }
        //如果右孩子存在
        if (rightChildIndex == arr.length - 1) {
            if (arr[parentIndex] < arr[rightChildIndex]) {
                swap(arr, parentIndex, rightChildIndex);
            }
        }
        //该父节点与左孩子或者右孩子交换值以后，换值以后的孩子节点需要满足最大堆的性质，继续往下进行比较，
        while (parentIndex >= 1) {
            parentIndex = parentIndex - 1;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            //难道父节点的值，一定比子节点的值小吗？
            if ((arr[parentIndex] < arr[leftChildIndex]) && (arr[leftChildIndex] >= arr[rightChildIndex])) {
                swap(arr, parentIndex, leftChildIndex);
                heaplify(arr, leftChildIndex);

            } else if (arr[parentIndex] < arr[rightChildIndex] && (arr[rightChildIndex] >= arr[leftChildIndex])) {
                swap(arr, parentIndex, rightChildIndex);
                heaplify(arr, rightChildIndex);
            }

        }
    }

    private void heaplify(int[] arr, int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        //考虑父节点大于左右孩子节点的值的情况
        if ((rightChildIndex <= arr.length - 1)
                && (arr[parentIndex] > arr[leftChildIndex])
                && (arr[parentIndex] > arr[rightChildIndex]))
            return;
        //考虑父节点没有子孩子的情况
        if (leftChildIndex > arr.length - 1) return;

        //考虑父节点只有左孩子和有左右孩子的情况
        if (leftChildIndex == arr.length - 1 && arr[parentIndex] < arr[leftChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
            heaplify(arr, leftChildIndex);

        } else if (rightChildIndex <= arr.length - 1 && arr[leftChildIndex] > arr[rightChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
            heaplify(arr, leftChildIndex);

        } else if (rightChildIndex <= arr.length - 1 && arr[leftChildIndex] < arr[rightChildIndex]) {
            swap(arr, parentIndex, rightChildIndex);
            heaplify(arr, rightChildIndex);
        }

    }

    //堆顶与左右两边一边值大的孩子，进行置换就ok，互换后，该孩子节点需要与它的孩子节点比较，确保满足最大堆的性质
    //
    private void adjustHeap(int[] arr, int topNodeIndex, int length) {
        int parentIndex = topNodeIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if (leftChildIndex > length - 1)
            return;

        if (leftChildIndex != length - 1) {
            if (arr[leftChildIndex] > arr[rightChildIndex]) {//此处的堆顶节点的值，一定小于左右孩子节点的值，因此，一定发生互换
                swap(arr, parentIndex, leftChildIndex);
                adjustHeap(arr, leftChildIndex, length);
            } else {
                swap(arr, parentIndex, rightChildIndex);
                adjustHeap(arr, rightChildIndex, length);
            }
        } else {
            if (arr[parentIndex] < arr[leftChildIndex])
                swap(arr, parentIndex, leftChildIndex);
        }

    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}