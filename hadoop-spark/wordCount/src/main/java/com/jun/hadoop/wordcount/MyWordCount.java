package com.jun.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @program: hadoop-spark
 * @description: 词频统计
 * @author: jun.luo
 * @create: 2023-07-20 21:01
 * input
 *
 * map
 *
 **/
public class MyWordCount {
    public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
        public static Text k = new Text();
        public static IntWritable v = new IntWritable();

        @Override
        protected void map(LongWritable key, Text value,
                           Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
            // 读出每一行
            String line = value.toString();
            // 分割提取每一个单词
            String[] words = line.split(" ");
            for (String word : words) {
                k.set(word);
                v.set(1);
                // map阶段的输出
                context.write(k, v);
            }
        }
    }

    public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values,
                              Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
            // 自定义计数器
            int count = 0;
            // 循环迭代器中的值
            for (IntWritable value : values) {
                count += value.get();
            }
            // reduce阶段的最终输出
            context.write(key, new IntWritable(count));
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 获取配置信息
        Configuration conf = new Configuration();
        // 对conf设置
        // 获取job对象
        Job job = Job.getInstance(conf, "myWordCount");
        // 设置job运行主类
        job.setJarByClass(MyWordCount.class);
        // 对map阶段进行设置
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));

        // 设置分区信息
        // job.setPartitionerClass(MyPartitioner.class);
        // 设置reduce处理数量
        // job.setNumReduceTasks(10);
        // 对reduce阶段进行设置
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 提交作业 true打印信息
        int isOk = job.waitForCompletion(true) ? 0 : 1;
        System.exit(isOk);
    }
}
