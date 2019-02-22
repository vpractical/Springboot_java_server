package com.y.cat.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.y.cat.bean.Res;
import com.y.cat.bean.GcImage;
import com.y.cat.service.IGcService;

/**
 * @RestController:controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 * @RequestMapping("/info")
 * @ResponseBody 将返回数据放入body区
 * @PathVariable：一般我们使用URI template样式映射使用，即url/{param}这种形式，也就是一般我们使用的GET，DELETE，PUT方法会使用到的，我们可以获取URL后所跟的参数。
 * @RequestParam：一般我们使用该注解来获取多个参数，在（）内写入需要获取参数的参数名即可，一般在PUT，POST中比较常用。
 * @RequestBody：该注解和@RequestParam殊途同归，我们使用该注解将所有参数转换，在代码部分在一个个取出来
 */
@RestController
@RequestMapping("/gc")
public class CcImageController {
	
	@Autowired
	IGcService gcService;

	/**
	 * 获取所有立绘
	 */
	@GetMapping("/all")
	public String getAll(){
		List<GcImage> all = gcService.queryAll();
		return JSON.toJSONString(new Res(all));
	}
	
	@GetMapping("/byId")
	public String getGcById(int id){
		GcImage gc = gcService.queryById(id);
		if(gc == null){
			return toJson(new Res(520, "立绘不存在"));
		}
		return toJson(new Res(gc));
	}
	
	/**
	 * 获取 某个分类的所有立绘
	 */
	@GetMapping("/byType")
	public String getGcByType(@RequestParam Map<String,Object> params){
		if(!params.containsKey("type")){
			return toJson(new Res(520, "缺少必要参数type"));
		}
		int type = Integer.parseInt(params.get("type").toString());
		
		List<GcImage> all = gcService.queryByType(type);
		if(all == null){
			return toJson(new Res(520, "该类型的立绘不存在"));
		}
		return toJson(new Res(all));
	}
	
	
	
	private String toJson(Object obj){
		return JSON.toJSONString(obj);
	}
}
