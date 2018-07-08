import com.pctf.Utils;
import com.pctf.datastructures.heap.BinaryHeap;
import com.pctf.datastructures.heap.MyHeap;
import org.junit.Test;

import java.util.Random;

public class HeapTest {



    @Test
    public void BinaryHeapTest() {
        Integer[] testArray = Utils.createTestArray(100);
        MyHeap<Integer> heap = new BinaryHeap<Integer>();
        System.out.println("二叉堆是否为空: " + heap.isEmpty());
        for(int i = 0; i < testArray.length; i++) {
            heap.insert(testArray[i]);
        }
        while(!heap.isEmpty()){
            System.out.println("二叉堆的最小值为:" + heap.findMin());
            heap.deleteMin();
        }
        Utils.printArray(testArray);
    }
}
