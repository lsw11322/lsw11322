package Controller;

import org.junit.Test;


/**
 * 校对答案测试
 */
public class JudgeAnswerTest {
    JudgeAnswer judgeAnswer = new JudgeAnswer();

    @Test
    //测试全对的情况
    public void checkTest1(){
        judgeAnswer.check("D:\\SoftwareProject\\hk1\\3121004744\\4operation\\src\\test\\resources\\test1_e.txt", "D:\\SoftwareProject\\hk1\\3121004744\\4operation\\src\\test\\resources\\test1_a.txt");
    }

    @Test
    //测试全错的情况
    public void checkTest2(){
        judgeAnswer.check("D:\\SoftwareProject\\hk1\\3121004744\\4operation\\src\\test\\resources\\test2.txt", "D:\\SoftwareProject\\hk1\\3121004744\\4operation\\src\\test\\resources\\test1_a.txt");
    }

    @Test
    //测试文件路径不存在的情况
    public void checkTest3(){
        judgeAnswer.check("hahaha.txt", "hehehe.txt");
    }
}