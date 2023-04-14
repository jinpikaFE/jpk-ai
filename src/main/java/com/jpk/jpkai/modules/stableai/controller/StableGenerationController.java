package com.jpk.jpkai.modules.stableai.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jpk.jpkai.common.api.CommonResult;
import com.jpk.jpkai.common.utils.ProcessFiles;
import com.jpk.jpkai.modules.stableai.service.StableGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/api/stable/generation")
public class StableGenerationController {
    @Autowired
    private StableGenerationService stableGenerationService;

    @PostMapping("/text-to-image")
    public ResponseEntity<CommonResult<JSONObject>> postTextToImage(@RequestBody Map<String, Object> stableGenerationDto) {
        String res = stableGenerationService.postTextToImage(stableGenerationDto);
        JSONObject jsonObject = JSONUtil.parseObj(res);
        return CommonResult.success(jsonObject);
    }

    @PostMapping(value = "/image-to-image")
    public ResponseEntity<CommonResult<JSONObject>> postImageToImage(@RequestPart("init_image") MultipartFile init_image, @RequestParam Map<String, Object> params) {
        File file = ProcessFiles.MultipartFileToFile(init_image);
        params.put("init_image", file);
        String res = stableGenerationService.postImageToImage(params);
        JSONObject jsonObject = JSONUtil.parseObj(res);
        return CommonResult.success(jsonObject);
    }
}
