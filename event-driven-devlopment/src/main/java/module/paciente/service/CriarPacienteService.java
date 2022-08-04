package module.paciente.service;

import module.paciente.entity.Paciente;
import module.paciente.events.PacienteCriadoEvent;
import module.paciente.input.CriarPacienteInput;
import shared.FakeKafkaAdapter;
import shared.FakeRepositoryAdapter;

import java.util.UUID;

public class CriarPacienteService {

    private final FakeRepositoryAdapter<Paciente> fakeRepositoryAdapter;
    private final FakeKafkaAdapter fakeKafkaAdapter;

    public CriarPacienteService(FakeRepositoryAdapter<Paciente> fakeRepositoryAdapter, FakeKafkaAdapter fakeKafkaAdapter) {
        this.fakeRepositoryAdapter = fakeRepositoryAdapter;
        this.fakeKafkaAdapter = fakeKafkaAdapter;
    }

    public void handler(CriarPacienteInput pacienteInput) {
        Paciente paciente = fakeRepositoryAdapter.save(Paciente.builder()
                .id(UUID.randomUUID().toString())
                .nome(pacienteInput.getNome())
                .dataNascimento(pacienteInput.getDataNascimento())
                .build());

        fakeKafkaAdapter.dispatch(PacienteCriadoEvent.fromPaciente(paciente));
    }
}
