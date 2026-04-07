/**
 * Classe que representa um cliente do sistema de delivery
 */
public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    /**
     * Construtor obrigatório
     * @param nome Nome do cliente
     * @param telefone Telefone do cliente
     * @param endereco Endereço de entrega
     */
    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = "";
    }

    /**
     * Construtor completo
     */
    public Cliente(String nome, String telefone, String endereco, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Atualiza o endereço do cliente
     */
    public void atualizarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
        System.out.println("Endereço atualizado para: " + novoEndereco);
    }

    /**
     * Exibe informações do cliente
     */
    public void exibirInformacoes() {
        System.out.println("\n=== INFORMAÇÕES DO CLIENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        if (!email.isEmpty()) {
            System.out.println("Email: " + email);
        }
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}
