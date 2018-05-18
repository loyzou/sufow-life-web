package com.sufow.action;
import org.ddq.common.util.JsonUtil;

import com.alibaba.fastjson.serializer.SerializerFeature;
public class Sufow  {
	private String username;
	private int age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toJson(SerializerFeature feature){
		return JsonUtil.getInstance().object2JSON(this, feature );
	}
	
	public String toJson(){
		return JsonUtil.getInstance().object2JSON(this, SerializerFeature.WriteDateUseDateFormat);
	}
	
}
