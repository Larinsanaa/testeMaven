/**
 * Classe que representa o processo de entrega de um pedido
 */
public class Entrega {
    private Pedido pedido;
    private Entregador entregador;
    private String status;
    private int tempoEstimado; // em minutos

    // Status possíveis da entrega
    public static final String STATUS_AGUARDANDO = "Aguardando entregador";
    public static final String STATUS_EM_ROTA = "Em rota de entrega";
    public static final String STATUS_CONCLUIDA = "Entrega concluída";

    /**
     * Construtor obrigatório
     * @param pedido Pedido a ser entregue
     * @param entregador Entregador responsável
     */
    public Entrega(Pedido pedido, Entregador entregador) {
        this.pedido = pedido;
        this.entregador = entregador;
        this.status = STATUS_AGUARDANDO;
        this.tempoEstimado = calcularTempoEstimado();
    }

    // Getters e Setters
    public Pedido getPedido() {
        return pedido;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public String getStatus() {
        return status;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    /**
     * Inicia a entrega
     */
    public void iniciar() {
        if (status.equals(STATUS_AGUARDANDO)) {
            entregador.aceitarEntrega(pedido);
            atualizarStatus(STATUS_EM_ROTA);
            System.out.println("Tempo estimado de entrega: " + tempoEstimado + " minutos");
        } else {
            System.out.println("Entrega já foi iniciada.");
        }
    }

    /**
     * Atualiza o status da entrega
     * @param novoStatus Novo status
     */
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Status da entrega atualizado para: " + novoStatus);

        // Se concluiu a entrega, atualiza o pedido e libera o entregador
        if (novoStatus.equals(STATUS_CONCLUIDA)) {
            pedido.atualizarStatus(Pedido.STATUS_ENTREGUE);
            entregador.finalizarEntrega();
        }
    }

    /**
     * Calcula tempo estimado de entrega
     * @return Tempo em minutos
     */
    public int calcularTempoEstimado() {
        // Tempo base de 30 minutos
        int tempo = 30;

        // Adiciona tempo de preparo dos pratos
        for (ItemCardapio item : pedido.getItens()) {
            if (item instanceof Prato) {
                Prato prato = (Prato) item;
                if (prato.getTempoPreparo() > tempo) {
                    tempo = prato.getTempoPreparo();
                }
            }
        }

        // Adiciona tempo de deslocamento baseado no veículo
        String veiculo = entregador.getVeiculo().toLowerCase();
        if (veiculo.contains("moto")) {
            tempo += 15;
        } else if (veiculo.contains("carro")) {
            tempo += 20;
        } else if (veiculo.contains("bicicleta")) {
            tempo += 25;
        }

        return tempo;
    }

    /**
     * Exibe informações da entrega
     */
    public void exibirInformacoes() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        INFORMAÇÕES DA ENTREGA          ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Pedido: #" + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Endereço: " + pedido.getCliente().getEndereco());
        System.out.println("Entregador: " + entregador.getNome());
        System.out.println("Veículo: " + entregador.getVeiculo());
        System.out.println("Status: " + status);
        System.out.println("Tempo estimado: " + tempoEstimado + " minutos");
        System.out.println("════════════════════════════════════════\n");
    }

    @Override
    public String toString() {
        return "Entrega do Pedido #" + pedido.getNumero() + " - " + entregador.getNome()
               + " - " + status;
    }
}
