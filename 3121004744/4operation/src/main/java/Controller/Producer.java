package Controller;

import Server.CreateFraction;
import Server.CreateInteger;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * @author lsw
 */
public class Producer {


    public void constructProblem() {
        System.out.println("-------------四则运算生成器-------------\n");
        try {
            System.out.println("请根据如下格式输入！");
            System.out.println("-n 生成题目的个数 -r 题目数值的范围");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] para = str.split(" ");
            generateProblem(Integer.parseInt(para[1]), Integer.parseInt(para[3]));
        } catch (Exception e) {
            System.out.println("请按指定格式输入！\n\n\n");
            constructProblem();
        }
    }

    /**
     * 输出题目到文件
     *
     * @param num 生成题目数量
     * @param range 数字范围
     * @throws IOException 抛出IO异常
     */
    public void generateProblem(int num, int range) throws IOException {
        File exercises = new File("Exercises.txt");
        File answers = new File("Answers.txt");

        if (exercises.exists() || answers.exists()) {
            exercises.delete();
            answers.delete();
        }
        if (exercises.createNewFile() && answers.createNewFile()) {
            FileOutputStream exerciseOutPut = new FileOutputStream(exercises);
            PrintStream exercisePrint = new PrintStream(exerciseOutPut);

            FileOutputStream answerOutPut = new FileOutputStream(answers);
            PrintStream answerPrint = new PrintStream(answerOutPut);
            Random random = new Random();

            CreateFraction createFraction = new CreateFraction();
            CreateInteger createInteger = new CreateInteger();

            String[] problem = new String[2];
            for (int i = 1; i <= num; i++) {
                int choose = random.nextInt(2);
                if (choose == 0) {
                    problem = createFraction.createProblem(range);
                } else {
                    problem = createInteger.createProblem(range);
                }
                outPutFile(i, problem, exercisePrint, answerPrint);
            }
            exerciseOutPut.close();
            answerOutPut.close();
            exercisePrint.close();
            answerPrint.close();

            System.out.println("文件创建成功");
        }

    }

    public void outPutFile(int i, String[] problem, PrintStream... var) {
        try {
            var[0].println(i + ". " + problem[0]);
            var[1].println(i + ". " + problem[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("出现异常");
        }
    }
}


