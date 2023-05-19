package com.mouracleston.cbredcharapi.service;

import com.mouracleston.cbredcharapi.dto.SheetFormDto;
import com.mouracleston.cbredcharapi.dto.ResponseSheetDto;
import com.mouracleston.cbredcharapi.mapper.CharacterSheetMapper;
import com.mouracleston.cbredcharapi.repository.CharacterSheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CharacterSheetService {

    private final CharacterSheetRepository repository;
    private final CharacterSheetMapper mapper;

    public Page<ResponseSheetDto> listCharacterSheets(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToResponseSheetDto);
    }

    public ResponseSheetDto saveCharacterSheet(SheetFormDto sheetFormDto) {
        var newSheet = repository
                .save(mapper.mapToCharacterSheet(sheetFormDto));
        return mapper.mapToResponseSheetDto(newSheet);
    }

    public ResponseSheetDto getCharacterSheetById(Long id) {
        var sheet = repository.getReferenceById(id);
        return mapper.mapToResponseSheetDto(sheet);
    }

    public ResponseSheetDto updateCharacterSheet(Long id, SheetFormDto sheetFormDto) {
        var updatedSheet = repository.getReferenceById(id);
        BeanUtils.copyProperties(sheetFormDto, updatedSheet);
        return mapper.mapToResponseSheetDto(updatedSheet);
    }

    public void deleteCharacterSheet(Long id) {
        repository.deleteById(id);
    }

}
