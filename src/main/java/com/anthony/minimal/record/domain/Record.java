package com.anthony.minimal.record.domain;

import com.anthony.minimal.bank.domain.Bank;
import com.anthony.minimal.category.domain.Category;
import com.anthony.minimal.category.domain.FinancialType;
import com.anthony.minimal.web.entity.DefaultEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record implements DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @NotNull(message = "error.record.type.empty")
    private FinancialType type;

    @NotBlank(message = "error.record.value.empty")
    @Digits(integer = 10, fraction = 2, message = "error.record.value.digits")
    private BigDecimal value;

    private boolean paid;

    @NotNull(message = "error.record.payment_date.is_null")
    private LocalDateTime paymentDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bank bank;

    private LocalDateTime registrationDate;

}
