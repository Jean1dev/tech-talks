package module.agendamento.inputs;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@Getter
public final class AgendamentoInput {
    private ZonedDateTime dataHora;
    private PacienteInput paciente;

    @Builder
    @Getter
    public static class PacienteInput {
        private String id;
    }
}
