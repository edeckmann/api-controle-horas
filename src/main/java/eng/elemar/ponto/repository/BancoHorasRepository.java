package eng.elemar.ponto.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.BancoHoras;
import eng.elemar.ponto.model.dto.BancoHorasDTO.BancoHorasId;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {

    Optional<BancoHoras> findBydataTrabalhada(LocalDate dataTrabalhada);

    // @Query("SELECT bh FROM BancoHoras bh WHERE bh.Id = :id AND bh.dataTrabalhada = :dataTrabalhada")
    // Optional<BancoHoras> findByBancoHorasUpdate(BancoHorasId id, LocalDate dataTrabalhada);

}
