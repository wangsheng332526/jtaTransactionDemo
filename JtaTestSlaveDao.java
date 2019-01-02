
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
 
@Repository
public class JtaTestSlaveDao{
 
    @Resource(name="slaveJdbcTemplate")
    JdbcTemplate slaveJdbcTemplate;
   
    
    public String slave() {
        slaveJdbcTemplate.execute("update student set name='slave' where id=1");            
        return "success";
    }   
 
}