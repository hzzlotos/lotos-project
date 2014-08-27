package com.hnmlip;

import java.io.File;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.google.common.collect.Lists;

public class MBGTest
{

    public static void main(String[] args)
    {
        generateMbgConfiguration();
    }

    private static void generateMbgConfiguration()
    {
        try
        {
            List<String> warnings = Lists.newArrayList();
            boolean overwrite = true;
            File configFile = new File(MBGTest.class.getClassLoader().getResource("").getPath()
                    + "mbg_configuration.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = null;
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("生成Mybatis配置成功！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
