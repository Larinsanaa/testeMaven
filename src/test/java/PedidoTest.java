import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoTest {

    private Pedido pedido;
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente("Maria", "999887766", "Rua das Flores, 42");
        pedido = new Pedido(1, cliente);
    }

    @Test
    public void testNumeroPedido() {
        assertEquals(1, pedido.getNumero());
    }

    @Test
    public void testClienteDoPedido() {
        assertEquals("Maria", pedido.getCliente().getNome());
    }

    @Test
    public void testStatusInicial() {
        assertEquals(Pedido.STATUS_AGUARDANDO, pedido.getStatus());
    }

    @Test
    public void testValorInicialZero() {
        assertEquals(0.0, pedido.getValorTotal(), 0.01);
    }

    @Test
    public void testMudancaDeStatus() {
        pedido.atualizarStatus(Pedido.STATUS_EM_PREPARO);
        assertEquals(Pedido.STATUS_EM_PREPARO, pedido.getStatus());
    }

    @Test
    public void testCancelamento() {
        assertTrue(pedido.podeCancelar());
        pedido.atualizarStatus(Pedido.STATUS_SAIU_ENTREGA);
        assertFalse(pedido.podeCancelar());
    }

    @Test
    public void testFalha() {
        assertEquals(1, 2);
    }
}
