/**
 * Classe Prato - Herda de ItemCardapio
 * Representa uma refeição do cardápio
 */
public class Prato extends ItemCardapio {
    private int tempoPreparo; // em minutos
    private String categoria;

    /**
     * Construtor obrigatório
     * @param nome Nome do prato
     * @param preco Preço do prato
     * @param tempoPreparo Tempo de preparo em minutos
     * @param categoria Categoria do prato
     */
    public Prato(String nome, double preco, int tempoPreparo, String categoria) {
        super(nome, preco);
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    /**
     * Construtor completo
     */
    public Prato(String nome, String descricao, double preco, int tempoPreparo, String categoria) {
        super(nome, descricao, preco);
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Implementação polimórfica de exibirDetalhes()
     * Sobrescreve o método da classe pai
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            DETALHES DO PRATO           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Descrição: " + (descricao.isEmpty() ? "N/A" : descricao));
        System.out.println("Tempo de preparo: " + tempoPreparo + " minutos");
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("════════════════════════════════════════\n");
    }

    /**
     * Calcula preço - pode incluir taxas adicionais
     * Sobrescreve o método da classe pai
     */
    @Override
    public double calcularPreco() {
        // Exemplo: pratos com preparo longo podem ter um adicional
        double precoFinal = preco;
        if (tempoPreparo > 45) {
            precoFinal += 2.00; // taxa adicional
        }
        return precoFinal;
    }

    @Override
    public String toString() {
        return "[Prato] " + nome + " (" + categoria + ") - R$ " + String.format("%.2f", calcularPreco())
               + " - " + tempoPreparo + " min";
    }
}
