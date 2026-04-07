import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um pedido no sistema de delivery
 */
public class Pedido {
    private int numero;
    private Cliente cliente;
    private List<ItemCardapio> itens;
    private String status;
    private LocalDateTime dataHora;
    private double valorTotal;

    // Status possíveis do pedido
    public static final String STATUS_AGUARDANDO = "Aguardando confirmação";
    public static final String STATUS_EM_PREPARO = "Em preparo";
    public static final String STATUS_SAIU_ENTREGA = "Saiu para entrega";
    public static final String STATUS_ENTREGUE = "Entregue";
    public static final String STATUS_CANCELADO = "Cancelado";

    /**
     * Construtor obrigatório
     * @param numero Número do pedido
     * @param cliente Cliente que fez o pedido
     */
    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = STATUS_AGUARDANDO;
        this.dataHora = LocalDateTime.now();
        this.valorTotal = 0.0;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Adiciona item ao pedido
     * @param item Item a ser adicionado
     */
    public void adicionarItem(ItemCardapio item) {
        if (item.isDisponivel()) {
            itens.add(item);
            calcularTotal();
            System.out.println(item.getNome() + " adicionado ao pedido.");
        } else {
            System.out.println("Item " + item.getNome() + " não está disponível.");
        }
    }

    /**
     * Remove item do pedido
     * @param item Item a ser removido
     */
    public void removerItem(ItemCardapio item) {
        if (itens.remove(item)) {
            calcularTotal();
            System.out.println(item.getNome() + " removido do pedido.");
        } else {
            System.out.println("Item não encontrado no pedido.");
        }
    }

    /**
     * Calcula o valor total do pedido
     */
    public void calcularTotal() {
        valorTotal = 0.0;
        for (ItemCardapio item : itens) {
            valorTotal += item.calcularPreco();
        }
    }

    /**
     * Atualiza o status do pedido
     * @param novoStatus Novo status
     */
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Status do pedido #" + numero + " atualizado para: " + novoStatus);
    }

    /**
     * Exibe resumo completo do pedido
     */
    public void exibirResumo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         RESUMO DO PEDIDO #" + numero + "          ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("\nCliente: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Data/Hora: " + dataHora.format(formatter));
        System.out.println("Status: " + status);

        System.out.println("\n--- ITENS DO PEDIDO ---");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item no pedido.");
        } else {
            int contador = 1;
            for (ItemCardapio item : itens) {
                System.out.println(contador + ". " + item.toString());
                contador++;
            }
        }

        System.out.println("\n--- VALOR TOTAL ---");
        System.out.println("R$ " + String.format("%.2f", valorTotal));
        System.out.println("════════════════════════════════════════\n");
    }

    /**
     * Verifica se o pedido pode ser cancelado
     */
    public boolean podeCancelar() {
        return !status.equals(STATUS_SAIU_ENTREGA) && !status.equals(STATUS_ENTREGUE);
    }

    @Override
    public String toString() {
        return "Pedido #" + numero + " - " + cliente.getNome() + " - " + status;
    }
}
