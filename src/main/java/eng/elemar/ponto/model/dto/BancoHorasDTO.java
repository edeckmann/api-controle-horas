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
public class BancoHorasDTO {
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasId implements Serializable{
        private Long idBancoHoras;
        private Long idMovimento;
        private Long idUsuario;
        public int compareTo(Long id) {
            return 0;
        }
    }
    @EmbeddedId
    private BancoHorasId id;
    private LocalDate dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
