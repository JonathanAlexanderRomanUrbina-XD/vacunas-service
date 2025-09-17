package com.gestionvacunas.vacunas.repository;

import com.gestionvacunas.vacunas.model.HistorialVacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HistorialVacunaRepository extends JpaRepository<HistorialVacuna, Long> {

    @Query("SELECT h FROM HistorialVacuna h WHERE h.mascota.dueno.id = :usuarioId")
    List<HistorialVacuna> findByUsuarioId(Long usuarioId);
}