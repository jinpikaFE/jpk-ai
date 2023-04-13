package com.jpk.jpkai.modules.stableai.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jpk.jpkai.common.api.CommonResult;
import com.jpk.jpkai.modules.stableai.dto.StableGenerationDto;
import com.jpk.jpkai.modules.stableai.service.StableGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/stable/generation")
public class StableGenerationController {
    @Autowired
    private StableGenerationService stableGenerationService;

    @PostMapping("/text-to-image")
    public CommonResult<JSONObject> postTextToImage(@RequestBody Map<String, Object> stableGenerationDto) {
        String res =stableGenerationService.postTextToImage(stableGenerationDto);
        JSONObject jsonObject = JSONUtil.parseObj(res);
        return CommonResult.success(jsonObject);
    }
}
