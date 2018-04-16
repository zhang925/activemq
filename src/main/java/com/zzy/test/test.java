package com.zzy.test;

import java.text.SimpleDateFormat;

public class test {

	public void test(){
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()));
	}
	
}
