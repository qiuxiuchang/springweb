package com.sprmab.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sprmab.entity.Student;

//@SessionAttributes("student")//这个表是将参数放入session域中
@SessionAttributes(types=Student.class)//这个表示只要是是学生类都放入request域中{ }也可以放多个，加逗号隔开
@Controller
public class SpringController {
	//@RequestMapping(value="wellcome",method=RequestMethod.POST,params= {"name=zs","age"})
	//括号里面的是对于请求的一些约束要求method表示只能接受post请求，params表示必须包含name=zs这个参数和age这个参数，可以有多个约束
    @RequestMapping(value="wellcome",method=RequestMethod.POST,params= {"name=zs","age"})
	public String TestSpringmvc() {
		System.out.println("请求收到");
		return "success";
	}
    //headers表示对请求头的一些约束 
    @RequestMapping(value="wellcome2",headers= {})
	public String TestSpringmvc2() {
		System.out.println("请求收到");
		return "success";
	}
    
    @RequestMapping(value="wellcome3/{nam}")//第一种参数传值的方法
	public String TestSpringmvc3(@PathVariable("nam") String name) {
		System.out.println("请求收到");
		System.out.println(name);
		return "success";
	}
    @RequestMapping(value="wellcome4")//第二种参数传值的方法  参数里面表示这个值不一定非要传过来，没有会有一个默认的值
	public String TestSpringmvc4(@RequestParam("name") String name,@RequestParam(value="age" ,required=false,defaultValue="23") String age) {
		System.out.println("请求收到");
		System.out.println(name);
		return "success";
	}
    
    @RequestMapping(value="wellcome5")//获取头信息
	public String TestSpringmvc5(@RequestHeader("cookie") String header) {
		System.out.println("请求收到");
		System.out.println(header);
		return "success";
	}
    
    @RequestMapping(value="wellcome6")//获取cookie信息
	public String TestSpringmvc6(@CookieValue String header) {
		System.out.println("请求收到");
		System.out.println(header);
		return "success";
	}
    
    @RequestMapping(value="wellcome7")//这是用实体类一次性接收数据，要求前端的name属性与实体类一一对应
	public String TestSpringmvc7(Student student) {
		System.out.println("请求收到");
		System.out.println("年龄  ："+student.getStuage()+"名字 ："+student.getStuname()+"学号 ："+student.getStuno()+"地址 ："+student.getAddress().getHomeaddress());
		return "success";
	}
    
    @RequestMapping(value="wellcome8")//在框架中使用servlet中的API，将HttpServletRequest作为参数传入就可以使用了,需要response也是传入参数
	public String TestSpringmvc8(HttpServletRequest  request) {
		System.out.println("请求收到");
		String parameter = request.getParameter("stuname");
		System.out.println(parameter);
		return "success";
	}
    
    @RequestMapping(value="wellcome9")
	public ModelAndView TestSpringmvc9() {//ModelAndView这个里面带有视图和数据可以传到前端，数据在request域中
		System.out.println("请求收到");
		ModelAndView mv= new ModelAndView("success");//里面的字符串是跳转的页面文件名
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		mv.addObject("student", stu);//这个是将数据放入request域，相当于request.setAttribute("student", stu)
		return mv;//如果不一致时可以通过注解声明 @ModelAttribute（" shengming"）
	}
    
    
    @ModelAttribute//这个注解表示每次请求都会执行的放法
	public String TestSpringmvc10(Map<String, Object> map) {
		System.out.println("请求收到");
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		map.put("student", stu);//里面的参数key等于执行方法参数类型小写。那么这个数据是同一个数据，如果不一致时可以通过注解声明 @ModelAttribute（" shengming"）
		return "success";
	}
    
    public String TestSpringmvc11() {
		System.out.println("请求收到");
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		
		return "forward:/views/success.jsp";//这是请求转发的另一种方式  redirect：/views/success.jsp" 这是重定向，但是这样的方式不会帮你加上前缀和后缀，需要自己写
	}
}
