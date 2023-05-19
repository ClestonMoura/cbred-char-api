package com.mouracleston.cbredcharapi.dto;

import com.mouracleston.cbredcharapi.entity.CharacterRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SheetFormDto(
        @NotBlank
        String handle,
        @NotNull
        CharacterRole characterRole,
        @NotBlank
        String roleAbility,
        Integer maxInt,
        Integer maxRef,
        Integer maxDex,
        Integer maxTech,
        Integer maxCool,
        Integer maxWill,
        Integer maxLuck,
        Integer maxMove,
        Integer maxBody,
        Integer maxEmp,
        Integer currentEmp) {


}
