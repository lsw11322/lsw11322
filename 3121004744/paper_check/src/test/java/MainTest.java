import org.junit.Test;
import myUtils.HammingUtils;
import myUtils.IOUtils;
import myUtils.SimHashUtils;

public class MainTest {

    @Test
    //测试原文件与所有测试文件的相似度
    public void origAndAllTest() {
        String[] str = new String[6];
        str[0] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig.txt");
        str[1] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_add.txt");
        str[2] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_del.txt");
        str[3] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_dis_1.txt");
        str[4] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_dis_10.txt");
        str[5] = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_dis_15.txt");
        String ansFileName = "D:\\SoftwareProject\\hk1\\src\\test\\resources\\result.txt";
        for (int i = 0; i <= 5; i++) {
            int distance = HammingUtils.getHammingDistance(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
            double similarity = HammingUtils.getSimilarity(distance);
            IOUtils.writeTxt(similarity, ansFileName);
            System.out.println(similarity);
        }
    }
}