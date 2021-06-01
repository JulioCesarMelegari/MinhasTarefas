package JCM.Tarefas;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import JCM.Tarefas.model.Tarefa;
import JCM.Tarefas.repository.TarefaRepository;


@SpringBootTest
public class TarefaRepositoryTest {
	/**
	@Autowired
	private TarefaRepository repositorio;
	
	@Test
	void testFindByNomeCategoria() {
		List<Tarefa> tarefas = repositorio.findByNomeCategoria("Estudos");
		Assertions.assertEquals(2, tarefas.size());
	}
	
	void testTarefaPorCategoria() {
		List<Tarefa> tarefas = repositorio.findByNomeCategoria("Estudos");
		Assertions.assertEquals(2, tarefas.size());
	}

**/
}
