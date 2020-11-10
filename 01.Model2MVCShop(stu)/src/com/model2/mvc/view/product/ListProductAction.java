package com.model2.mvc.view.product;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class ListProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		SearchVO searchVO=new SearchVO();
		
		System.out.println("listproductaction 시작 :"+searchVO);
		
		
		int page=1;
		if(request.getParameter("page") != null)
			page=Integer.parseInt(request.getParameter("page"));
		System.out.println("if문 완료:"+page);
		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		searchVO.setSearchKeyword(request.getParameter("searchKeyword"));
		System.out.println("page 설정완료:"+request.getParameter("searchCondition"));
		System.out.println("page 설정완료:"+request.getParameter("searchKeyword"));
		String pageUnit=getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		
		System.out.println("pu 설정완료:"+pageUnit);
		
		ProductService service=new ProductServiceImpl();
		HashMap<String,Object> map=service.getProductList(searchVO);

		System.out.println("map 설정완료:"+map);
		System.out.println(searchVO.getPage());
		request.setAttribute("menu", request.getParameter("menu"));
		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		
		

		
		return "forward:/product/listProduct.jsp";
	}
}
