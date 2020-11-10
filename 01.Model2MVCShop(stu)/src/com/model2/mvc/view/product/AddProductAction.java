package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class AddProductAction extends Action {

	public String execute( HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		ProductVO vo = new ProductVO();
		
	
		vo.setProdName(request.getParameter("prodName"));
		vo.setProdDetail(request.getParameter("prodDetail"));
		vo.setManuDate(request.getParameter("manuDate"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setFileName(request.getParameter("fileName"));
		
		ProductService service = new ProductServiceImpl();
		service.addProduct(vo);
	
		
		
		request.setAttribute("vo", vo);
	
		
		return "forward:/product/addProduct.jsp";
	}
}