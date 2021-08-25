package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
