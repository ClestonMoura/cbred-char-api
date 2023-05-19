package com.mouracleston.cbredcharapi.repository;

import com.mouracleston.cbredcharapi.entity.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
}
