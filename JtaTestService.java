
 /**************************************************************************
 * Copyright (c) 2016-2020 ZheJiang International E-Commerce Services Co.,Ltd. 
 * All rights reserved.
 * 
 * 名称：kafka
 * 版权说明：本软件属于浙江国贸云商企业服务有限公司所有，在未获得浙江国贸云商企业服务有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.test.jta.service;


import javax.annotation.Resource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.test.jta.dao.JtaTestMasterDao;
import com.test.jta.dao.JtaTestSlaveDao;


@Service
public class JtaTestService{
   @Resource(name = "springTransactionManager")
   private JtaTransactionManager txManager;
   @Autowired
   private JtaTestMasterDao jtaTestMasterDao;
   @Autowired
   private JtaTestSlaveDao jtaTestSlaveDao;  

   @Resource(name = "transactionTemplate")
   private TransactionTemplate transactionTemplate;  
  
   //编程式
   public String test() {
        UserTransaction userTx = txManager.getUserTransaction(); 
        try {               
            userTx.begin();     
            jtaTestMasterDao.master(); 
            jtaTestSlaveDao.slave();    
            int a=1/0;
            System.out.println(a);
            userTx.commit();
        } catch (Exception e) {
            System.out.println("捕获到异常，进行回滚" + e.getMessage());
            e.printStackTrace();
            try {
                userTx.rollback();
            } catch (IllegalStateException e1) {
               System.out.println("IllegalStateException:" + e1.getMessage());
            } catch (SecurityException e1) {
                System.out.println("SecurityException:" + e1.getMessage());
            } catch (SystemException e1) {
                System.out.println("SystemException:" + e1.getMessage());
            }              
        }
       return null;
   }
   
   
   //声明式
   @Transactional
   public void update(){
   	jtaTestMasterDao.master(); 
       
   	jtaTestSlaveDao.slave();   
   	
   	int a=1/0;
    System.out.println(a);
   }
   
   
   //事务模板方式
   public void test3() {  

           transactionTemplate.execute(new TransactionCallbackWithoutResult(){  
               @Override  
               protected void doInTransactionWithoutResult(TransactionStatus status) {  
                   try {  
                   	jtaTestMasterDao.master();        
                   	jtaTestSlaveDao.slave();   
                       int a=1/0;
                       System.out.println(a);
                   } catch (Exception ex) {  
                       // 通过调用 TransactionStatus 对象的 setRollbackOnly() 方法来回滚事务。  
                       status.setRollbackOnly();  
                       ex.printStackTrace();  
                   }  
               }  
           });         


              /* 
               //有返回值的回调
                Object obj=transactionTemplate.execute(new TransactionCallback(){
                   @Override
                   public Object doInTransaction(TransactionStatus status) {

                       return 1;
                   }  
               });  
               */
       }  


}