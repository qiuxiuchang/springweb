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

//@SessionAttributes("student")//������ǽ���������session����
@SessionAttributes(types=Student.class)//�����ʾֻҪ����ѧ���඼����request����{ }Ҳ���ԷŶ�����Ӷ��Ÿ���
@Controller
public class SpringController {
	//@RequestMapping(value="wellcome",method=RequestMethod.POST,params= {"name=zs","age"})
	//����������Ƕ��������һЩԼ��Ҫ��method��ʾֻ�ܽ���post����params��ʾ�������name=zs���������age��������������ж��Լ��
    @RequestMapping(value="wellcome",method=RequestMethod.POST,params= {"name=zs","age"})
	public String TestSpringmvc() {
		System.out.println("�����յ�");
		return "success";
	}
    //headers��ʾ������ͷ��һЩԼ�� 
    @RequestMapping(value="wellcome2",headers= {})
	public String TestSpringmvc2() {
		System.out.println("�����յ�");
		return "success";
	}
    
    @RequestMapping(value="wellcome3/{nam}")//��һ�ֲ�����ֵ�ķ���
	public String TestSpringmvc3(@PathVariable("nam") String name) {
		System.out.println("�����յ�");
		System.out.println(name);
		return "success";
	}
    @RequestMapping(value="wellcome4")//�ڶ��ֲ�����ֵ�ķ���  ���������ʾ���ֵ��һ����Ҫ��������û�л���һ��Ĭ�ϵ�ֵ
	public String TestSpringmvc4(@RequestParam("name") String name,@RequestParam(value="age" ,required=false,defaultValue="23") String age) {
		System.out.println("�����յ�");
		System.out.println(name);
		return "success";
	}
    
    @RequestMapping(value="wellcome5")//��ȡͷ��Ϣ
	public String TestSpringmvc5(@RequestHeader("cookie") String header) {
		System.out.println("�����յ�");
		System.out.println(header);
		return "success";
	}
    
    @RequestMapping(value="wellcome6")//��ȡcookie��Ϣ
	public String TestSpringmvc6(@CookieValue String header) {
		System.out.println("�����յ�");
		System.out.println(header);
		return "success";
	}
    
    @RequestMapping(value="wellcome7")//������ʵ����һ���Խ������ݣ�Ҫ��ǰ�˵�name������ʵ����һһ��Ӧ
	public String TestSpringmvc7(Student student) {
		System.out.println("�����յ�");
		System.out.println("����  ��"+student.getStuage()+"���� ��"+student.getStuname()+"ѧ�� ��"+student.getStuno()+"��ַ ��"+student.getAddress().getHomeaddress());
		return "success";
	}
    
    @RequestMapping(value="wellcome8")//�ڿ����ʹ��servlet�е�API����HttpServletRequest��Ϊ��������Ϳ���ʹ����,��ҪresponseҲ�Ǵ������
	public String TestSpringmvc8(HttpServletRequest  request) {
		System.out.println("�����յ�");
		String parameter = request.getParameter("stuname");
		System.out.println(parameter);
		return "success";
	}
    
    @RequestMapping(value="wellcome9")
	public ModelAndView TestSpringmvc9() {//ModelAndView������������ͼ�����ݿ��Դ���ǰ�ˣ�������request����
		System.out.println("�����յ�");
		ModelAndView mv= new ModelAndView("success");//������ַ�������ת��ҳ���ļ���
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		mv.addObject("student", stu);//����ǽ����ݷ���request���൱��request.setAttribute("student", stu)
		return mv;//�����һ��ʱ����ͨ��ע������ @ModelAttribute��" shengming"��
	}
    
    
    @ModelAttribute//���ע���ʾÿ�����󶼻�ִ�еķŷ�
	public String TestSpringmvc10(Map<String, Object> map) {
		System.out.println("�����յ�");
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		map.put("student", stu);//����Ĳ���key����ִ�з�����������Сд����ô���������ͬһ�����ݣ������һ��ʱ����ͨ��ע������ @ModelAttribute��" shengming"��
		return "success";
	}
    
    public String TestSpringmvc11() {
		System.out.println("�����յ�");
		Student stu =new Student();
		stu.setStuno(3456);
		stu.setStuname("qiuxi");
		
		return "forward:/views/success.jsp";//��������ת������һ�ַ�ʽ  redirect��/views/success.jsp" �����ض��򣬵��������ķ�ʽ����������ǰ׺�ͺ�׺����Ҫ�Լ�д
	}
}
