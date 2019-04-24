package com.sendinfo.code;

import com.sendinfo.code.freemarker.CodeFile;
import com.sendinfo.code.freemarker.CodeService;
import com.sendinfo.code.metadata.DatabaseFactory;
import com.sendinfo.code.wapper.DatabaseWapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EasyuiMain {

  public static void main(String[] args) throws Exception {
    // 配置项
    Map<String, Object> config = new HashMap<String, Object>();
    // 基本包路径 todo 修改成你需要使用的包路径
    config.put("basepkg", "sure.sys");
    // WEB资源路径 todo 修改成你需要使用的资源路径
    config.put("catalog", "/manage/sys");
    //使用zuul的时候，加的前缀 todo 修改成你需要的zuul前缀
    config.put("prefix", "sys");
    //日期 替换(不可改)
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    config.put("date", dateFormat.format(new Date()));
    // 代码写入磁盘路径 todo 修改成你需要代码写入你的本地磁盘路径
    String rootPath = "F:\\workspace_bz\\cloud-code\\codegen";
    // 数据库catalog(不可改)
    String catalog = "";
    // 数据库schema，数据库的用户名 todo 修改成你的数据库用户名
    String schema = "test";
    // 数据表名称，多个以逗号隔开，支持Like查询 todo 修改成你需要使用的数据库表名，多个表以逗号隔开
    String tableName = "sys_base_info,sys_functions,sys_label,sys_param,sys_picture_lib,sys_role,sys_role_plugs";

    // 任务名称，取值：all(所有)、entity(只生成实体)、java(只生成Java代码)、page(只生成页面)、settle(结算系统)。（不可改）
    String taskName = "easyui";

    // 代码生成(不可改)
    String location = "classpath:com/sendinfo/code/applicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(location);
    DatabaseFactory databaseFactory = (DatabaseFactory) context.getBean("databaseFactory");
    DatabaseWapper database = databaseFactory
        .readDatabaseWapper(catalog.toUpperCase(), schema.toUpperCase(),
            tableName.toUpperCase());
    System.out.println("Tables: " + Arrays.asList(database.getTableNames()));
    CodeService service = (CodeService) context.getBean("codeService");
    List<CodeFile> filelist = service.gencode(database, taskName, config);
    writeCodeFile(rootPath, filelist);
  }

  /*
   * 写文件到硬盘
   */
  private static void writeCodeFile(String rootPath, List<CodeFile> filelist) throws Exception {
    File root = new File(rootPath);
    if (!root.exists()) {
      root.mkdir();
    } else {
      FileUtils.deleteDirectory(root);
      root.mkdir();
    }
    for (CodeFile file : filelist) {
      String path = file.getPath().replace(".", "\\");
      path = rootPath + "\\" + path;
      File pathFile = new File(path);
      if (!pathFile.exists()) {
        pathFile.mkdirs();
      }
      path += "\\" + file.getName();
      OutputStream os = new FileOutputStream(new File(path));
      IOUtils.write(file.getContent(), os);
      IOUtils.closeQuietly(os);
    }
  }

  /*
   * 输出到控制台
   */
  public static void printCodeFile(List<CodeFile> filelist) {
    for (CodeFile file : filelist) {
      System.out.println("---------------------------------------------------------");
      System.out.println(file.getPath() + "///" + file.getName());
      System.out.println(file.getContent());
    }
  }
}
