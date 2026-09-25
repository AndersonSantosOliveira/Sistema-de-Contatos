public class Contato {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    public Contato(String cpf, String nome, String email, String telefone) {
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCampo(cpf, "CPF");
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCampo(nome, "Nome");
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarCampo(email, "E-mail");
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
 validarCampo(telefone, "telefone");
        this.telefone = telefone;
    }

    private void validarCampo(String valor, String nomeCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(nomeCampo + " não pode ser nulo ou vazio");
        }
    }

    @Override
    public String toString() {
        return "Contato{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
