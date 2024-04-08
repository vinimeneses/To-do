package com.javaguides.todomanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "TodoDTO", description = "Data Transfer Object (DTO) for a To-Do item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO{
    private Long id;

    @Schema(description = "Title of the To-Do item", example = "Buy groceries")
    private String title;

    @Schema(description = "Description of the To-Do item", example = "Buy milk, bread, and eggs")
    private String description;

    @Schema(description = "Flag indicating whether the To-Do item is completed", example = "false")
    private boolean completed;
}