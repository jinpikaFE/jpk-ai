package com.jpk.jpkai.modules.stableai.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StableUserDto {
    private String id;
    private String name;
    private String message;
}
