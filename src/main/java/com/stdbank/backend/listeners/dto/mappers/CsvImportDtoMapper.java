package com.stdbank.backend.listeners.dto.mappers;

import com.stdbank.backend.database.CsvImport;
import com.stdbank.backend.listeners.dto.CsvImportDto;

public class CsvImportDtoMapper {

    private CsvImportDtoMapper() {
    }

    public static CsvImport getDo(CsvImportDto dto) {
        if (dto == null) {
            return null;
        }
        return CsvImport.builder()
                .title(dto.getTitle())
                .firstname(dto.getFirstname())
                .surname(dto.getSurname())
                .idNumber(dto.getIdNumber())
                .build();
    }

}
