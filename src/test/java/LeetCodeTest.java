import com.pctf.leetcode.CombinationSumSolution;
import com.pctf.leetcode.NextPermutationSolution;
import com.pctf.leetcode.ThreeSumClosestSolution;
import com.pctf.leetcode.ThreeSumSolution;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

public class LeetCodeTest {

    @Test
    public void threeSumTest() {
        int[] arr = new int[]{1,2,-2,-1};
        System.out.println(new ThreeSumSolution().threeSum(arr));
    }

    @Test
    public void threeSumClosetTest() {
        int[] arr = new int[]{-3,-2,-5,3,-4};
        int target = -1;
        System.out.println(new ThreeSumClosestSolution().threeSumClosest(arr, target));
    }

    @Test
    public void NextPermutationSolutionTest() {
        int[] arr = {1, 1};
        new NextPermutationSolution().nextPermutation(arr);
        System.out.println(arr);
    }

    @Test
    public void combinationSumTest() {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSumSolution().combinationSum(arr, target));
    }
}
