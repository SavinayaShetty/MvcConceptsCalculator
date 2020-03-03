package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.allservices.Check;
import com.allservices.DbOperations;
import com.allservices.MathOperations;
import com.allservices.MathResult;
import com.allservices.MyMath;

@EnableWebMvc
@RestController
public class CalController {
	
	@Autowired
	MathOperations cal;
	
	@Autowired
	DbOperations signup;
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
		int ans = cal.add(i, j);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Display");
		mv.addObject("result",ans);
		return mv;
	}
	
	@RequestMapping(value="/calculate/add",method=RequestMethod.POST)
	@ResponseBody
	public int adds(@RequestBody MyMath obj) {
		int ans = cal.add(obj.getN1(),obj.getN2());
	    return ans;
	}
	
	@RequestMapping(value="/calculate/sub",method=RequestMethod.POST)
	@ResponseBody
	public int subtract(@RequestBody MyMath obj) {
		int ans = cal.sub(obj.getN1(),obj.getN2());
	    return ans;
	}
	
	@RequestMapping(value="/calculate/mul",method=RequestMethod.POST)
	@ResponseBody
	public int multiply(@RequestBody MyMath obj) {
		int ans = cal.mul(obj.getN1(),obj.getN2());
	    return ans;
	}
	
	@RequestMapping(value="/calculate/div",method=RequestMethod.POST)
	@ResponseBody
	public int divides(@RequestBody MyMath obj) {
		int ans = cal.div(obj.getN1(),obj.getN2());
	    return ans;
	}
	
	
	@RequestMapping(value="/calculate/all",method=RequestMethod.POST)
	@ResponseBody
	public MathResult Alloperations(@RequestBody MyMath obj) {
		MathResult m = cal.all(obj.getN1(), obj.getN2());
	    return m;
	}
	
	
	@RequestMapping(value="/welcome")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	} 
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(PageConfig.class);
//		   
//		Check c = ctx.getBean(Check.class); 
//		String str = c.meth();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("result","Logged in");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletResponse res,HttpServletRequest req) {
		
		ModelAndView mv = new ModelAndView();
		int i = signup.save(req.getParameter("mailid"),req.getParameter("pwd"),req.getParameter("uname"));
		if(i>0)
			mv.setViewName("login");
		else
			mv.setViewName("Display");
		return mv;
	}
	
}
