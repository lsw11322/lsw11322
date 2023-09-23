package Server;

import org.junit.Test;

import java.util.Random;

/**
 *  整数生成类测试
 */
public class CreateIntegerTest  {
    CreateInteger createInteger = new CreateInteger();

    //整数运算问题及答案生成测试
    @Test
    public void createProblemTest(){
        String[] str = createInteger.createProblem(10);
        System.out.println(str[0]);
        System.out.println(str[1]);
    }

    //运算符种类及算式拼接测试
    @Test
    public void stitchingFormulaTest(){
        String[] OPERATOR = {"+", "-", "*", "÷"};
        Random random = new Random();
        int[] operatorIndex = createInteger.index(3,4, random);
        for(int i : operatorIndex){
            System.out.println(OPERATOR[i]);
        }
        int[] operand = new int[3 + 1];
        for (int i = 0; i < 3 + 1; i++) {
            operand[i] = random.nextInt(10);
        }
        String str = createInteger.stitchingFormula(3,operand, operatorIndex);
        System.out.println("生成的算式：" + str);
    }
}