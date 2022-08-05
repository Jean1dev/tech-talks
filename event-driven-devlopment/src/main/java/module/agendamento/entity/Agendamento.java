package module.agendamento.entity;

import lombok.Builder;
import lombok.Getter;
import module.paciente.entity.Paciente;

import java.time.ZonedDateTime;

@Builder
@Getter
public class Agendamento {

    private String id;
    private ZonedDateTime dataHora;
    private Paciente paciente;

}
