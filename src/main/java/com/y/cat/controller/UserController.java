package com.y.cat.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.y.cat.bean.Res;
import com.y.cat.bean.User;
import com.y.cat.config.UserConfig;
import com.y.cat.service.IUserService;

/**
 * @RestController:controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 * @RequestMapping("/info")
 * @ResponseBody 将返回数据放入body区
 * @PathVariable：一般我们使用URI template样式映射使用，即url/{param}这种形式，也就是一般我们使用的GET，DELETE，PUT方法会使用到的，我们可以获取URL后所跟的参数。
 * @RequestParam：一般我们使用该注解来获取多个参数，在（）内写入需要获取参数的参数名即可，一般在PUT，POST中比较常用。
 * @RequestBody：该注解和@RequestParam殊途同归，我们使用该注解将所有参数转换，在代码部分在一个个取出来
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/name")
	public String userName(){
		return "Jim";
	}
	
	@GetMapping("/info")
	public String getUserById(@RequestParam Map<String,Object> params){
		Res res = new Res();
		if(!params.containsKey("id")){
			res.setCode(500);
			res.setMsg("缺少参数id");
			return JSON.toJSONString(res);
		}
		
		int id = Integer.parseInt(params.get("id").toString());
		User user = userService.getUserById(id);
		res.setCode(200);
		res.setData(user);
		return JSON.toJSONString(res);
	}
	
	@GetMapping(value = "/all")
	@ResponseBody
	public String getAllUser(){
		List<User> users = userService.getAllUsers();
		return JSON.toJSONString(users);
	}
	
	@PostMapping(value = "/register")
	public String registerUser(@RequestParam Map<String,Object> params){
		
		String account = params.get("account").toString();
		String password = params.get("password").toString();
		int registerType = Integer.parseInt(params.get("registerType").toString());
		
		if(registerType != UserConfig.LOGIN_BY_PWD){
			Res res = new Res(500, "不支持的注册类型");
			return toJson(res);
		}
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setNick("乌龟hi");
		user.setPhone("9999");
		userService.registerUser(user);
		
		Res res = new Res(200);
		return JSON.toJSONString(res);
	}
	
	private String toJson(Object obj){
		return JSON.toJSONString(obj);
	}
	
}
