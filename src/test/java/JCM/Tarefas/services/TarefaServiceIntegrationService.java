package JCM.Tarefas.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import JCM.Tarefas.exception.TarefaStatusException;
import JCM.Tarefas.model.Tarefa;
import JCM.Tarefas.model.TarefaStatus;

@SpringBootTest
public class TarefaServiceIntegrationService {
	
	@Autowired
	private TarefaService service;
	
	@Test
	void devIniciarTarefa() {
		Tarefa tarefa = service.iniciarTarefaPorId(3);
		Assertions.assertEquals(TarefaStatus.EM_ANDAMENTO, tarefa.getStatus());
	}
	
	@Test
	void naoDeveIniciarTarefaConcluida(){
		Tarefa tarefa = service.getTarefaPorId(3);
		tarefa.setStatus(TarefaStatus.CONCLUIDA);
		service.salvarTarefa(tarefa);
		
		Assertions.assertThrows(TarefaStatusException.class, () -> service.iniciarTarefaPorId(3));
	}
	
	
}
