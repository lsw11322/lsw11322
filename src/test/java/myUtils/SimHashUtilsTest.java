package myUtils;

import org.junit.Test;

public class SimHashUtilsTest {
    @Test
    //测试SimHashUtils.getHash方法能否求出对应哈希值
    public void getHashTest(){
        String[] strings = {"余华", "是", "一位", "真正", "的", "作家"};
        for (String string : strings) {
            String stringHash = SimHashUtils.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    //测试测试SimHashUtils.getSimHash方法能否求得不同文本的等长SimHash值
    public void getSimHashTest(){//测试了SimHashUtils.getSimHash
        String str0 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig.txt");
        String str1 = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig_0.8_add.txt");
        System.out.println(SimHashUtils.getSimHash(str0));
        System.out.println(SimHashUtils.getSimHash(str1));
    }
}