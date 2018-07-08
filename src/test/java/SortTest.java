import com.pctf.Utils;
import com.pctf.algorithm.sort.BubbleSorter;
import com.pctf.algorithm.sort.InsertionSort;
import com.pctf.algorithm.sort.Sorter;
import org.junit.Test;

import java.util.Random;

public class SortTest {


    @Test
    public void BubbleSortTest(){
        //Sorter sorter = new BubbleSorter();
        Sorter sorter = new InsertionSort();
        Integer[] testArray = Utils.createTestArray(10000);
        Utils.printArray(testArray);
        sorter.sort(testArray);
        Utils.printArray(testArray);
    }
}
