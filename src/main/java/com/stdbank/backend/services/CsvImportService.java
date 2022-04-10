package com.stdbank.backend.services;

import com.stdbank.backend.database.CsvImport;
import com.stdbank.backend.database.repositories.CsvImportRepository;
import com.stdbank.backend.listeners.dto.CsvImportDto;
import com.stdbank.backend.listeners.dto.mappers.CsvImportDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CsvImportService {

    private static final Logger logger = LoggerFactory.getLogger(CsvImportService.class);

    @Autowired
    private CsvImportRepository csvImportRepository;

    public void saveCsvImports(List<CsvImportDto> csvImportDtos) {

        if (csvImportDtos == null) {
            return;
        }

        logger.info("Importing {} csv records", csvImportDtos.size());

        List<CsvImport> csvImports = csvImportDtos.stream().map(CsvImportDtoMapper::getDo)
                .filter(Objects::nonNull).collect(Collectors.toList());

        csvImportRepository.saveAll(csvImports);

    }

}
