import com.pctf.Utils;
import com.pctf.algorithm.sort.BubbleSorter;
import com.pctf.algorithm.sort.InsertionSort;
import com.pctf.algorithm.sort.ShellSorter;
import com.pctf.algorithm.sort.Sorter;
import org.junit.Test;

import java.util.*;

/**
 *  10W级数据的测试结果
 *  希尔耗时70ms
 * 冒泡耗时16533ms
 * 插入耗时35252ms
 *
 * 百万级数据
 * 希尔耗时1210ms
 * JDK自带排序耗时:230ms
 * 那两个CPU占用100%.电脑发烫,放弃了
 *
 */
public class SortTest {


    @Test
    public void BubbleSortTest(){
        Sorter sorter;
        Integer[] testArray = Utils.createTestArray(1000000);
       // Utils.printArray(testArray);
        long startTime = System.currentTimeMillis();



        Integer[] copy2 = testArray.clone();
        startTime = System.currentTimeMillis();
        sorter = new ShellSorter();
        sorter.sort(copy2);
        System.out.println("希尔耗时" +( System.currentTimeMillis() - startTime )+ "ms");
       // Utils.printArray(copy2);


        List<Integer> list = new ArrayList<>(1000000);
        Collections.addAll(list, testArray.clone());
        startTime = System.currentTimeMillis();
        Collections.sort(list);
        System.out.println("JDK自带排序耗时:" +( System.currentTimeMillis() - startTime )+ "ms");


        Integer[] copy1 = testArray.clone();
        sorter = new BubbleSorter();
        sorter.sort(copy1);
        System.out.println("冒泡耗时" +( System.currentTimeMillis() - startTime )+ "ms");
        // Utils.printArray(copy1);

        Integer[] copy3 = testArray.clone();
        sorter = new InsertionSort();
        sorter.sort(copy3);
        System.out.println("插入耗时" +( System.currentTimeMillis() - startTime )+ "ms");
        // Utils.printArray(copy1);
    }
}
