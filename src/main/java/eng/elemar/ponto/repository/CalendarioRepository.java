package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

}
