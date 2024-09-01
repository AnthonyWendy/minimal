package com.anthony.minimal.bank.domain;
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
public class Bank implements DefaultEntity{

    private static final long serialVersionUID = -8900012216317208788L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25, message = "error.bank.name.size")
    @NotBlank(message = "error.bank.name.empty")
    private String name;

    @Size(max = 200, message = "error.bank.icon.size")
    @NotBlank(message = "error.bank.icon.empty")
    private String icon;

}



