package org.jerold.sort;

/**
 * Created by Jerold on 2017/4/12.
 */
public class HeapSort {
    private int[] heap;

    public HeapSort(int[] src) {
        this.heap = src;
    }

    public void buildHeap() {
        int[] tmpHeap = new int[heap.length];
        int size = 0;
        for (int i = 0; i < heap.length; i++) {
            int tmp = size;
            int parent = 0;
            while ((parent = (tmp - 1) / 2) >= 0 && tmp > parent) {
                if (tmpHeap[parent] > heap[i]) {
                    tmpHeap[tmp] = tmpHeap[parent];
                    tmp = parent;
                } else {
                    break;
                }
            }
            tmpHeap[tmp] = heap[i];
            size++;
        }
        System.arraycopy(tmpHeap, 0, heap, 0, tmpHeap.length);
        for (int i : heap) {
            System.out.print(i + ", ");
        }
    }

    public void heapSort() {
        int size = heap.length - 1;
        while (size >= 0) {
            int tmp = heap[size];
            heap[size] = heap[0];
            int pos = 0;
            int leftChild;
            int rightChild;
            while ((leftChild = (2 * pos + 1)) < size && (rightChild = 2 * pos + 2) < size) {
                if (heap[leftChild] < heap[rightChild]) {
                    heap[pos] = heap[leftChild];
                    pos = leftChild;
                } else {
                    heap[pos] = heap[rightChild];
                    pos = rightChild;
                }
            }
            if (leftChild < size) {
                heap[pos] = heap[leftChild];
                pos = leftChild;
            }
            heap[pos] = tmp;
            size--;
        }
        for (int i : heap) {
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        int[] src = new int[]{3, 5, 2, 1, 7, 6, 9, 8};
        HeapSort hs = new HeapSort(src);
        hs.buildHeap();
        System.out.println();
        hs.heapSort();
    }
}
