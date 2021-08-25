package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.TipoEndereco;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEndereco, Long> {

}
