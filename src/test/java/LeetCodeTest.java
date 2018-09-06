import com.pctf.leetcode.ThreeSumClosestSolution;
import com.pctf.leetcode.ThreeSumSolution;
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
}
