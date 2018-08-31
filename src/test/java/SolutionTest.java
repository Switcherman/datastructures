import com.pctf.algorithm.swardtooffer.*;
import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {
    @Test
    public void findContinuousSequenceSolutionTest() {
        int sum = 9;
        ArrayList<ArrayList<Integer>> list = new FindContinuousSequenceSolution().FindContinuousSequence(sum);
        System.out.println(list);
    }

    @Test
    public void reverseSentenceSolutionTest() {
        System.out.println(new ReverseSentenceSolution().ReverseSentence(" "));
    }

    @Test
    public void strToIntTest() {
        System.out.println(new StrToIntSolution().StrToInt("-1a312315"));
    }

    @Test
    public void getMedianSolutionTest() {
        GetMedianSolution solution = new GetMedianSolution();
        for(int i = 1; i < 6; i++) {
            solution.Insert(i);
        }
        System.out.println(solution.GetMedian());
    }

    @Test
    public void maxInWindowsSolution() {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(new MaxInWindowsSolution().maxInWindows(num, 3));
    }
}
