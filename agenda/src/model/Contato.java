package model;

public class Contato {

    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;

    public Contato(String nome, String sobrenome, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return STR."""

                ############################
                ##### DADOS DO CONTATO #####
                ############################

                Nome: \{nome} \{sobrenome}
                Telefone: \{telefone}
                E-mail: \{email}
                """;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setsobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
