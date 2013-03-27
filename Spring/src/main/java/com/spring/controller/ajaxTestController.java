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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ajaxTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ajaxTestController() { }
	
	public ajaxTestController(
			SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@RequestMapping(value = "/ajaxTest" , method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest req, 
										HttpServletResponse res,
										@RequestParam(value="tagid", required=false, defaultValue="1") String tagid,
										@RequestParam(value="tagnm", required=false, defaultValue="") String tagnm) {
		
		ModelAndView mav = new ModelAndView();
		
		try{
			HashMap< String, Object> map = new HashMap<String, Object>();
			map.put("TAGID", tagid);
			map.put("TAGNM", tagnm);
			
			String TITLE = (String)sqlSessionTemplate.selectOne("category.selectCategory",map);
			System.out.println("categoryId ==============:" + tagid);
			System.out.println("name ==============:" + tagnm);
			System.out.println("TITLE ============== : " + TITLE);
			
			mav.addObject("TITLE", TITLE);
			mav.setViewName("ajax");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
}
