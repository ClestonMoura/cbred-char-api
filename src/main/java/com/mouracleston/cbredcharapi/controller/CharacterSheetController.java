package com.mouracleston.cbredcharapi.controller;

import com.mouracleston.cbredcharapi.dto.ResponseSheetDto;
import com.mouracleston.cbredcharapi.dto.SheetFormDto;
import com.mouracleston.cbredcharapi.service.CharacterSheetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sheets")
@RequiredArgsConstructor
public class CharacterSheetController {

    private final CharacterSheetService service;

    @GetMapping()
    public ResponseEntity<Page<ResponseSheetDto>> listCharacterSheets(@PageableDefault(sort = {"id"})
                                                                          Pageable pageable) {
        var sheetList = service.listCharacterSheets(pageable);
        return ResponseEntity.ok(sheetList);
    }

    @PostMapping
    public ResponseEntity<ResponseSheetDto> saveCharacterSheet(@RequestBody @Valid SheetFormDto sheetFormDto,
                                                           UriComponentsBuilder uriBuilder) {
        var newSheet = service.saveCharacterSheet(sheetFormDto);
        var uri = uriBuilder.path("/sheet/{id}").buildAndExpand(newSheet.id()).toUri();
        return ResponseEntity.created(uri).body(newSheet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSheetDto> getCharacterSheetById(@PathVariable("id") Long id) {
        var sheet = service.getCharacterSheetById(id);
        return ResponseEntity.ok(sheet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSheetDto> updateCharacterSheet(@PathVariable Long id,
                                                                 @RequestBody @Valid SheetFormDto sheetFormDto) {
        var updatedSheet = service.updateCharacterSheet(id, sheetFormDto);
        return ResponseEntity.ok(updatedSheet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterSheet(@PathVariable Long id) {
        service.deleteCharacterSheet(id);
        return ResponseEntity.noContent().build();
    }

}
