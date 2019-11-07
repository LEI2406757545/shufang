package cn.appsys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;

@Repository
public interface DevUserMapper {

	// 开发者登录验证
	public DevUser login(@Param("devCode") String devCode, @Param("devPassword") String devPassWord);

	// 开发者alllist statuslist
	public List<DataDictionary> getStatusList();

	public List<DataDictionary> getFlatFormList();

	public List<AppCategory> getCategoryLevel1List();

	public List<AppCategory> getCategoryLevel2List(@RequestParam("categoryLevel1List") String categoryLevel1List);

	public List<AppCategory> getCategoryLevel3List(@RequestParam("categoryLevel1List") String categoryLevel2List);

	public List<AppInfo> getAppInfoList(@Param("softwareName") String softwareName, @Param("status") String status,
			@Param("flatformId") String flatformId, @Param("categoryLevel1") String categoryLevel1,
			@Param("categoryLevel2") String categoryLevel2, @Param("categoryLevel3") String categoryLevel3,
			@Param("devId") Integer devId, @Param("from") Integer from, @Param("pageSize") Integer pageSize);

	public  int count(@Param("softwareName") String softwareName, @Param("status") String status,
			@Param("flatformId") String flatformId, @Param("categoryLevel1") String categoryLevel1,
			@Param("categoryLevel2") String categoryLevel2, @Param("categoryLevel3") String categoryLevel3,
			@Param("devId") Integer devId);
	
	public int addAppinfo(AppInfo appInfo) ;
	
	public int getAPKNameCount(@Param("APKName") String APKName);
	
	public AppInfo getAppinfoViewlist(@Param("id") String id) ;
	
	public List<AppVersion> getAppVersionById(@Param("id") String id);
	
	public int updStatus(@Param("status") String status,@Param("id") String id);
	
	public AppVersion getAppVersion(@Param("id") String aid);
	
	public int updAppVersion(@Param("versionSize") String size,@Param("versionInfo") String info,@Param("id") String id,@Param("appid") String aid,@Param("modifyDate") Date modifyDate);
	
	public int addAppVersion(AppVersion appVersion);
	
	public int updAppinfo(AppInfo appInfo);
	
	public int delapp(String id);
	
	public int appVersionId(@Param("id")String vid ,@Param("appid") String aid);
}
