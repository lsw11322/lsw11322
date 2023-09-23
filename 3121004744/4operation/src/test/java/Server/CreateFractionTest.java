package Server;

import org.junit.Test;

import java.util.Random;

/**
 * 分数生成类测试
 */
public class CreateFractionTest {
    CreateFraction createFraction = new CreateFraction();

    /**
     * 分数式子及其答案生成测试
     */
    @Test
    public void createProblemTest(){
        String[] str = createFraction.createProblem(10);
        System.out.println(str[0]);
        System.out.println(str[1]);
    }

    /**
     * 求最大公因数测试
     */
    @Test
    public void greatFractionTest(){
        int result = createFraction.greatFraction(666,66);
        System.out.println(666 + "和" + 66 + "的最大公因数是" + result);
    }

    /**
     * 互质数生成测试
     */
    @Test
    public void createCoprimeNumbersTest(){
        Random random = new Random();
        int[] nums = createFraction.createCoprimeNumbers(10, random);
        int num1 = nums[0];
        int num2 = nums[1];
        int result = createFraction.greatFraction(num1,num2);
        if(result == 1){
            System.out.println(num1 + "和" + num2 + "的最大公因数是1，两数为互质数");
        }else{
            System.out.println("该方法出现异常");
        }
    }

    /**
     * 假分数转化为真分数测试
     */
    @Test
    public void shamToProperFractionTest(){
        String str = createFraction.shamToProperFraction(3,2);
        System.out.println("3/2的真分数形式是" + str);
    }
}