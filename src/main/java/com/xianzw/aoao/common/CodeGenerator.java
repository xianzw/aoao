package com.xianzw.aoao.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * 代码生成工具
 * @author xianzw
 *
 */
public class CodeGenerator
{
  private static final String AUTHOR = "xianzw";
  private static final String OUTPUTDIR = "";
  private static final String PROJECTPATH = System.getProperty("user.dir");
  private static final String DRIVERNAME = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://139.196.126.169:5432/quanaxy_2";
  private static final String USERNAME = "glinp";
  private static final String PASSWORD = "123456";
  
  public static String scanner(String tip)
  {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext())
    {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }
  
  public static void main(String[] args)
  {
    AutoGenerator mpg = new AutoGenerator();
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(PROJECTPATH + "//quanaxy//src//main//java");
    gc.setAuthor(AUTHOR);
    gc.setOpen(true);
    mpg.setGlobalConfig(gc);
    
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(URL);
    dsc.setDriverName(DRIVERNAME);
    dsc.setUsername(USERNAME);
    dsc.setPassword(PASSWORD);
    mpg.setDataSource(dsc);
    
    final String scanner = scanner("模块名");
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(scanner);
    pc.setParent("com.seatig.quanaxy");
    mpg.setPackageInfo(pc);
    
    InjectionConfig cfg = new InjectionConfig()
    {
      public void initMap()
      {
        Map<String, Object> map = new HashMap();
        map.put("abc", getConfig().getGlobalConfig().getAuthor() + "-rb");
        setMap(map);
      }
    };
    List<FileOutConfig> focList = new ArrayList();
    focList.add(new FileOutConfig("/templates/mapper.xml.vm")
    {
      public String outputFile(TableInfo tableInfo)
      {
        return CodeGenerator.PROJECTPATH + "//quanaxy//src//main//resources//mappers//" + scanner + "//" + tableInfo.getEntityName() + "Mapper.xml";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);
    
    TemplateConfig tc = new TemplateConfig();
    tc.setXml(null);
    mpg.setTemplate(tc);
    
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setSuperEntityClass("com.xianzw.aoao.entity.common.BaseEntity");
    strategy.setTablePrefix(new String[] { "t_" });
    strategy.setEntityLombokModel(true);
    strategy.setInclude(new String[] { scanner("表名") });
    strategy.setSuperEntityColumns(new String[] { "create_date_u_t_c","version","del_flag","create_organization_id","create_company_department_id","dname","id","create_date","createby","create_company_id","create_company_name","create_user_company_id","create_user_company_name","delFlag" });
    strategy.setControllerMappingHyphenStyle(true);
    mpg.setStrategy(strategy);
    mpg.execute();
  }
}
