package com.y.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y.cat.bean.GcImage;
import com.y.cat.dao.IGcDao;
import com.y.cat.service.IGcService;

@Service
public class GcServiceImpl implements IGcService {

	@Autowired
	private IGcDao gcDao;
	
	@Override
	public List<GcImage> queryAll() {
		return gcDao.queryAll();
	}

	@Override
	public List<GcImage> queryByType(int type) {
		return gcDao.queryByType(type);
	}

	@Override
	public GcImage queryById(int id) {
		return gcDao.queryById(id);
	}

}
