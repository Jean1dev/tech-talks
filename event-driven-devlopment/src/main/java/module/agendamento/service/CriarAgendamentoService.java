package module.agendamento.service;

import module.agendamento.entity.Agendamento;
import module.agendamento.inputs.AgendamentoInput;
import module.paciente.entity.Paciente;
import shared.FakeKafkaAdapter;
import shared.FakeRepositoryAdapter;

import java.util.UUID;

import static module.agendamento.events.AgendamentoCriadoEvent.fromEntity;

public class CriarAgendamentoService {

    private final FakeKafkaAdapter fakeKafkaAdapter;
    private final FakeRepositoryAdapter<Agendamento> fakeRepositoryAdapter;
    private final FakeRepositoryAdapter<Paciente> pacienteFakeRepositoryAdapter;

    public CriarAgendamentoService(FakeKafkaAdapter fakeKafkaAdapter, FakeRepositoryAdapter<Agendamento> fakeRepositoryAdapter, FakeRepositoryAdapter<Paciente> pacienteFakeRepositoryAdapter) {
        this.fakeKafkaAdapter = fakeKafkaAdapter;
        this.fakeRepositoryAdapter = fakeRepositoryAdapter;
        this.pacienteFakeRepositoryAdapter = pacienteFakeRepositoryAdapter;
    }

    public void handle(AgendamentoInput input) {
        Agendamento agendamento = Agendamento.builder()
                .id(UUID.randomUUID().toString())
                .dataHora(input.getDataHora())
                .paciente(getPacienteFromAgendamentoInput(input.getPaciente()))
                .build();

        fakeRepositoryAdapter.save(agendamento);

        fakeKafkaAdapter.dispatch(fromEntity(agendamento));
    }

    private Paciente getPacienteFromAgendamentoInput(AgendamentoInput.PacienteInput paciente) {
        return pacienteFakeRepositoryAdapter.findById(paciente.getId());
    }
}
