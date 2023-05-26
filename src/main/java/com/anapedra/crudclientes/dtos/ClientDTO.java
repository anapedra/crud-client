package com.anapedra.crudclientes.dtos;

import com.anapedra.crudclientes.entities.Client;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO  implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String name;
    @NotBlank(message = "Campo obrigatório")
    @CPF
    private String cpf;
    @NotNull(message = "Campo obrigatório")
    private Double income;
    @NotNull(message = "Campo obrigatório")
    //@Future
    @PastOrPresent
   // @FutureOrPresent
    private LocalDate birthDate;
    @NotNull(message = "Campo obrigatório")
    private Integer children;

    public ClientDTO() {

    }
    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
    public ClientDTO(Client entity) {
        id=entity.getId();
        name= entity.getName();
        cpf=entity.getCpf();
        income= entity.getIncome();
        birthDate=entity.getBirthDate();
        children=entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDTO)) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
