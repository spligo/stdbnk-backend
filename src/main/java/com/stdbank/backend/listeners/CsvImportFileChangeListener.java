package com.stdbank.backend.listeners;

import com.opencsv.bean.CsvToBeanBuilder;
import com.stdbank.backend.listeners.dto.CsvImportDto;
import com.stdbank.backend.services.CsvImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.devtools.filewatch.ChangedFile;
import org.springframework.boot.devtools.filewatch.ChangedFiles;
import org.springframework.boot.devtools.filewatch.FileChangeListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CsvImportFileChangeListener implements FileChangeListener {

    private static final Logger logger = LoggerFactory.getLogger(CsvImportFileChangeListener.class);

    private final CsvImportService csvImportService;

    public CsvImportFileChangeListener(CsvImportService csvImportService) {
        this.csvImportService = csvImportService;
    }

    @Override
    public void onChange(Set<ChangedFiles> changeSet) {

        try {
            for (ChangedFiles cfiles : changeSet) {
                for (ChangedFile changedFile : cfiles.getFiles()) {
                    if ((changedFile.getType() == ChangedFile.Type.ADD || changedFile.getType() == ChangedFile.Type.MODIFY) &&
                            changedFile.getRelativeName().toLowerCase().endsWith(".csv")) {

                        logger.info("Importing csv file");
                        List<CsvImportDto> csvImports = getCsvImports(changedFile.getFile());
                        csvImportService.saveCsvImports(csvImports);

                    }
                }
            }
        } catch (Exception e) {
            logger.error("Failed to import file.", e);
        }
    }

    private List<CsvImportDto> getCsvImports(File file) throws IOException {

        List<CsvImportDto> beans = new CsvToBeanBuilder(Files.newBufferedReader(file.toPath()))
                .withType(CsvImportDto.class).build().parse();

        return beans;
    }
}