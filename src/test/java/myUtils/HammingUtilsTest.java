package myUtils;

import org.junit.Test;


public class HammingUtilsTest  {
    @Test
    public void getHammingDistance() {
        String str0 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig.txt");
        String str1 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_add.txt");
        int distance = HammingUtils.getHammingDistance(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        System.out.println("海明距离：" + distance);
    }

    @Test
    //获取海明距离失败测试
    public void getHammingDistanceFailTest() {
        String str0 = "1010101010";
        String str1 = "1010101";
        System.out.println(HammingUtils.getHammingDistance(str0, str1));
    }

    @Test
    public void getSimilarityTest() {//测试getSimilarity
        String str0 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig.txt");
        String str1 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_add.txt");
        int distance = HammingUtils.getHammingDistance(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        double similarity = HammingUtils.getSimilarity(distance);
        System.out.println("str0和str1的汉明距离: " + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }


}