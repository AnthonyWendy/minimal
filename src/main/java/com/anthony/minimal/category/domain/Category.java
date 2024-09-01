package com.anthony.minimal.category.domain;
import com.anthony.minimal.web.entity.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements DefaultEntity{

    private static final long serialVersionUID = 7781870477182338768L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, message = "error.category.name.size")
    @NotBlank(message = "error.category.name.empty")
    private String name;

    @Size(max = 10, message = "error.category.color.size")
    @NotBlank(message = "error.category.color.empty")
    private String color;

    @Size(max = 200, message = "error.category.icon.size")
    @NotBlank(message = "error.category.icon.empty")
    private String icon;

}



