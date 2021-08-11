package com.arg.doctorservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth")
public interface AuthServerFeignClient {
	
	@GetMapping("/v1/oauth/user/isUserExist")
	public Boolean isUserExist(@RequestParam("input") String input);
	
	
}
