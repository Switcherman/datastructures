import com.pctf.algorithm.swardtooffer.FindContinuousSequenceSolution;
import com.pctf.algorithm.swardtooffer.ReverseSentenceSolution;
import com.pctf.algorithm.swardtooffer.StrToIntSolution;
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
}
