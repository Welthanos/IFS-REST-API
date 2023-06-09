package br.edu.ifs.academico.rest.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class ClienteForm {

    @NotEmpty
    @NotBlank(message = "O Nome não pode estar em branco.")
    @Size(max = 256)
    private String nome;

    @NotEmpty
    @NotBlank
    @CPF(message = "O Número do CPF informado é inválido.")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull(message = "Data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento informada deve ser anterior ao dia atual.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo Ativo não pode estar nulo.")
    private Boolean ativo;
}
