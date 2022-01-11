import org.junit.Test;

public class HeapSort {
    @Test
    public void test() {
        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        buildMaxHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for (int i = arr.length; i > 0; ) {
            swap(arr, 0, --i);
            adjustHeap(arr, 0, i);
        }
        for (int e :
                arr) {
            System.out.print(e + " ");
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

    private void buildMaxHeap(int[] arr) {
        int parentIndex = arr.length / 2 - 1;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if (arr[parentIndex] < arr[leftChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
        }
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
        if ((rightChildIndex <= arr.length - 1) && (arr[parentIndex] > arr[leftChildIndex]) && (arr[parentIndex] > arr[rightChildIndex]))
            return;
        if (leftChildIndex > arr.length - 1) return;
        if (arr[leftChildIndex] > arr[rightChildIndex]) {
            swap(arr, parentIndex, leftChildIndex);
            heaplify(arr, leftChildIndex);
        } else {
            swap(arr, parentIndex, rightChildIndex);
            heaplify(arr, rightChildIndex);
        }

    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}