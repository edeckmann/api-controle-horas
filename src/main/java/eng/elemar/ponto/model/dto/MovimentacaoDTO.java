package eng.elemar.ponto.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class MovimentacaoDTO {
    
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable{
        private Long idMovimento;
        private Long idUsuario;
    }
    @EmbeddedId
    private MovimentacaoId id;
    private LocalDate dataEntrada;
    private LocalDate ddataSaida;
    private BigDecimal periodo;
    private OcorrenciaDTO ocorrencia;
    
    private CalendarioDTO calendario;
}
