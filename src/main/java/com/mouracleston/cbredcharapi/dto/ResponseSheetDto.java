package com.mouracleston.cbredcharapi.dto;

import com.mouracleston.cbredcharapi.entity.CharacterRole;

public record ResponseSheetDto(
        Long id,
        String handle,
        CharacterRole characterRole,
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
