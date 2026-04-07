/**
 * Classe Bebida - Herda de ItemCardapio
 * Representa uma bebida do cardápio
 */
public class Bebida extends ItemCardapio {
    private String tamanho; // 300ml, 500ml, 1L, etc.
    private boolean gelada;

    /**
     * Construtor obrigatório
     * @param nome Nome da bebida
     * @param preco Preço da bebida
     * @param tamanho Tamanho da bebida
     */
    public Bebida(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
        this.gelada = true; // padrão: gelada
    }

    /**
     * Construtor completo
     */
    public Bebida(String nome, String descricao, double preco, String tamanho, boolean gelada) {
        super(nome, descricao, preco);
        this.tamanho = tamanho;
        this.gelada = gelada;
    }

    // Getters e Setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isGelada() {
        return gelada;
    }

    public void setGelada(boolean gelada) {
        this.gelada = gelada;
    }

    /**
     * Implementação polimórfica de exibirDetalhes()
     * Sobrescreve o método da classe pai
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║           DETALHES DA BEBIDA           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Descrição: " + (descricao.isEmpty() ? "N/A" : descricao));
        System.out.println("Temperatura: " + (gelada ? "Gelada" : "Natural"));
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("════════════════════════════════════════\n");
    }

    /**
     * Calcula preço baseado no tamanho
     * Sobrescreve o método da classe pai
     */
    @Override
    public double calcularPreco() {
        double precoFinal = preco;

        // Ajusta preço baseado no tamanho
        if (tamanho.contains("1L") || tamanho.contains("1000ml")) {
            precoFinal += 3.00;
        } else if (tamanho.contains("500ml")) {
            precoFinal += 1.50;
        }

        return precoFinal;
    }

    @Override
    public String toString() {
        return "[Bebida] " + nome + " (" + tamanho + ") - R$ " + String.format("%.2f", calcularPreco())
               + (gelada ? " - Gelada" : " - Natural");
    }
}
