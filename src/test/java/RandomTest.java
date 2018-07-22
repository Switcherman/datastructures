import com.pctf.algorithm.skills.Random;
import com.pctf.algorithm.skills.Random48;
import org.junit.Test;

public class RandomTest {

    @Test
    public void randomTest() {
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            System.out.print(random.randomBetween1() + "\t");
        }
        System.out.println("======");
        Random48 random48 = new Random48();
        for(int i = 0; i < 100; i++) {
            System.out.print(random48.randomBetween0And1() + "\t");
        }

    }
}
