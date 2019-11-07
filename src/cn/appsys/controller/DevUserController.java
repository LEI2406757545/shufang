package cn.appsys.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;

import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserServiceImpl;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;
/**
 * 寮�鍙戣��
 * @author T242admin
 *
 */
@Controller
@RequestMapping(value="/dev")
public class DevUserController {

	private Logger logger= Logger.getLogger(DevUserController.class);
	
	@Resource
	private DevUserServiceImpl devUserServiceImpl;

	
	/*
	 * 登录
	 */
	@RequestMapping(value="/login")
	public String login() {
		
		return "devlogin";
	}
	/*
	 * 鐧诲綍
	 */
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("devCode")String devCode
			,@RequestParam("devPassword") String devPassword
			,HttpServletRequest request,HttpSession session) {
		logger.debug("===========================?dologin");
		logger.debug("==============================>devCode:"+devCode);
		logger.debug("==============================>devPassWord:"+devPassword);
		DevUser devUser  = devUserServiceImpl.login(devCode,devPassword);
		if(devUser!=null) {
			session.setAttribute(Constants.DEV_USER_SESSION, devUser);
			System.err.println("登录test界面=======================================>"+devUser);
			return "/developer/main";
		}else {
			request.setAttribute("error", "用户名或密码错误");
			return "devlogin";
		}
	}
	
	
	@RequestMapping(value="/developer/main")
	public String mian(HttpSession session) {
		if(session.getAttribute(Constants.DEV_USER_SESSION)==null) {
			return "redirect:/dev/login";
		}
		return "developer/main";
	}
	
	//注销
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		//注销session
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
	
}
