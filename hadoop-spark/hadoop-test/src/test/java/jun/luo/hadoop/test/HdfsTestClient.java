package jun.luo.hadoop.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.IOException;


/**
 * @program: hadoop-spark
 * @description:
 * @author: jun.luo
 * @create: 2023-07-19 19:57
 **/
public class HdfsTestClient {

    @Test
    public void readFileFromHdfs() throws IOException {
        // 获取配置
        Configuration conf = new Configuration();
        // 配置
        conf.set("fs.defaultFS", "hdfs://192.168.75.101:9000");
        // 获取文件系统的操作对象
        try {
            FileSystem fs = FileSystem.get(conf);
            FSDataInputStream fis = fs.open(new Path("/test/222.txt"));
            IOUtils.copyBytes(fis, System.out, 4096, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
