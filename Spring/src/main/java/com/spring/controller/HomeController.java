package com.spring.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public HomeController() { }
	
	public HomeController(
			SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = new ModelAndView();
		
		try{
			HashMap< String, Object> map = new HashMap<String, Object>();
			map.put("TAGID", "111951");
			
			String TITLE = (String)sqlSessionTemplate.selectOne("category.selectCategory",map);
			
			System.out.println("TITLE ============== : " + TITLE);
			
			mav.addObject("TITLE", TITLE);
			mav.setViewName("home");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
}
