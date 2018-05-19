package com.paascloud.web;

import com.paascloud.domain.PcUacUser;
import com.paascloud.service.PcUserService;
import com.paascloud.wrapper.WrapMapper;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户管理主页面.
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - PcUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PcUserController {
	@Resource
	private PcUserService uacUserService;

	/**
	 * 通过Id删除用户.
	 *
	 * @param userId the user id
	 *
	 * @return the wrapper
	 */
	@GetMapping(value = "/getUserById/{userId}")
	@ApiOperation(httpMethod = "POST", value = "通过Id获取用户")
	public Wrapper<PcUacUser> getUserById(@ApiParam(name = "userId", value = "用户ID") @PathVariable Long userId) {
		log.info(" 通过Id删除用户 userId={}", userId);
		PcUacUser user = uacUserService.getById(userId);
		return WrapMapper.ok(user);
	}

}
