
package com.test.jta.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.jta.service.JtaTestService;
 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Controller
public class JtaTestController {   
    @Autowired
    private JtaTestService jtaTestService;
    //MySQL的数据库引擎必须是InnoDB，否则无法回滚
    @Test
    public void test(){
    	jtaTestService.test();
    }
    @Test
    public void test2(){
    	jtaTestService.update();
    }
 
    @Test
    public void test3(){
    	jtaTestService.test3();
    }
}
