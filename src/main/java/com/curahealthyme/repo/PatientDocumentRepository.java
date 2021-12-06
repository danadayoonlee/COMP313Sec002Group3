package com.curahealthyme.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curahealthyme.model.PatientDocument;

public interface PatientDocumentRepository extends CrudRepository<PatientDocument, Long>{
	@Query("SELECT u FROM PatientDocument u WHERE u.PatientId = ?1 and u.DocumentType = ?2")
    public List<PatientDocument> findDocumentsByType(long patientId, String documentType);
}
