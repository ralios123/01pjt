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
		System.out.println("updateprodNo Ȯ�� :"+prodNo);
		
		
		ProductVO vo = new ProductVO();
		System.out.println("updatevo Ȯ�� :"+vo);
		
		vo.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		vo.setProdName(request.getParameter("prodName"));
		System.out.println("prodName Ȯ�� :"+request.getParameter("prodName"));
		
		vo.setProdDetail(request.getParameter("prodDetail"));
		System.out.println("prodDetail Ȯ�� :"+request.getParameter("prodDetail"));
		
		vo.setManuDate(request.getParameter("manuDate"));
		System.out.println("manuDatel Ȯ�� :"+request.getParameter("manuDate"));
		
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		System.out.println("price Ȯ�� :"+request.getParameter("price"));
		
//		vo.setFileName(request.getParameter("fileName"));
//		System.out.println("price Ȯ�� :"+request.getParameter("fileName"));
//		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(vo);
		
		
		
		return "redirect:/getProduct.do?menu=search&prodNo="+prodNo;
	}
}
		
		
