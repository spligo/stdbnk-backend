package com.stdbank.backend.config;

import com.stdbank.backend.listeners.CsvImportFileChangeListener;
import com.stdbank.backend.services.CsvImportService;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.time.Duration;

@Configuration
public class FileWatcherConfig {

    @Bean
    public FileSystemWatcher fileSystemWatcher(CsvImportService csvImportService) {

        FileSystemWatcher fileSystemWatcher = new FileSystemWatcher(true, Duration.ofSeconds(5L), Duration.ofSeconds(3L));
        fileSystemWatcher.addSourceDirectory(new File("src/main/resources/import"));
        fileSystemWatcher.addListener(new CsvImportFileChangeListener(csvImportService));
        fileSystemWatcher.start();
        return fileSystemWatcher;
    }
}