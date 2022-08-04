package module.paciente.input;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CriarPacienteInput {
    private String nome;
    private LocalDate dataNascimento;
}
