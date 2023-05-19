package com.mouracleston.cbredcharapi.mapper;

import com.mouracleston.cbredcharapi.dto.ResponseSheetDto;
import com.mouracleston.cbredcharapi.dto.SheetFormDto;
import com.mouracleston.cbredcharapi.entity.CharacterSheet;
import org.springframework.stereotype.Component;

@Component
public class CharacterSheetMapper {

    public CharacterSheet mapToCharacterSheet(SheetFormDto sheetFormDto) {
        return CharacterSheet.builder()
                .handle(sheetFormDto.handle())
                .characterRole(sheetFormDto.characterRole())
                .roleAbility(sheetFormDto.roleAbility())
                .maxInt(sheetFormDto.maxInt())
                .maxRef(sheetFormDto.maxRef())
                .maxDex(sheetFormDto.maxDex())
                .maxTech(sheetFormDto.maxTech())
                .maxCool(sheetFormDto.maxCool())
                .maxWill(sheetFormDto.maxWill())
                .maxLuck(sheetFormDto.maxLuck())
                .maxMove(sheetFormDto.maxMove())
                .maxBody(sheetFormDto.maxBody())
                .maxEmp(sheetFormDto.maxEmp())
                .currentEmp(sheetFormDto.currentEmp())
                .build();
    }

    public ResponseSheetDto mapToResponseSheetDto(CharacterSheet characterSheet) {
        return new ResponseSheetDto(
                characterSheet.getId(),
                characterSheet.getHandle(),
                characterSheet.getCharacterRole(),
                characterSheet.getRoleAbility(),
                characterSheet.getMaxInt(),
                characterSheet.getMaxRef(),
                characterSheet.getMaxDex(),
                characterSheet.getMaxTech(),
                characterSheet.getMaxCool(),
                characterSheet.getMaxWill(),
                characterSheet.getMaxLuck(),
                characterSheet.getMaxMove(),
                characterSheet.getMaxBody(),
                characterSheet.getMaxEmp(),
                characterSheet.getCurrentEmp());
    }

}
