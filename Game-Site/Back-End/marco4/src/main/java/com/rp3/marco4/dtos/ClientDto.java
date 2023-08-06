package com.rp3.marco4.dtos;

import jakarta.validation.constraints.NotBlank;

public class ClientDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String data_nascimento;
    @NotBlank
    private String plataformas_possui;
    @NotBlank
    private String genero_preferido;
    @NotBlank
    private String endereco;

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

    /**
     * @return String return the data_nascimento
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

}
