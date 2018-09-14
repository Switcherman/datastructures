import com.pctf.leetcode.*;
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

    @Test
    public void searchMatrixTest() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(new SearchMatrixSolution().searchMatrix(matrix, 100));
    }

    @Test
    public void existTest() {
        char[][] matrix = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String s = "AE";
        System.out.println(new ExistSolution().exist(matrix, s));
    }

    @Test
    public void duplicateTest() {
        int[] nums = {1,1,1,2,2,3};
        new RemoveDuplicatesSolution().removeDuplicates(nums);
    }
}
