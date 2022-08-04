package module.paciente.events;

import lombok.Builder;
import lombok.Getter;
import module.paciente.entity.Paciente;

import java.time.LocalDate;

@Builder
@Getter
public final class PacienteCriadoEvent {
    private String id;
    private String nome;
    private LocalDate dataNascimento;

    public static PacienteCriadoEvent fromPaciente(Paciente paciente) {
        return PacienteCriadoEvent.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .dataNascimento(paciente.getDataNascimento())
                .build();
    }

    @Override
    public String toString() {
        return "PacienteCriadoEvent{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
