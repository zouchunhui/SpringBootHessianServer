package com.yuanjian.hessian.demo.service;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;

public class HessianArticleServiceTest {

	private ZBTypeService service;
    
    @Before
    public void initHessianProxy() throws MalformedURLException {
        String url = "http://127.0.0.1:8989/api/hessian/zbTypeService";

        HessianProxyFactory factory = new HessianProxyFactory();
        service = (ZBTypeService) factory.create(ZBTypeService.class, url);
    }
    
    @Test
    public void testGetArticle() {
    	System.out.println(service.getZBTypeById(16L));
    }
    
}
