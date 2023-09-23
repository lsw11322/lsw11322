package Server;

import java.util.Random;

/**
 * @author lsw
 */
public class CreateFraction {
    private static final String[] OPERATOR = {"+", "-"};

    public String[] createProblem(int range) {
        Random random = new Random();
        //操作符的个数1-3
        int operatorCount = 1 + random.nextInt(3);
        CreateInteger create = new CreateInteger();
        //操作符的下标
        int[] operatorIndex = create.index(operatorCount, 2, random);

        //生成第一个操作数
        int[] coprimeNumber1 = createCoprimeNumbers(range, random);
        //分子
        int x = coprimeNumber1[0];
        //分母
        int y = coprimeNumber1[1];

        String s = shamToProperFraction(x, y);

        for (int i = 0; i < operatorCount; i++) {
            //生成剩下的操作数
            int[] coprimeNumber = createCoprimeNumbers(range, random);
            int numx = coprimeNumber[0];
            int numy = coprimeNumber[1];

            String currentOperator = OPERATOR[operatorIndex[i]];
            //加法
            if (currentOperator.equals("+")) {
                x = x * numy + y * numx;
                y = y * numy;
            } else {
                //减法
                int count = 0;
                //差为负数
                while (x * numy - y * numx < 0) {
                    coprimeNumber = createCoprimeNumbers(range, random);
                    numx = coprimeNumber[0];
                    numy = coprimeNumber[1];
                    count++;
                    //构造5次都不满足则执行如下操作
                    if (count >= 5) {
                        numx = x - 1;
                        numy = y;
                    }
                }
                x = x * numy - y * numx;
                y = y * numy;
            }

            String num = shamToProperFraction(numx, numy);
            s += " " + currentOperator + " " + num;
        }

        int greatFactor = greatFraction(x, y);
        x /= greatFactor; //最终结果化简
        y /= greatFactor;

        String res = shamToProperFraction(x, y);
        s += " " + "=";

        String formulaRes[] = {s, res};
        return formulaRes;
    }

    /**
     * 求最大公因数
     *
     * @param x
     * @param y
     * @return 返回最大公因数
     */
    public int greatFraction(int x, int y) {
        while (true) {
            if (x % y == 0) {
                return y;
            }
            int temp = y;
            y = x % y;
            x = temp;
        }
    }

    /**
     * 生成一对互质数
     *
     * @param range
     * @param random
     * @return 一对互质数
     */
    public int[] createCoprimeNumbers(int range, Random random) {
        int x = 1 + random.nextInt(range);
        int y = 1 + random.nextInt(range);
        int greatFraction = greatFraction(x, y);
        x /= greatFraction;
        y /= greatFraction;
        int numbers[] = {x, y};
        return numbers;
    }

    /**
     * 将假分数转化为真分数
     * @param x 分子
     * @param y 分母
     * @return 真分数
     */
    public String shamToProperFraction(int x, int y) {
        if (x > y) {
            int n = x / y;
            x = (x - n * y);
            if (x == 0) {
                return String.valueOf(n);
            }
            return n + "'" + x + "/" + y;
        } else if (x == y) {
            return "1";
        } else if (y == 1) {
            return String.valueOf(x);
        } else if (x == 0) {
            return "0";
        }
        return x + "/" + y;
    }

}
