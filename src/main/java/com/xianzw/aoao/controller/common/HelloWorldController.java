package com.xianzw.aoao.controller.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloworld
 * @author xianzw
 * @date 2020年5月8日下午2:53:44
 *
 */
@RestController
public class HelloWorldController {

	
	@RequestMapping("helloWorld")
	public String helloWorld() {
		return "helloWorld";
	}
	
}
