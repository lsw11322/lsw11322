package myUtils;

import com.hankcs.hanlp.HanLP;

import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.List;


public class SimHashUtils {

    //用MD5获取hash值
    public static String getHash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 传入字符串，计算它的SimHash值，以字符串形式输出
     * @param str
     * @return 返回str的SimHash值
     */
    public static String getSimHash(String str) {
        //用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[128];
        //分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        int size = keywordList.size();

        //获取各个关键字对应的hash值，此时返回的hash值是一串二进制字符串
        int i = 0;
        for (String keyword : keywordList) {
            StringBuilder hash = new StringBuilder(getHash(keyword));
            if (hash.length() < 128) {
                int dif = 128 - hash.length();
                for (int j = 0; j < dif; j++) {
                    hash.append("0");
                }
            }

            //加权、合并
            /*
              在这里我们把权重分为10个等级，先用关键词的总数size除以10，就把关键词分成了十个组，得到的结果就是每组的关键词的个数
              i用来标志每一次循环对应集合中关键词是第几个关键词，所以用i除以上面的每组的关键词的个数
              第一组即关键词权重最高的一组i/（size/10)的值为0，第二组的值为1，以此类推
              再在前面用10减去上述结果，则可以得到每一个关键词的权重
             */
            for (int j = 0; j < v.length; j++) {
                if (hash.charAt(j) == '1') {
                    //当前位hash值若为1，则进行如下过程
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    //当前位hash值若为0，则进行如下过程
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }

        //降维
        StringBuilder simHash = new StringBuilder();
        for(int j = 0; j<v.length;j++){
            if(v[j] > 0){
                simHash.append("1");
            }else{
                simHash.append("0");
            }
        }
        return simHash.toString();
    }
}
