import module.agendamento.entity.AgendamentoRepostiory;
import module.agendamento.inputs.AgendamentoInput;
import module.agendamento.service.CriarAgendamentoService;
import module.paciente.entity.PacienteRepository;
import module.paciente.input.CriarPacienteInput;
import module.paciente.service.CriarPacienteService;
import shared.FakeKafkaImplementation;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ProducerMockStart {

    public static void main(String[] args) throws InterruptedException {
        FakeKafkaImplementation fakeKafkaImplementation = new FakeKafkaImplementation();
        PacienteRepository pacienteRepository = new PacienteRepository();
        CriarPacienteService criarPacienteService = new CriarPacienteService(pacienteRepository, fakeKafkaImplementation);

        System.out.println("STEP 1: -- Criando paciente --");
        criarPacienteService.handler(CriarPacienteInput.builder()
                .nome("Joaozinho")
                .dataNascimento(LocalDate.of(1997, 6, 17))
                .build());

        Thread.sleep(2000);
        System.out.println("STEP 2: -- Criando segundo paciente --");
        criarPacienteService.handler(CriarPacienteInput.builder()
                .nome("Zequinha")
                .dataNascimento(LocalDate.of(1997, 6, 17))
                .build());

        Thread.sleep(2000);

        AgendamentoRepostiory agendamentoRepostiory = new AgendamentoRepostiory();
        CriarAgendamentoService agendamentoService = new CriarAgendamentoService(fakeKafkaImplementation, agendamentoRepostiory, pacienteRepository);
        System.out.println("Ste 3 -- Criando um agendamento");
        agendamentoService.handle(AgendamentoInput.builder()
                .dataHora(ZonedDateTime.now())
                .paciente(AgendamentoInput.PacienteInput.builder().id(UUID.randomUUID().toString()).build())
                .build());


    }
}
