import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do Sistema de Delivery
 * Demonstra todos os conceitos de POO: Classes, Objetos, Herança, Polimorfismo, Encapsulamento
 */
public class SistemaDelivery {

    private static List<ItemCardapio> cardapio = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static int proximoNumeroPedido = 1;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE DELIVERY - APP FOOD     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Inicializar cardápio
        inicializarCardapio();

        // Demonstração do sistema
        demonstracaoSistema();

        // Menu interativo (opcional)
        // menuInterativo();
    }

    /**
     * Inicializa o cardápio com itens de exemplo
     * Demonstra: HERANÇA - Prato, Bebida e Sobremesa herdam de ItemCardapio
     */
    private static void inicializarCardapio() {
        System.out.println(">>> Inicializando cardápio...\n");

        // Criando PRATOS (herda de ItemCardapio)
        Prato prato1 = new Prato("Pizza Margherita",
            "Pizza tradicional com molho de tomate, mussarela e manjericão",
            35.00, 30, "Massas");

        Prato prato2 = new Prato("Hambúrguer Artesanal",
            "Hambúrguer de 200g com queijo, alface, tomate e molho especial",
            28.00, 25, "Lanches");

        Prato prato3 = new Prato("Risoto de Funghi",
            "Risoto cremoso com cogumelos variados",
            42.00, 50, "Massas");

        // Criando BEBIDAS (herda de ItemCardapio)
        Bebida bebida1 = new Bebida("Coca-Cola",
            "Refrigerante Coca-Cola",
            5.00, "350ml", true);

        Bebida bebida2 = new Bebida("Suco de Laranja",
            "Suco natural de laranja",
            8.00, "500ml", true);

        Bebida bebida3 = new Bebida("Água Mineral",
            "Água mineral sem gás",
            3.00, "500ml", false);

        // Criando SOBREMESAS (herda de ItemCardapio)
        Sobremesa sobremesa1 = new Sobremesa("Petit Gateau",
            "Bolinho de chocolate quente com sorvete",
            18.00, 320, false);

        Sobremesa sobremesa2 = new Sobremesa("Mousse de Maracujá",
            "Mousse leve de maracujá",
            12.00, 180, false);

        Sobremesa sobremesa3 = new Sobremesa("Salada de Frutas Light",
            "Mix de frutas frescas",
            10.00, 90, true);

        // Adicionando ao cardápio
        cardapio.add(prato1);
        cardapio.add(prato2);
        cardapio.add(prato3);
        cardapio.add(bebida1);
        cardapio.add(bebida2);
        cardapio.add(bebida3);
        cardapio.add(sobremesa1);
        cardapio.add(sobremesa2);
        cardapio.add(sobremesa3);

        System.out.println("✓ Cardápio inicializado com sucesso!\n");
    }

    /**
     * Demonstra o funcionamento completo do sistema
     * Demonstra: POLIMORFISMO, HERANÇA, ENCAPSULAMENTO
     */
    private static void demonstracaoSistema() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      DEMONSTRAÇÃO DO SISTEMA           ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ===== DEMONSTRAÇÃO 1: POLIMORFISMO NO CARDÁPIO =====
        System.out.println("═══ 1. EXIBINDO CARDÁPIO (Polimorfismo) ═══\n");
        System.out.println(">>> Demonstração de POLIMORFISMO:");
        System.out.println(">>> Cada tipo de item exibe detalhes de forma diferente\n");

        for (ItemCardapio item : cardapio) {
            // POLIMORFISMO: o método exibirDetalhes() é chamado de forma diferente
            // dependendo do tipo real do objeto (Prato, Bebida ou Sobremesa)
            item.exibirDetalhes();
        }

        // ===== DEMONSTRAÇÃO 2: CRIANDO CLIENTE =====
        System.out.println("\n═══ 2. CADASTRANDO CLIENTE ═══\n");
        Cliente cliente1 = new Cliente("Maria Silva",
            "(11) 98765-4321",
            "Rua das Flores, 123 - Centro");
        cliente1.setEmail("maria.silva@email.com");
        cliente1.exibirInformacoes();

        // ===== DEMONSTRAÇÃO 3: CRIANDO PEDIDO =====
        System.out.println("\n═══ 3. CRIANDO PEDIDO ═══\n");
        Pedido pedido1 = new Pedido(proximoNumeroPedido++, cliente1);

        // Adicionando itens ao pedido
        System.out.println(">>> Adicionando itens ao pedido...\n");
        pedido1.adicionarItem(cardapio.get(0)); // Pizza
        pedido1.adicionarItem(cardapio.get(3)); // Coca-Cola
        pedido1.adicionarItem(cardapio.get(6)); // Petit Gateau

        // Exibir resumo do pedido
        pedido1.exibirResumo();

        // ===== DEMONSTRAÇÃO 4: POLIMORFISMO - CÁLCULO DE PREÇO =====
        System.out.println("\n═══ 4. CÁLCULO DE PREÇO (Polimorfismo) ═══\n");
        System.out.println(">>> Cada tipo de item calcula o preço de forma diferente:\n");

        for (ItemCardapio item : pedido1.getItens()) {
            System.out.println(item.getNome() + ":");
            System.out.println("  Tipo: " + item.getClass().getSimpleName());
            System.out.println("  Preço calculado: R$ " + String.format("%.2f", item.calcularPreco()));
            System.out.println();
        }

        // ===== DEMONSTRAÇÃO 5: APLICANDO DESCONTO =====
        System.out.println("\n═══ 5. APLICANDO DESCONTO ═══\n");
        System.out.println(">>> Aplicando 10% de desconto na Pizza...\n");
        cardapio.get(0).aplicarDesconto(10);
        pedido1.calcularTotal();
        pedido1.exibirResumo();

        // ===== DEMONSTRAÇÃO 6: ATUALIZANDO STATUS DO PEDIDO =====
        System.out.println("\n═══ 6. ACOMPANHAMENTO DO PEDIDO ═══\n");
        pedido1.atualizarStatus(Pedido.STATUS_EM_PREPARO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ===== DEMONSTRAÇÃO 7: CRIANDO ENTREGADOR E ENTREGA =====
        System.out.println("\n═══ 7. SISTEMA DE ENTREGA ═══\n");
        Entregador entregador1 = new Entregador("João Santos",
            "Moto",
            "ABC-1234",
            "(11) 91234-5678");
        entregador1.exibirInformacoes();

        Entrega entrega1 = new Entrega(pedido1, entregador1);
        entrega1.exibirInformacoes();

        System.out.println("\n>>> Iniciando entrega...\n");
        entrega1.iniciar();

        // ===== DEMONSTRAÇÃO 8: FINALIZANDO ENTREGA =====
        System.out.println("\n═══ 8. FINALIZANDO ENTREGA ═══\n");
        entrega1.atualizarStatus(Entrega.STATUS_CONCLUIDA);

        // ===== DEMONSTRAÇÃO 9: SEGUNDO PEDIDO =====
        System.out.println("\n\n═══ 9. CRIANDO SEGUNDO PEDIDO ═══\n");
        Cliente cliente2 = new Cliente("Carlos Oliveira",
            "(11) 97654-3210",
            "Av. Paulista, 1000 - Bela Vista");

        Pedido pedido2 = new Pedido(proximoNumeroPedido++, cliente2);
        pedido2.adicionarItem(cardapio.get(1)); // Hambúrguer
        pedido2.adicionarItem(cardapio.get(4)); // Suco
        pedido2.exibirResumo();

        // ===== RESUMO FINAL =====
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         RESUMO DA DEMONSTRAÇÃO         ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        System.out.println("✓ CONCEITOS DE POO DEMONSTRADOS:\n");
        System.out.println("1. CLASSES E OBJETOS:");
        System.out.println("   - Criamos objetos de várias classes (Cliente, Pedido, Prato, etc.)\n");

        System.out.println("2. HERANÇA:");
        System.out.println("   - Prato, Bebida e Sobremesa herdam de ItemCardapio");
        System.out.println("   - Compartilham atributos e métodos da classe pai\n");

        System.out.println("3. POLIMORFISMO:");
        System.out.println("   - exibirDetalhes() funciona diferente para cada tipo");
        System.out.println("   - calcularPreco() tem implementação específica por tipo");
        System.out.println("   - Tratamos todos como ItemCardapio no pedido\n");

        System.out.println("4. ENCAPSULAMENTO:");
        System.out.println("   - Atributos privados/protegidos");
        System.out.println("   - Acesso através de getters/setters\n");

        System.out.println("5. CONSTRUTORES:");
        System.out.println("   - Cada classe define informações obrigatórias");
        System.out.println("   - Garantem criação correta dos objetos\n");

        System.out.println("═══════════════════════════════════════════");
        System.out.println("      Total de pedidos: " + (proximoNumeroPedido - 1));
        System.out.println("      Itens no cardápio: " + cardapio.size());
        System.out.println("═══════════════════════════════════════════\n");
    }

    /**
     * Menu interativo (opcional - descomente no main para usar)
     */
    @SuppressWarnings("unused")
    private static void menuInterativo() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║           MENU PRINCIPAL               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Ver cardápio");
            System.out.println("2. Fazer pedido");
            System.out.println("3. Ver pedidos");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    exibirCardapio();
                    break;
                case 2:
                    fazerPedido(scanner);
                    break;
                case 3:
                    exibirPedidos();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\nObrigado por usar o sistema!");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }

        scanner.close();
    }

    private static void exibirCardapio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              CARDÁPIO                  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i).toString());
        }
    }

    private static void fazerPedido(Scanner scanner) {
        System.out.print("\nNome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, telefone, endereco);
        Pedido pedido = new Pedido(proximoNumeroPedido++, cliente);

        boolean adicionandoItens = true;
        while (adicionandoItens) {
            exibirCardapio();
            System.out.print("\nEscolha um item (0 para finalizar): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 0) {
                adicionandoItens = false;
            } else if (escolha > 0 && escolha <= cardapio.size()) {
                pedido.adicionarItem(cardapio.get(escolha - 1));
            } else {
                System.out.println("Opção inválida!");
            }
        }

        pedidos.add(pedido);
        pedido.exibirResumo();
    }

    private static void exibirPedidos() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            PEDIDOS REALIZADOS          ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
        } else {
            for (Pedido pedido : pedidos) {
                pedido.exibirResumo();
            }
        }
    }
}
