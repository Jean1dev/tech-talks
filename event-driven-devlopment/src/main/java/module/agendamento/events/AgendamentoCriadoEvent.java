package module.agendamento.events;

import lombok.Builder;
import lombok.Getter;
import module.agendamento.entity.Agendamento;

@Builder
@Getter
public final class AgendamentoCriadoEvent {
    private String id;

    public static AgendamentoCriadoEvent fromEntity(Agendamento agendamento) {
        return AgendamentoCriadoEvent.builder()
                .id(agendamento.getId())
                .build();
    }

    @Override
    public String toString() {
        return "AgendamentoCriadoEvent{" +
                "id='" + id + '\'' +
                '}';
    }
}
