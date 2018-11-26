package com.deppon.rest.demos;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ProviderApp {

	/***
	 * springboot的全局配置文件路径变量名
	 */
	protected static String SPRING_CONFIG_PATH = "spring.config.location";
	/**
	 * dpboot的全局配置文件路径变量名
	 */
	protected static String DPBOOT_CONFIG_PATH = "global.config.path";

	/***
	 * dpboot配置文件名，不需要路径 ，但要包括扩展名
	 */
	protected static String DPBOOT_CONFIG_FILES = "system-config.properties";

	public static void main(String[] args) {
		String configPath = System.getProperty(DPBOOT_CONFIG_PATH);
		configPath = "/Users/hepeng/work/code/trunk/demos/spring-rest/spring-rest-provider/configs/";
		if (StringUtils.isEmpty(configPath)) {
			throw new RuntimeException("you must set environment " + DPBOOT_CONFIG_PATH + " before run!");
		}

		// 如需打开web服务，web(true) 不打开web是，web(false)
		ApplicationContext ctx = new SpringApplicationBuilder(ProviderApp.class)
				.properties(SPRING_CONFIG_PATH + "=" + configPath + DPBOOT_CONFIG_FILES).web(true).run(args);
	}
}
