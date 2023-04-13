package com.jpk.jpkai.modules.stableai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StableGenerationDto {
    private Integer height;
    private Integer width;
    private Number cfg_scale;
    private String clip_guidance_preset;
    private String sampler;
    private Integer samples;
    private Integer seed;
    private Integer steps;
    private TextPromptsDto[] text_prompts;
}
