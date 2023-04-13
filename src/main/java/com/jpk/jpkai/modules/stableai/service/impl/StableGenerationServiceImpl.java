package com.jpk.jpkai.modules.stableai.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jpk.jpkai.modules.stableai.dto.StableGenerationDto;
import com.jpk.jpkai.modules.stableai.service.StableGenerationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StableGenerationServiceImpl implements StableGenerationService {
    @Value("${stable_ai.STABILITY_API_KEY}")
    private String STABILITY_API_KEY;

    @Value("${stable_ai.URL}")
    private String URL;

    @Override
    public String postTextToImage(Map<String, Object> stableGenerationDto) {
        String dataJson = JSONUtil.toJsonStr(stableGenerationDto);
        String res = HttpRequest
                .post(URL + "/v1/generation/stable-diffusion-v1-5/text-to-image")
                .header(Header.AUTHORIZATION, "Bearer " + STABILITY_API_KEY)
                .header(Header.CONTENT_TYPE, "application/json")
                .header(Header.ACCEPT, "application/json")
                .body(dataJson)
                .execute()
                .body();
        return res;
    }
}
