/**
 * Classe Sobremesa - Herda de ItemCardapio
 * Representa uma sobremesa do cardápio
 */
public class Sobremesa extends ItemCardapio {
    private int calorias;
    private boolean diet;

    /**
     * Construtor obrigatório
     * @param nome Nome da sobremesa
     * @param preco Preço da sobremesa
     * @param calorias Quantidade de calorias
     */
    public Sobremesa(String nome, double preco, int calorias) {
        super(nome, preco);
        this.calorias = calorias;
        this.diet = false; // padrão: não é diet
    }

    /**
     * Construtor completo
     */
    public Sobremesa(String nome, String descricao, double preco, int calorias, boolean diet) {
        super(nome, descricao, preco);
        this.calorias = calorias;
        this.diet = diet;
    }

    // Getters e Setters
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public boolean isDiet() {
        return diet;
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    /**
     * Implementação polimórfica de exibirDetalhes()
     * Sobrescreve o método da classe pai
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          DETALHES DA SOBREMESA         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + (descricao.isEmpty() ? "N/A" : descricao));
        System.out.println("Calorias: " + calorias + " kcal");
        System.out.println("Versão: " + (diet ? "Diet/Light" : "Tradicional"));
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("════════════════════════════════════════\n");
    }

    /**
     * Calcula preço - versão diet pode ter preço diferente
     * Sobrescreve o método da classe pai
     */
    @Override
    public double calcularPreco() {
        double precoFinal = preco;

        // Versão diet pode ter um pequeno acréscimo
        if (diet) {
            precoFinal += 1.00;
        }

        return precoFinal;
    }

    @Override
    public String toString() {
        return "[Sobremesa] " + nome + " - " + calorias + " kcal - R$ " + String.format("%.2f", calcularPreco())
               + (diet ? " (Diet)" : "");
    }
}
