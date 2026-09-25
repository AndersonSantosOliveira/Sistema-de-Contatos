import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListaContatos extends JDialog {

    public TelaListaContatos(JFrame parent, Agenda agenda) {
        super(parent, "Lista de Contatos", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);

        String[] colunas = {"CPF", "Nome", "E-mail", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        List<Contato> contatos = agenda.listarContatos();

        for (Contato c : contatos) {
            model.addRow(new Object[]{
                    c.getCpf(),
                    c.getNome(),
                    c.getEmail(),
                    c.getTelefone()
            });
        }

        JTable tabela = new JTable(model);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabela.setRowHeight(22);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);

        setVisible(true);
    }
}
