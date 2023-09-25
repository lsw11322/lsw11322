package Controller;

import org.junit.Test;

import java.io.IOException;

/**
 * 问题生成测试
 */
public class ProducerTest {
    Producer producer = new Producer();

    @Test
    //生成20个问题和对应答案测试
    public void test(){
        try {
            producer.generateProblem(20,5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}