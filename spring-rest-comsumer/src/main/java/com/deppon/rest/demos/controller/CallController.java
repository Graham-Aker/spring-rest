package com.deppon.rest.demos.controller;

import javax.annotation.Resource;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deppon.rest.demos.bean.CallInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallController {

	@Resource
	private RestTemplate restTemplate;

	@ResponseBody
	@GetMapping(value = "/call")
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8",
			MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public String getDetail0(@RequestParam(value = "number", required = false, defaultValue = "18652997740") String number) {
		CallInfo callInfo = restTemplate.getForObject("http://spring-rest-provider/callService/call?number={number}", CallInfo.class, number);
		return callInfo.toString();
	}
}