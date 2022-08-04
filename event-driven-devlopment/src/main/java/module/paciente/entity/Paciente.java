package module.paciente.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Paciente {

    private String id;
    private String nome;
    private LocalDate dataNascimento;

}
