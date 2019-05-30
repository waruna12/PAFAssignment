package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ItemDAO;

public class ItemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ItemDAO dao;
	
	public ItemController() {
		
		dao = new ItemDAO();
		
	}
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
	}
	//Convert QueryString to a Map
	private static Map getParasMap(HttpServletRequest request){
	 
		Map<String, String> map = new HashMap<String, String>();

	
		try{
	 
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");

			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";

			scanner.close();

			String[] params = queryString.split("&");


			for (String param : params){
	 
				String [] p=param.split("=");
				map.put(p[0], p[1]);
			}
		}
		catch(Exception e) {}

		return map;
	}
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
		if (request.getParameter("action") != null) {
			
			
			String action = request.getParameter("action");
			response.setContentType("application/json");
			
			if (action.equals("list")) {
				
				try {
					
					ItemDAO item = new ItemDAO();
					response.getWriter().append(item.GetItems()); 
					
					
				} catch (Exception e) {
					
					String error="{\"Result\":\"ERROR\",\"Message\":"+e.getMessage()+"}";
					response.getWriter().print(error);
					e.printStackTrace();
				}
			}
			else if (action.equals("create")) {
				
				
				try {
								
					if (action.equals("create")) {
						
						response.getWriter().append(dao.AddItem(request.getParameter("name"),request.getParameter("brand"),Integer.parseInt(request.getParameter("qty")), request.getParameter("color")));
						
						
					}
					
				} catch (Exception e) {
					String error="{\"Result\":\"ERROR\",\"Message\":"+e.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				}
			}
			
			
		}
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			 
		Map paras = getParasMap(request);
		ItemDAO item = new ItemDAO();
		response.getWriter().append(item.UpdateItem(paras.get("name").toString(),paras.get("brand").toString(),Integer.parseInt((String)paras.get("qty")),paras.get("color").toString(),Integer.parseInt(paras.get("id").toString())));
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map paras = getParasMap(request);
		ItemDAO item = new ItemDAO();
		response.getWriter().append(item.DeleteItem(Integer.parseInt(paras.get("id").toString())));
			}
}
