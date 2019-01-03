
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
