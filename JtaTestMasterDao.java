
 /**************************************************************************
 * Copyright (c) 2016-2020 ZheJiang International E-Commerce Services Co.,Ltd. 
 * All rights reserved.
 * 
 * 名称：kafka
 * 版权说明：本软件属于浙江国贸云商企业服务有限公司所有，在未获得浙江国贸云商企业服务有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
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