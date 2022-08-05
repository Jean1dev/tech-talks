package module.agendamento.entity;

import shared.FakeRepositoryAdapter;

public class AgendamentoRepostiory implements FakeRepositoryAdapter<Agendamento> {
    @Override
    public Agendamento save(Agendamento entity) {
        return entity;
    }

    @Override
    public Agendamento findById(String id) {
        return null;
    }
}
