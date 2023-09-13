import myUtils.HammingUtils;
import myUtils.IOUtils;
import myUtils.SimHashUtils;

public class main {
    public static void main(String[] args){
        //获取文件内容对应字符串
        String str1 = IOUtils.readTxt(args[0]);
        String str2 = IOUtils.readTxt(args[1]);
        //获取字符串对应simHash值
        String simHash1 = SimHashUtils.getSimHash(str1);
        String simHash2 = SimHashUtils.getSimHash(str2);
        //计算相似度
        double similarity = HammingUtils.getSimilarity(HammingUtils.getHammingDistance(simHash1, simHash2));
        //输出相似度到目标文件
        IOUtils.writeTxt(similarity, args[2]);

    }

}
