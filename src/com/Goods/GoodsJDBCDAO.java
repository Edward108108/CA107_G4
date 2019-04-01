package com.Goods;

public class GoodsJDBCDAO {

	public static void main(String[] args) {

		GoodsDAOImpl dao = new GoodsDAOImpl();
				
		//add
		GoodsVO goods = new GoodsVO();		
		goods.setGoodName("深入淺出Servlet");
		goods.setGoodPrice(new Double(7788));
		goods.setGoodInfo(null);
		goods.setGoodImg(null);
		goods.setGoodStatus(new Double (0));
		
		dao.add(goods);
		System.out.println(dao);
		
		
		
	}

}
