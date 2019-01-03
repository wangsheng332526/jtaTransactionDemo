
package com.test.jta.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 /**
  * TODO 请在此处添加注释
  * @author <a href="mailto:"wangsheng"@zjiec.com”>"wangsheng"</a>
  * @version 2019年1月2日  下午4:14:34  
  * @since 2.0
  */
@Repository
public class JtaTestMasterDao{
 
    @Resource(name="masterJdbcTemplate")
    JdbcTemplate masterJdbcTemplate;
 
    public String master() {
        masterJdbcTemplate.execute("update teacher set name='master' where id=1");
        return "success";
    }
 
    public void update() {
        masterJdbcTemplate.execute("update teacher set name='8' where id=1");
        System.out.println("update");
        masterJdbcTemplate.execute("fff teacher set name=''6' where id=1");
    }
 
}
