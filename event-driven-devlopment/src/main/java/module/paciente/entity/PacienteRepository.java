package module.paciente.entity;

import shared.FakeRepositoryAdapter;

import java.time.LocalDate;

public class PacienteRepository implements FakeRepositoryAdapter<Paciente> {
    @Override
    public Paciente save(Paciente entity) {
        return entity;
    }

    @Override
    public Paciente findById(String id) {
        return Paciente.builder()
                .id(id)
                .nome("Carlinhos")
                .dataNascimento(LocalDate.of(1997, 06, 17))
                .build();
    }
}
