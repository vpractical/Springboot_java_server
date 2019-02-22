package com.y.cat.dao;

import java.util.List;

import com.y.cat.bean.GcImage;

public interface IGcDao {
	
	List<GcImage> queryAll();
	
	List<GcImage> queryByType(int type);
	
	GcImage queryById(int id);
	
	
}
