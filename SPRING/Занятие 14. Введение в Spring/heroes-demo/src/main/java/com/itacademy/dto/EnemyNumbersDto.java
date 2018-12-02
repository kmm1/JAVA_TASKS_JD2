package com.itacademy.dto;

import lombok.Data;

/**
 * @author i.sukach
 */
@Data
public class EnemyNumbersDto {

    private String name;
    private Long number;

    public EnemyNumbersDto(String name, Long number) {
        this.name = name;
        this.number = number;
    }
}
