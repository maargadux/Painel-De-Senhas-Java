import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PainelDeSenhas {
    private List<String> senhasNormais;
    private List<String> senhasPrioritarias;
    private int contadorSenhasNormais;
    private int contadorSenhasPrioritarias;
    private boolean painelReinicializado;

    public PainelDeSenhas() {
        senhasNormais = new ArrayList<>();
        senhasPrioritarias = new ArrayList<>();
        contadorSenhasNormais = 0;
        contadorSenhasPrioritarias = 0;
        painelReinicializado = true;
    }

    public void gerarSenhaNormal() {
        String senha = "N" + String.format("%03d", contadorSenhasNormais++);
        senhasNormais.add(senha);
    }

    public void gerarSenhaPrioritaria() {
        String senha = "P" + String.format("%03d", contadorSenhasPrioritarias++);
        senhasPrioritarias.add(senha);
    }

    public void chamarSenha() {
        List<String> todasSenhas = new ArrayList<>(senhasNormais);
        todasSenhas.addAll(senhasPrioritarias);
        Collections.shuffle(todasSenhas);
        String senhaChamada = todasSenhas.remove(0);
        System.out.println("Senha chamada: " + senhaChamada);
    }

    public void mostrarPainel() {
        System.out.println("Painel de Senhas:");
        System.out.println("Senhas Normais:");
        for (String senha : senhasNormais) {
            System.out.println(senha);
        }
        System.out.println("Senhas Prioritárias:");
        for (String senha : senhasPrioritarias) {
            System.out.println(senha);
        }
    }

    public void reinicializarPainel() {
        senhasNormais.clear();
        senhasPrioritarias.clear();
        contadorSenhasNormais = 0;
        contadorSenhasPrioritarias = 0;
        painelReinicializado = true;
        System.out.println("Painel de Senhas reinicializado.");
    }

    public static void main(String[] args) {
        PainelDeSenhas painel = new PainelDeSenhas();

        painel.gerarSenhaNormal();
        painel.gerarSenhaNormal();
        painel.gerarSenhaPrioritaria();
        painel.gerarSenhaPrioritaria();

        painel.mostrarPainel();

        painel.chamarSenha();
        painel.chamarSenha();

        painel.reinicializarPainel();

        painel.mostrarPainel();
    }
}
