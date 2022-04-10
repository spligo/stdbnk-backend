package com.stdbank.backend.listeners.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsvImportDto {

    @CsvBindByPosition(position = 0)
    private String title;
    @CsvBindByPosition(position = 1)
    private String firstname;
    @CsvBindByPosition(position = 2)
    private String surname;
    @CsvBindByPosition(position = 3)
    private String idNumber;
}
