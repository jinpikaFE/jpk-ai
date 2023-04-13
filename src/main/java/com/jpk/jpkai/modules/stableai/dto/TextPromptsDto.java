package com.jpk.jpkai.modules.stableai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TextPromptsDto {
    private String text;
    private  Number weight;
}
