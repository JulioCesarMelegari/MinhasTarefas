package JCM.Tarefas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JCM.Tarefas.controller.request.TarefaRequest;
import JCM.Tarefas.controller.response.TarefaResponse;
import JCM.Tarefas.model.Tarefa;
import JCM.Tarefas.services.TarefaService;

@RestController
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/tarefalike")
	public List<TarefaResponse> todasTarefas(@RequestParam Map<String, String> parametros){
		List<Tarefa> tarefas = new ArrayList<>();
		
		if(parametros.isEmpty()) {
			tarefas = service.getTodasTarefas();
		}else {
			String descricao = parametros.get("descricao");
			tarefas = service.getTarefasPorDescricao(descricao);
		}
		List<TarefaResponse> tarefasResp = tarefas
				.stream()
				.map(tarefa -> mapper.map(tarefa, TarefaResponse.class))
				.collect(Collectors.toList());
		
		return tarefasResp;
	}
	
	@GetMapping("/tarefa")
	public List<TarefaResponse> todasTarefas2(){
		List<Tarefa> tarefas = new ArrayList<>();
		tarefas = service.getTodasTarefas();
		List<TarefaResponse> tarefasResp = tarefas
				.stream()
				.map(tarefa -> mapper.map(tarefa, TarefaResponse.class))
				.collect(Collectors.toList());
		
		return tarefasResp;
	}
	
	@GetMapping("/tarefa/{id}")
	public TarefaResponse umaTarefa(@PathVariable Integer id) {
		Tarefa tarefa = service.getTarefaPorId(id);
		TarefaResponse tarefaResp = mapper.map(tarefa, TarefaResponse.class);
		return tarefaResp;
	}
	
	@PostMapping("/tarefa")
	public TarefaResponse salvarTarefa(@Valid @RequestBody TarefaRequest tarefaReq) {
		Tarefa tarefa = mapper.map(tarefaReq, Tarefa.class);
		
		return mapper.map(service.salvarTarefa(tarefa), TarefaResponse.class) ;
	}
	
	@DeleteMapping("/tarefa/{id}")
	public void excluirTarefa(@PathVariable Integer id) {
		service.deleteById(id);
	}
	

}
