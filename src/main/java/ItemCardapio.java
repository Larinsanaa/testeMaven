/**
 * Classe abstrata que representa um item genérico do cardápio
 * Serve como base para Prato, Bebida e Sobremesa
 */
public abstract class ItemCardapio {
    protected String nome;
    protected String descricao;
    protected double preco;
    protected boolean disponivel;

    /**
     * Construtor
     * @param nome Nome do item
     * @param preco Preço do item
     */
    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = "";
        this.disponivel = true;
    }

    /**
     * Construtor completo
     */
    public ItemCardapio(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = true;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Aplica desconto no preço
     * @param percentual Percentual de desconto (0-100)
     */
    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            this.preco = this.preco - (this.preco * percentual / 100);
        }
    }

    /**
     * Calcula o preço do item (pode ser sobrescrito)
     * @return Preço do item
     */
    public double calcularPreco() {
        return this.preco;
    }

    /**
     * Exibe detalhes do item (método abstrato - deve ser implementado pelas subclasses)
     * Demonstra POLIMORFISMO
     */
    public abstract void exibirDetalhes();

    @Override
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", preco);
    }
}
