package module.paciente.entity;

import shared.FakeRepositoryAdapter;

public class PacienteRepository implements FakeRepositoryAdapter<Paciente> {
    @Override
    public Paciente save(Paciente entity) {
        return entity;
    }
}
