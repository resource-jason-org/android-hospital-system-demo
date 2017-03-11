package com.hospital.servlet.doctorservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hospital.daoimpl.DoctorDaoImpl;
import com.hospital.model.Doctor;
import com.hospital.util.GsonUtil;

public class DoctorListServlet extends HttpServlet {

	public DoctorListServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
		List<Doctor> list = doctorDaoImpl.getAll();
		String jsonString = GsonUtil.getGson().toJson(list);
		response.setContentType("text/html");
		System.out.println("*(****");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
