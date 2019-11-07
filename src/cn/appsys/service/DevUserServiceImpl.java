package cn.appsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService{

	@Resource
	private DevUserMapper devUserMapper;

	@Override
	public DevUser login(String devCode,String devPassWord) {
		// TODO Auto-generated method stub	
		return devUserMapper.login(devCode,devPassWord);
	}

	
}
