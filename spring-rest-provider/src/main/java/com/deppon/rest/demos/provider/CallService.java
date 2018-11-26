package com.deppon.rest.demos.provider;

import com.deppon.dpboot.framework.logging.Logger;
import com.deppon.dpboot.framework.logging.LoggerFactory;
import com.deppon.rest.demos.bean.CallInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("callService")
public class CallService {

	public static Logger logger = LoggerFactory.getLogger(CallService.class);

	@RequestMapping("call")
	public CallInfo getMsg(String number) {
		CallInfo callInfo = new CallInfo();
		callInfo.setId(System.currentTimeMillis());
		callInfo.setNumber(number);
		callInfo.setSuccess(true);
		logger.info("request:" + callInfo);
		return callInfo;
	}
}
