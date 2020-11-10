package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String prodNo =(String)(request.getParameter("prodNo"));
		System.out.println("updateprodNo 확인 :"+prodNo);
		
		
		ProductVO vo = new ProductVO();
		System.out.println("updatevo 확인 :"+vo);
		
		vo.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		vo.setProdName(request.getParameter("prodName"));
		System.out.println("prodName 확인 :"+request.getParameter("prodName"));
		
		vo.setProdDetail(request.getParameter("prodDetail"));
		System.out.println("prodDetail 확인 :"+request.getParameter("prodDetail"));
		
		vo.setManuDate(request.getParameter("manuDate"));
		System.out.println("manuDatel 확인 :"+request.getParameter("manuDate"));
		
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		System.out.println("price 확인 :"+request.getParameter("price"));
		
//		vo.setFileName(request.getParameter("fileName"));
//		System.out.println("price 확인 :"+request.getParameter("fileName"));
//		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(vo);
		
		
		
		return "redirect:/getProduct.do?menu=search&prodNo="+prodNo;
	}
}
		
		
