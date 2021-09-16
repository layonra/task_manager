package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import br.com.taskmanager.controller.TaskManager;
import br.com.taskmanager.dto.TaskDTO;
import br.com.taskmanager.model.Task;

public class ManagerTest {
	
	private TaskManager taskManager;
	
	@Before
	public void init() {
		this.taskManager = new TaskManager();
	}
	
	@Test
	public void addTaskTest() {
		var task = addTask();
		var tasks = this.taskManager.getTaskById(task.getId());
		assertEquals(task.getTitle(), tasks.getTitle());
	}

	@Test
	public void removeExistingTaskTest() {
		var task = addTask();
		this.taskManager.removeTask(task.getId());
		assertTrue(this.taskManager.getTasks().isEmpty());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeNoExistentTaskTest() {
		this.taskManager.removeTask(0L);
	}	
	
	@Test
	public void updateExistingTaskTest() {
		var task = addTask();		
		var taskDTO = this.getTaskDTO();
		taskDTO.setTitle("Updated Title");
		
		this.taskManager.updateTask(taskDTO.toTask(task.getId()));
		
		assertEquals(taskDTO.getTitle(), this.taskManager.getTaskById(task.getId()).getTitle());
	}	
	
	private Task addTask() {			
		return this.taskManager.addTask(this.getTaskDTO());
	}
		
	private TaskDTO getTaskDTO() {
		return new TaskDTO("Teste","Description",LocalDateTime.now(),null,null,false);
	}	
}
