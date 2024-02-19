package com.javaex.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("phonebookController.goGet()");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("wform".equals(action)) {
			System.out.println("wform:등록폼");
			
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request, response);
		}
		else if("insert".equals(action)) {
			System.out.println("insert:등록");
			
			String name = request.getParameter("name");
			String ph = request.getParameter("ph");
			String company = request.getParameter("company");
			
			PersonVo personVo = new PersonVo(name, ph, company);
			System.out.println(personVo);
			PersonDao personDao = new PersonDao();
			personDao.personInsert(personVo);
			
			personDao.personSelect();
			
			List<PersonVo> personList = new ArrayList<PersonVo>();
			personList.add(personVo);
			
		}
		else if("list".equals(action)) {
			System.out.println("list:리스트");
			
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
