package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author lsw
 */
public class JudgeAnswer {
    /**
     * 获取所需批改文件和答案文件路径
     */
    public void getPath(){
        try{
            System.out.println("请根据如下格式输入！");
            System.out.println("-e 题目文件 -a 答案文件");
            Scanner scanner = new Scanner(System.in);
            String str1 = scanner.nextLine();
            String[] parameters1 = str1.split(" ");
            check(parameters1[1], parameters1[3]);
        }catch (Exception e){
            System.out.println("请按指定格式输入！\n\n\n");
            getPath();
        }
    }

    /**
     * 输出作答对错
     * @param exerciseFilePath 作答文件路径
     * @param answerFilePath 答案文件路径
     */
    public void check(String exerciseFilePath, String answerFilePath){
        try{
            List<String> exerciseAnswers = exerciseFileReader(exerciseFilePath);
            List<String> answers = answerFileReader(answerFilePath);

            List<String> correct = new ArrayList<>();
            List<String> wrong = new ArrayList<>();

            int min = Math.min(exerciseAnswers.size(),answers.size());
            int num = 1;
            for(int i = 0;i<min;i++){
                if(exerciseAnswers.get(i).equals(answers.get(i))){
                    correct.add(String.valueOf(num++));
                }else{
                    wrong.add(String.valueOf(num++));
                }
            }
            File grade = new File("Grade.txt");
            if(grade.exists()){
                grade.delete();
            }
            if(grade.createNewFile()){
                FileOutputStream gradeOutPut = new FileOutputStream(grade);
                PrintStream gradePrint = new PrintStream(gradeOutPut);
                String corrects = String.join(", ",correct);
                gradePrint.println("Correct：" + correct.size() + " (" + corrects + ")");
                String wrongs = String.join(", ",wrong);
                gradePrint.println("Wrong：" + wrong.size() + " (" + wrongs + ")");
                System.out.println("已批改");
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("运行异常");
        }
    }

    /**
     * 输出作答列表
     * @param path 作答文件路径
     * @return 作答结果
     * @throws IOException 抛出IO异常
     */
    public List<String> exerciseFileReader(String path) throws IOException {
        BufferedReader exerciseReader = new BufferedReader(new FileReader(path));
        String exerciseAnswer = "";
        List<String> exerciseAnswers = new ArrayList<>();
        while((exerciseAnswer = exerciseReader.readLine())!=null){
            String[] split = exerciseAnswer.split("=");
            if(split.length>=2){
                exerciseAnswers.add(split[1]);
            }else{
                exerciseAnswers.add("");
            }

        }
        return exerciseAnswers;
    }

    /**
     * 输出答案列表
     * @param path 答案文件路径
     * @return 答案
     * @throws IOException 抛出IO异常
     */
    public List<String> answerFileReader(String path) throws IOException {
        BufferedReader answerReader = new BufferedReader(new FileReader(path));
        String answer = "";
        List<String> answers = new ArrayList<>();
        while ((answer = answerReader.readLine()) != null){
            String[] split = answer.split(" ");
            answers.add(split[1]);
        }
        return answers;
    }

}
