import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    //METODO RESPONSAVEL POR CADASTRAR USUARIOS / CONTATO
    public boolean cadastrar(Contato contato) {
        for (Contato C : contatos) {
            if (C.getCpf().equals(contato.getCpf())) {
                return false;
            }
        }
        contatos.add(contato);
        return true;
    }

    //METODO RESPONSAVEL POR BUSCAR CONTATOS ESPECIFICO DA LISTA
    public Contato buscarContato(String cpf) {

        return contatos.stream().filter(C -> C.getCpf().equals(cpf)).
                findFirst().orElse(null);
    }


    //METODO RESPONSAVEL DE EXCLUIR UM CONTATO ESPECIFICO DA LISTA
    public boolean excluirContato(String cpf) {
        Contato c = buscarContato(cpf);

        if (c == null) {
            return false;

        } else {
            contatos.remove(c);
            return true;
        }
    }

    public List<Contato> listarContatos() {
        return new ArrayList<>(contatos);
    }
}

