import java.util.List;

interface Imprimivel {
    void imprimir();
}

interface EnviavelPorEmail {
    void enviar(String email);
}

class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail {
    @Override public void imprimir() { System.out.println("Imprimindo Relatorio Financeiro"); }
    @Override public void enviar(String email) { System.out.println("Enviando Relatorio Financeiro para " + email); }
}

class Contrato implements Imprimivel {
    @Override public void imprimir() { System.out.println("Imprimindo Contrato"); }
}

public class Main {
    public static void main(String[] args) {
        List<Imprimivel> documentos = List.of(
            new RelatorioFinanceiro(), new Contrato(), new RelatorioFinanceiro());

        // Versao 1: instanceof (com pattern matching, Java 16+)
        System.out.println("=== Com instanceof ===");
        for (Imprimivel doc : documentos) {
            doc.imprimir();
            if (doc instanceof EnviavelPorEmail e) {
                e.enviar("cliente@empresa.com");
            }
        }

        // Versao 2: design melhor - cada lista trabalha so com sua interface
        System.out.println("\n=== Sem instanceof ===");
        List<Imprimivel> paraImprimir = List.of(new RelatorioFinanceiro(), new Contrato());
        List<EnviavelPorEmail> paraEnviar = List.of(new RelatorioFinanceiro());

        paraImprimir.forEach(Imprimivel::imprimir);
        paraEnviar.forEach(d -> d.enviar("cliente@empresa.com"));
    }
}
