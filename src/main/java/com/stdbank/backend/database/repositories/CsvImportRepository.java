package com.stdbank.backend.database.repositories;

import com.stdbank.backend.database.CsvImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvImportRepository extends JpaRepository<CsvImport, Long> {
}
