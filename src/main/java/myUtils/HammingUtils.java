package myUtils;

public class HammingUtils {
    /*
      通过比较差异的位数就可以得到两串文本的差异，差异的位数，
      称之为“海明距离”，通常认为海明距离<3的是高度相似的文本。
     */
    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            return -1;  //出错返回-1
        }
        for (int i = 0; i < simHash1.length(); i++) {
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }


    //通过海明距离计算相似度
    public static double getSimilarity(int distance){
        return 0.01 * (100 - distance * 100.0 / 128);
    }
}
