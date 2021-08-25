package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
