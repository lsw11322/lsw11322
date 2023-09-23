package Server;


import java.util.Random;

/**
 * 创建整数类
 *
 * @author lsw
 */
public class CreateInteger {
    private static final String[] OPERATOR = {"+", "-", "*", "÷"};

    /**
     * 生成题目并返回答案
     * @param range 整数大小范围
     * @return 算式和算式计算结果
     */
    public String[] createProblem(int range) {
        Random random = new Random();
        //运算符个数（1~3个）
        int operatorCount = 1 + random.nextInt(3);
        //操作数为运算符个数+1
        int[] operand = new int[operatorCount + 1];
        int[] operatorIndex = index(operatorCount, 4, random);
        for (int i = 0; i < operatorCount + 1; i++) {
            operand[i] = random.nextInt(range);
        }

        String formula = stitchingFormula(operatorCount, operand, operatorIndex);

        //计算结果
        Calculator calculator = new Calculator();
        int res = calculator.algorithm(formula);
        String[] formulaRes = new String[2];

        if (res > 0) {
            formulaRes[0] = formula;
            formulaRes[1] = String.valueOf(res);
        } else {
            return createProblem(range);
        }
        return formulaRes;
    }

    /**
     * @param operatorCount 运算符个数
     * @param operatorTotal 运算符种类
     * @param random        随机数
     * @return 运算符下标数组
     */
    public int[] index(int operatorCount, int operatorTotal, Random random) {
        int similar = 0;
        int[] operatorIndex = new int[operatorCount];
        for (int i = 0; i < operatorCount; i++) {
            operatorIndex[i] = random.nextInt(operatorTotal);
        }
        for (int i : operatorIndex) {
            if (operatorIndex[0] == i) {
                similar++;
            }
        }
        if (similar == operatorCount && operatorCount != 1) {
            //保证一个式子里至少有2个不同的操作符，若所有操作符下标都一样，则重新产生操作符下标
            return index(operatorCount, operatorTotal, random);
        } else {
            return operatorIndex;
        }
    }

    /**
     * 拼接式子
     * @param operatorCount 运算符个数
     * @param operand       操作数
     * @param operatorIndex 运算符下标
     * @return 算式
     */
    public String stitchingFormula(int operatorCount, int operand[], int[] operatorIndex) {
        //式子形态
        int bracketForm = new Random().nextInt(2);
        StringBuilder formula = new StringBuilder();
        switch (operatorCount) {
            case 1:
                // 1+2型
                formula.append(operand[0])
                        .append(" ")
                        .append(OPERATOR[operatorIndex[0]])
                        .append(" ")
                        .append(operand[1])
                        .append(" ")
                        .append("=");
                break;
            case 2: {
                // 1+2+3 型
                if (bracketForm == 0) {
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append("=");

                } else {
                    //1+(2+3)型
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append("(")
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                }
                break;
            }
            case 3: {
                if (bracketForm == 0) {
                    //1+((2+3)-4)型
                    formula.append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append("( (")
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append(OPERATOR[operatorIndex[2]])
                            .append(" ")
                            .append(operand[3])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                } else {
                    //(1+2)+(3+4)型
                    formula.append("(")
                            .append(" ")
                            .append(operand[0])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[0]])
                            .append(" ")
                            .append(operand[1])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append(OPERATOR[operatorIndex[1]])
                            .append(" ")
                            .append("(")
                            .append(" ")
                            .append(operand[2])
                            .append(" ")
                            .append(OPERATOR[operatorIndex[2]])
                            .append(" ")
                            .append(operand[3])
                            .append(" ")
                            .append(")")
                            .append(" ")
                            .append("=");
                }
                break;
            }
            default:{
                System.out.println("运算符个数不满足题目设置");
                break;
            }
        }
        return formula.toString();
    }


}
