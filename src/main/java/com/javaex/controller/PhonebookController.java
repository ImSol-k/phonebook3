package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("wform".equals(action)) {
			System.out.println("wform:등록폼");


			WebUtil.forward(request, response, "/WEB-INF/writeForm.jsp");
			

		} else if ("insert".equals(action)) {
			System.out.println("insert:등록");

			String name = request.getParameter("name");
			String ph = request.getParameter("ph");
			String company = request.getParameter("company");

			PersonVo personVo = new PersonVo(name, ph, company);

			PhoneDao personDao = new PhoneDao();
			personDao.personInsert(personVo);

			response.sendRedirect("/phonebook3/pbc?action=list");

//			List<PersonVo> personList = personDao.personSelect();
//			System.out.println(personList);
//			request.setAttribute("personList", personList);
//			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
//			rd.forward(request, response);

		} else if ("list".equals(action)) {
			System.out.println("list:리스트");

			PhoneDao phoneDao = new PhoneDao();

			List<PersonVo> personList = phoneDao.personSelect();

			request.setAttribute("personList", personList);

//			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
//			rd.forward(request, response);
			
			WebUtil.forward(request, response, "/WEB-INF/list.jsp");

		} else if ("delete".equals(action)) {
			System.out.println("delete:삭제");

			int no = Integer.parseInt(request.getParameter("no"));

			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personDelete(no);
			
			//response.sendRedirect("/phonebook3/pbc?action=list");
			WebUtil.redirect(request, response, "/phonebook3/pbc?action=list");

		} else if ("pupdate".equals(action)) {
			System.out.println("pupdate:수정");

			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String ph = request.getParameter("ph");
			String company = request.getParameter("company");
			request.setAttribute("no", no);
			request.setAttribute("name", name);
			request.setAttribute("ph", ph);
			request.setAttribute("company", company);

			WebUtil.forward(request, response, "/WEB-INF/update.jsp");

		} else if ("update".equals(action)) {
			System.out.println("update:수정");

			int no = Integer.parseInt(request.getParameter("no"));

			String name = request.getParameter("name");
			String ph = request.getParameter("ph");
			String company = request.getParameter("company");

			PhoneDao personDao = new PhoneDao();
			PersonVo personVo = new PersonVo(no, name, ph, company);
			personDao.personUpdate(personVo);

			WebUtil.redirect(request, response, "/phonebook3/pbc?action=list");
		} else {
			System.out.println("list:리스트");

			PhoneDao phoneDao = new PhoneDao();

			List<PersonVo> personList = phoneDao.personSelect();

			request.setAttribute("personList", personList);

			WebUtil.forward(request, response, "/WEB-INF/list.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
