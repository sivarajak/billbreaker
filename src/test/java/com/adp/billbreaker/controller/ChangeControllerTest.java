package com.adp.billbreaker.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.adp.billbreaker.AbstractTest;
import com.adp.billbreaker.dto.ChangeDTO;
import com.adp.billbreaker.exception.ErrorInfo;

public class ChangeControllerTest extends AbstractTest {
	
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   
   @Test
   public void breakit_success_mincoins() throws Exception {
      String uri = "/billbreaker/v1/breakit?billValue=10&breakType=mincoins";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      ChangeDTO change = super.mapFromJson(content, ChangeDTO.class);
      System.out.println(change);
      assertTrue(change.getCoinList().size() > 0);
   }
   
   @Test
   public void breakit_success_maxcoins() throws Exception {
      String uri = "/billbreaker/v1/breakit?billValue=10&breakType=maxcoins";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      ChangeDTO change = super.mapFromJson(content, ChangeDTO.class);
      System.out.println(change);
      assertTrue(change.getCoinList().size() > 0);
   }
   
   @Test
   public void breakit_WrongbreakType() throws Exception {
      String uri = "/billbreaker/v1/breakit?billValue=10&breakType=mincoinss";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status);
      String content = mvcResult.getResponse().getContentAsString();
      ErrorInfo errorInfo = super.mapFromJson(content, ErrorInfo.class);
      System.out.println(errorInfo);
      assertTrue(errorInfo.getCode().equals("10002"));
   }
   
   @Test
   public void breakit_WrongBillValue() throws Exception {
      String uri = "/billbreaker/v1/breakit?billValue=15&breakType=mincoins";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status);
      String content = mvcResult.getResponse().getContentAsString();
      ErrorInfo errorInfo = super.mapFromJson(content, ErrorInfo.class);
      System.out.println(errorInfo);
      assertTrue(errorInfo.getCode().equals("10004"));
   }
   
   @Test
   public void breakit_NotEnoughCoinsAvailable() throws Exception {
      String uri = "/billbreaker/v1/breakit?billValue=100&breakType=mincoins";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status);
      String content = mvcResult.getResponse().getContentAsString();
      ErrorInfo errorInfo = super.mapFromJson(content, ErrorInfo.class);
      System.out.println(errorInfo);
      assertTrue(errorInfo.getCode().equals("10003"));
   }

}
