package br.com.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.taskmanager.dto.TaskDTO;
import br.com.taskmanager.model.Task;

public class TaskManager {
	
	private List<Task> task;
	private static Long idTask = 0L;
	
	public TaskManager() {
		this.task = new ArrayList();
	}
	
	public Task addTask(TaskDTO taskDTO) {
		var task = taskDTO.toTask(getIdTask());
		this.task.add(task);
		return task;
	}
	
	public List<Task> getTasks() {
		return this.task;
	}
	
	private static Long getIdTask() {
		return ++idTask;
	}

	public void removeTask(Long id) throws NoSuchElementException {		
		this.getTasks().remove(this.getTaskById(id));
	}
	
	public Task getTaskById(Long id) throws NoSuchElementException {
		return this.getTasks().stream()
				.filter(l -> l.getId() == id)
				.findFirst()
				.orElseThrow();
	}

	public void updateTask(Task task) {
		this.getTasks().stream()
		.filter(t -> t.getId() == task.getId())
		.forEach( t -> {
			t.setTitle(task.getTitle());
			t.setDescription(task.getDescription());
			t.setStartDateTime(task.getStartDateTime());
			t.setEndDateTime(task.getEndDateTime());
			t.setFinished(task.isFinished());
		});
	}
}
