package com.arvin.client;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlMap
{

    public void generatorMethod() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwirte = true;
        //指定逆向工程配置文件
        String genCfg = "/generatorConfig.xml";
        File configFile = new File(GeneratorSqlMap.class.getResource(genCfg).getFile());
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(configFile);
        DefaultShellCallback defaultShellCallback = new DefaultShellCallback(overwirte);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,defaultShellCallback,warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception
    {

        try{
            GeneratorSqlMap generatorSqlMap = new GeneratorSqlMap();
            generatorSqlMap.generatorMethod();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
