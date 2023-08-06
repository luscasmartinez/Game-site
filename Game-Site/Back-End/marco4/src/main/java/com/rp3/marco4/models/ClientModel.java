package com.rp3.marco4.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLIENT")
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // Nome, E-mail, Senha, Data de Nascimento, Plataforma(s) que Possui, Gênero(s)
    // de Preferência e Endereço
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 70)
    private String nome;
    @Column(nullable = false, unique = true, length = 70) // email unico
    private String email;
    @Column(nullable = false, length = 70)
    private String senha;
    @Column(nullable = false, length = 70)
    private String data_nascimento;
    @Column(nullable = false, length = 70)
    private String plataformas_possui;
    @Column(nullable = false, length = 70)
    private String genero_preferido;
    @Column(nullable = false, length = 70)
    private String endereco;

    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nome: " + nome + ", E-mail: " + email + ", Senha: " + senha
                + ", Nascimento: " + data_nascimento + ", Plataformas que Possui: " + plataformas_possui
                + ", Gênero Preferido: " + genero_preferido + ", Endereço: " + endereco + "]";
    }

    /**
     * @return LocalDateTime return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return String return the plataformas_possui
     */
    public String getPlataformas_possui() {
        return plataformas_possui;
    }

    /**
     * @param plataformas_possui the plataformas_possui to set
     */
    public void setPlataformas_possui(String plataformas_possui) {
        this.plataformas_possui = plataformas_possui;
    }

    /**
     * @return String return the generoProferido
     */
    public String getGenero_preferido() {
        return genero_preferido;
    }

    /**
     * @param generoProferido the generoProferido to set
     */
    public void setGenero_preferido(String generoProferido) {
        this.genero_preferido = generoProferido;
    }

    /**
     * @return String return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}