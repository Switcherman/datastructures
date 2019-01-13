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

    @Test
    public void movingCountSolutionTest() {
        MovingCountSolution solution = new MovingCountSolution();
        int result = solution.movingCount(15, 20, 20);
        System.out.println(result);
       // System.out.println(solution.couldArrive(15, 7, 8));
    }

    @Test
    public void hasPathTest() {
        char[] matrix = new char[] {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        //char[] str = new char[]{'b','c','c','e','d'};
        char[] str = new char[]{'a','b','c','d'};
        HasPathSolution solution = new HasPathSolution();
        System.out.println(solution.hasPath(matrix, 3, 4, str));
    }

    @Test
    public void matchTest() {
        String str = "";
        String match = ".*";
        System.out.println(new MatchSolution().match(str.toCharArray(), match.toCharArray()));
    }


}
