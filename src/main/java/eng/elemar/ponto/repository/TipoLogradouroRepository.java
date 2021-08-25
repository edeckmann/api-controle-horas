package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.TipoLogradouro;

@Repository
public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Long> {

}
