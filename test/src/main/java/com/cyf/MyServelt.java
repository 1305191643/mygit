package com.cyf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServelt extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		
		
		System.out.println("��ʼ��");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		//System.out.println("����get");
		//System.out.println(req.getParameter("123"));
		//System.out.println(req.getContextPath());
		//�ض���
		//resp.sendRedirect(req.getContextPath() + "/index.jsp"); 
		//ת��
		//req.getRequestDispatcher("/index.jsp").forward(req, resp);
		//Cookie coo = new Cookie("key", "value");//����һ����ֵ�Ե�cookie����
		//coo.setMaxAge(60*60*24*7);//����cookie����������
		//resp.addCookie(coo);//��ӵ�response��
		
		//UserJdbc j=new UserJdbc();
		//String s=j.getUser();
		String id=req.getParameter("id");
		UserDao d=new UserDao();
		Map s=d.queryUserById(Integer.valueOf(id));
		PrintWriter writer = resp.getWriter();
		writer.write(s.toString());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
