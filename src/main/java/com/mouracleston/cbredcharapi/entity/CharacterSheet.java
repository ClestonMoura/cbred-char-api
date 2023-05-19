package com.mouracleston.cbredcharapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "character_sheets")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class CharacterSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String handle;
    @Enumerated(value = EnumType.STRING)
    private CharacterRole characterRole;
    private String roleAbility;
    private Integer maxInt;
    private Integer maxRef;
    private Integer maxDex;
    private Integer maxTech;
    private Integer maxCool;
    private Integer maxWill;
    private Integer maxLuck;
    private Integer maxMove;
    private Integer maxBody;
    private Integer maxEmp;
    private Integer currentEmp;

}
