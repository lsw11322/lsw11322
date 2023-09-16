package myUtils;

import org.junit.Test;

public class IOUtilsTest {
    @Test
    //测试IOUtils类能否成功读取路径存在的文件
    public void readTxtTest() {
        String str = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\main\\resources\\orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    //测试IOUtils类能否成功写入数据到路径存在的文件
    public void writeTxtTest() {
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            IOUtils.writeTxt(elem[i], "D:\\SoftwareProject\\hk1\\src\\test\\resources\\writeTest.txt");
        }
    }

    @Test
    //测试IOUtils类能否在读入路径不存在的文件时抛出异常信息
    public void readTxtFailTest() {
        String str = IOUtils.readTxt("D:\\SoftwareProject\\hk1\\src\\test\\resources\\meiyou.txt");
    }

    @Test
    //测试IOUtils类能否在写入路径错误时抛出异常信息
    public void writeTxtFailTest() {
        IOUtils.writeTxt(0.22, "G:\\SoftwareProject\\hk1\\src\\test\\resources\\meiyou.txt");
    }
}