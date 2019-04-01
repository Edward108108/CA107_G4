package com.Goods;

import java.util.List;

public interface GoodsDAO_interface {
	
	void add(GoodsVO goodVO);
	void update(GoodsVO goodVO);
	void delete(String goodId);
	GoodsVO findByPK(String goodId);
	List<GoodsVO>getAll();
	
}
