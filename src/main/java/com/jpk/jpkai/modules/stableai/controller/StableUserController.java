package com.jpk.jpkai.modules.stableai.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jpk.jpkai.common.api.CommonResult;
import com.jpk.jpkai.modules.stableai.service.StableUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stable/user")
public class StableUserController {
    @Autowired
    private StableUserService stableUserService;

    @GetMapping("/account")
    public CommonResult<JSONObject> getUser() {
        String res =stableUserService.getUser();
        JSONObject jsonObject = JSONUtil.parseObj(res);
        return CommonResult.success(jsonObject);
    }
}
