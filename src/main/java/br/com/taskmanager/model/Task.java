package br.com.taskmanager.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class Task {
	
	private Long id;
	private String title;
	private String description;
	private LocalDateTime creationDateTime;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private boolean isFinished;	
}
