package com.y.cat.bean;

public class Res {
	private int code = 200;
	private String msg;
	private Object data;
	
	public Res(){}
	
	public Res(int code){
		setCode(code);
	}
	
	public Res(int code,String msg){
		setCode(code);
		setMsg(msg);
	}
	
	public Res(Object data){
		setData(data);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
