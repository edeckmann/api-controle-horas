package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
