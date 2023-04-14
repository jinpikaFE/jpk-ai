package com.jpk.jpkai.modules.stableai.service;

import com.jpk.jpkai.modules.stableai.dto.StableGenerationDto;

import java.util.Map;

public interface StableGenerationService {
    /**
     * 文本转图片
     */
    String postTextToImage(Map<String, Object> stableGenerationDto);

    String postImageToImage(Map<String, Object> params);
}
