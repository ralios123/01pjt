package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;

public class GetProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		System.out.println("�����δ�Ʈno :"+prodNo);
		
		String menu = (String)request.getParameter("menu");
		System.out.println("�޴�:"+menu);
		
		
		
		
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo=service.getProduct(prodNo);
		System.out.println("�����δ�Ʈvo:"+vo);
		
		//HttpSession session =  request.getSession();
		//session.setAttribute("menu", menu);
		
		request.setAttribute("menu", menu);
		request.setAttribute("vo", vo);
		
		if(menu.equals("manage")) {
			System.out.println("update������:"+menu);
			return  "forward:/product/updateProductView.jsp";
		
		}else
			System.out.println("get���δ�Ʈ������2:"+menu);
			return  "forward:/product/getProduct.jsp";
			
}
			
			
}		
	
		
		
	
		

	

