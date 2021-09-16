package br.com.taskmanager.dto;

import java.time.LocalDateTime;

import br.com.taskmanager.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class TaskDTO {

	private String title;
	private String description;
	private LocalDateTime creationDateTime;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private boolean isFinished;
	
	public Task toTask(Long idTask) {
		return Task.builder()
				.id(idTask)
				.description(this.getDescription())
				.title(this.getTitle())
				.creationDateTime(this.getCreationDateTime())
				.startDateTime(this.getStartDateTime())
				.endDateTime(this.getEndDateTime())
				.isFinished(this.isFinished())
				.build();
	}	
}
