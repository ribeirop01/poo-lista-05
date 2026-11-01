interface AparelhoTelefonico {
    void ligar();
    void atender();
}

interface NavegadorInternet {
    void exibirPagina();
    void adicionarNovaAba();
}

interface ReprodutorMusical {
    void tocar();
    void pausar();
}

class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    @Override public void ligar() { System.out.println("Ligando para o contato..."); }
    @Override public void atender() { System.out.println("Chamada atendida."); }
    @Override public void exibirPagina() { System.out.println("Exibindo a pagina www.exemplo.com"); }
    @Override public void adicionarNovaAba() { System.out.println("Nova aba adicionada."); }
    @Override public void tocar() { System.out.println("Tocando musica..."); }
    @Override public void pausar() { System.out.println("Musica pausada."); }
}

public class Main {
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.ligar();
        s.atender();
        s.exibirPagina();
        s.adicionarNovaAba();
        s.tocar();
        s.pausar();

        // Polimorfismo: o mesmo objeto visto por cada interface
        ReprodutorMusical player = s;
        player.tocar();
    }
}
