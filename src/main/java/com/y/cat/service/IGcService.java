package com.y.cat.service;

import java.util.List;

import com.y.cat.bean.GcImage;

public interface IGcService {
	
	List<GcImage> queryAll();
	
	List<GcImage> queryByType(int type);
	
	GcImage queryById(int id);
}
