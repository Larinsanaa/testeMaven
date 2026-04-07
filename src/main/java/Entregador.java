/**
 * Classe que representa um entregador do sistema
 */
public class Entregador {
    private String nome;
    private String veiculo;
    private String placa;
    private String telefone;
    private boolean emEntrega;

    /**
     * Construtor obrigatório
     * @param nome Nome do entregador
     * @param veiculo Tipo de veículo (moto, bicicleta, carro)
     * @param telefone Telefone do entregador
     */
    public Entregador(String nome, String veiculo, String telefone) {
        this.nome = nome;
        this.veiculo = veiculo;
        this.telefone = telefone;
        this.placa = "";
        this.emEntrega = false;
    }

    /**
     * Construtor completo
     */
    public Entregador(String nome, String veiculo, String placa, String telefone) {
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.telefone = telefone;
        this.emEntrega = false;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isEmEntrega() {
        return emEntrega;
    }

    /**
     * Aceita uma entrega
     * @param pedido Pedido a ser entregue
     */
    public void aceitarEntrega(Pedido pedido) {
        if (!emEntrega) {
            emEntrega = true;
            System.out.println("\n" + nome + " aceitou a entrega do pedido #" + pedido.getNumero());
            pedido.atualizarStatus(Pedido.STATUS_SAIU_ENTREGA);
        } else {
            System.out.println(nome + " já está em uma entrega.");
        }
    }

    /**
     * Finaliza a entrega
     */
    public void finalizarEntrega() {
        if (emEntrega) {
            emEntrega = false;
            System.out.println(nome + " finalizou a entrega.");
        }
    }

    /**
     * Exibe informações do entregador
     */
    public void exibirInformacoes() {
        System.out.println("\n=== INFORMAÇÕES DO ENTREGADOR ===");
        System.out.println("Nome: " + nome);
        System.out.println("Veículo: " + veiculo);
        if (!placa.isEmpty()) {
            System.out.println("Placa: " + placa);
        }
        System.out.println("Telefone: " + telefone);
        System.out.println("Status: " + (emEntrega ? "Em entrega" : "Disponível"));
    }

    @Override
    public String toString() {
        return nome + " (" + veiculo + ") - " + (emEntrega ? "Ocupado" : "Disponível");
    }
}
