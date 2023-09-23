import Controller.JudgeAnswer;
import Controller.Producer;

import java.util.Scanner;

/**
 * @author lsw
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("请选择所需功能：");
            System.out.println("1.四则运算生成           2.判断作答对错");
            System.out.println("3.退出程序");
            System.out.print("请输入你的选择：");
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1: {
                    Producer producer = new Producer();
                    producer.constructProblem();
                    break;
                }
                case 2: {
                    JudgeAnswer judgeAnswer = new JudgeAnswer();
                    judgeAnswer.getPath();
                    break;
                }
                case 3: {
                    // 正常退出
                    System.exit(0);
                }
                default: {
                    System.out.println("输入错误，请输入1或2或3");
                    break;
                }
            }
        }
    }
}



