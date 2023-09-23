package Server;

import org.junit.Test;

/**
 * 计算测试
 */
public class CalculatorTest {
    int num1 = 6;
    int num2 = 6;
    Calculator calculator = new Calculator();
    //加减乘除测试
    @Test
    public void calculateTest(){
        //加法
        int result = calculator.calculate(num1,num2,"+");
        System.out.println(num1 + "+" + num2 + "的结果是" + result);
        //减法
        result = calculator.calculate(num1, num2, "-");
        System.out.println(num1 + "-" + num2 + "的结果是" + result);
        //乘法
        result = calculator.calculate(num1, num2, "*");
        System.out.println(num1 + "*" + num2 + "的结果是" + result);
        //除法
        result = calculator.calculate(num1, num2, "÷");
        System.out.println(num1 + "÷" + num2 + "的结果是" + result);
    }

    //算式计算测试
    @Test
    public void algorithmTest(){
        int result = calculator.algorithm("6 * ( 8 + 8 ) = ");
        System.out.println("算式6 * ( 8 + 8 ) = " + result);
    }
}