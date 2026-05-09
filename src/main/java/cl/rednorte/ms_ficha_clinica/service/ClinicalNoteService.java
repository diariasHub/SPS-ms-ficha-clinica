package cl.rednorte.ms_ficha_clinica.service;

import cl.rednorte.ms_ficha_clinica.dto.ClinicalNoteDTO;

import java.util.List;

public interface ClinicalNoteService {

    ClinicalNoteDTO createClinicalNote(ClinicalNoteDTO clinicalNoteDTO);

    // GET ALL
    List<ClinicalNoteDTO> getAllClinicalNotes();

    // GET BY ID
    ClinicalNoteDTO getClinicalNoteById(String id);

    // GET BY PATIENT ID
    List<ClinicalNoteDTO> getClinicalNotesByPatientId(String patientId);

    // GET BY ENCOUNTER ID
    List<ClinicalNoteDTO> getClinicalNotesByEncounterId(String encounterId);

    // DELETE
    void deleteClinicalNote(String id);
}