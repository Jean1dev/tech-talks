import module.paciente.entity.PacienteRepository;
import module.paciente.input.CriarPacienteInput;
import module.paciente.service.CriarPacienteService;
import shared.FakeKafkaImplementation;

import java.time.LocalDate;

public class ProducerMockStart {

    public static void main(String[] args) {
        FakeKafkaImplementation fakeKafkaImplementation = new FakeKafkaImplementation();
        PacienteRepository pacienteRepository = new PacienteRepository();
        CriarPacienteService criarPacienteService = new CriarPacienteService(pacienteRepository, fakeKafkaImplementation);

        System.out.println("STEP 1: -- Criando paciente --");
        criarPacienteService.handler(CriarPacienteInput.builder()
                .nome("Joaozinho")
                .dataNascimento(LocalDate.of(1997, 6, 17))
                .build());

    }
}
