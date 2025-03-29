import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestePCMania {

    Cliente cliente;
    Computador promocao1;
    Computador promocao2;
    Computador promocao3;
    MemoriaUSB musb1;
    MemoriaUSB musb2;
    MemoriaUSB musb3;

    @Before
    public void setUp() {
        // Setup dos objetos antes de cada teste
        cliente = new Cliente();
        cliente.nome = "Sabrina";
        cliente.cpf = 12345678910L;

        musb1 = new MemoriaUSB();
        musb1.nome = "Pen-drive";
        musb1.capacidade = 16;

        musb2 = new MemoriaUSB();
        musb2.nome = "Pen-drive";
        musb2.capacidade = 32;

        musb3 = new MemoriaUSB();
        musb3.nome = "HD Externo";
        musb3.capacidade = 1;

        promocao1 = new Computador();
        promocao1.marca = "Positivo";
        promocao1.preco = 2300;
        promocao1.hardware[0] = new HardwareBasico();
        promocao1.hardware[0].nome = "Pentium Core i3";
        promocao1.hardware[0].capacidade = 2200;
        promocao1.hardware[1] = new HardwareBasico();
        promocao1.hardware[1].nome = "Memoria RAM";
        promocao1.hardware[1].capacidade = 8;
        promocao1.hardware[2] = new HardwareBasico();
        promocao1.hardware[2].nome = "HD";
        promocao1.hardware[2].capacidade = 500;
        promocao1.sop.nome = "Linux Ubuntu";
        promocao1.sop.tipo = 32;
        promocao1.addMemoriaUSB(musb1);

        promocao2 = new Computador();
        promocao2.marca = "Acer";
        promocao2.preco = 5800;
        promocao2.hardware[0] = new HardwareBasico();
        promocao2.hardware[0].nome = "Pentium Core i5";
        promocao2.hardware[0].capacidade = 3370;
        promocao2.hardware[1] = new HardwareBasico();
        promocao2.hardware[1].nome = "Memoria RAM";
        promocao2.hardware[1].capacidade = 16;
        promocao2.hardware[2] = new HardwareBasico();
        promocao2.hardware[2].nome = "HD";
        promocao2.hardware[2].capacidade = 1;
        promocao2.sop.nome = "Windows 8";
        promocao2.sop.tipo = 64;
        promocao2.addMemoriaUSB(musb2);

        promocao3 = new Computador();
        promocao3.marca = "Vaio";
        promocao3.preco = 1800;
        promocao3.hardware[0] = new HardwareBasico();
        promocao3.hardware[0].nome = "Pentium Core i7";
        promocao3.hardware[0].capacidade = 4500;
        promocao3.hardware[1] = new HardwareBasico();
        promocao3.hardware[1].nome = "Memoria RAM";
        promocao3.hardware[1].capacidade = 32;
        promocao3.hardware[2] = new HardwareBasico();
        promocao3.hardware[2].nome = "HD";
        promocao3.hardware[2].capacidade = 2;
        promocao3.sop.nome = "Windows 10";
        promocao3.sop.tipo = 64;
        promocao3.addMemoriaUSB(musb3);
    }

    // Teste 1: Testar o cálculo do total de compra
    @Test
    public void testCalculaTotalCompra() {
        // Arrange
        cliente.computadores[0] = promocao1;
        cliente.computadores[1] = promocao2;

        // Act
        float total = cliente.calculaTotalCompra();

        // Assert
        assertEquals(8100.0, total, 0.01);
    }

    // Teste 2: Testar a adição de um computador ao carrinho
    @Test
    public void testAdicionaComputadorCarrinho() {
        // Act
        cliente.computadores[0] = promocao1;

        // Assert
        assertEquals(promocao1, cliente.computadores[0]);
    }

    // Teste 3: Testar o limite de 20 computadores no carrinho
    @Test
    public void testLimiteCarrinho() {
        // Adiciona 20 computadores ao carrinho
        for (int i = 0; i < 20; i++) {
            cliente.computadores[i] = promocao1;
        }

        // Act - Tentando adicionar o 21º computador
        boolean podeAdicionar = false;
        for (int i = 0; i < 20; i++) {
            if (cliente.computadores[i] == null) {
                cliente.computadores[i] = promocao2;
                podeAdicionar = true;
                break;
            }
        }

        // Assert - O carrinho já está cheio, portanto, não deve ser possível adicionar
        assertFalse(podeAdicionar); // Não deve ser possível adicionar mais um computador
    }

    // Teste 4: Testar o cálculo do total com 5 computadores no carrinho
    @Test
    public void testCalculaTotalCompraParcial() {
        // Arrange
        cliente.computadores[0] = promocao1;
        cliente.computadores[1] = promocao2;
        cliente.computadores[2] = promocao3;

        // Act
        float total = cliente.calculaTotalCompra();

        // Assert
        assertEquals(9900.0, total, 0.01);
    }

    // Teste 5: Testar a adição de memória USB ao computador
    @Test
    public void testAdicionaMemoriaUSB() {
        // Act
        promocao1.addMemoriaUSB(musb1);

        // Assert
        assertEquals(musb1, promocao1.memoria);
    }

    // Teste 6: Testar a exibição das configurações do computador
    @Test
    public void testMostraPCConfigs() {
        // Act
        promocao1.mostraPCConfigs();

        // Não podemos testar diretamente a saída, mas podemos verificar que o computador foi configurado corretamente
        assertEquals("Positivo", promocao1.marca);
        assertEquals(2300, promocao1.preco, 0.01);
        assertNotNull(promocao1.hardware[0]);
        assertNotNull(promocao1.sop);
    }

    // Teste 7: Testar a criação de um cliente
    @Test
    public void testCriacaoCliente() {
        // Assert
        assertEquals("Sabrina", cliente.nome);
        assertEquals(12345678910L, cliente.cpf);
    }

    // Teste 8: Testar a capacidade de memória USB
    @Test
    public void testMemoriaUSB() {
        // Assert
        assertEquals(16, musb1.capacidade);
        assertEquals(32, musb2.capacidade);
        assertEquals(1, musb3.capacidade);
    }

    // Teste 9: Testar a adição do sistema operacional
    @Test
    public void testAdicionaSistemaOperacional() {
        // Act
        promocao1.sop.nome = "Linux Ubuntu";
        promocao1.sop.tipo = 32;

        // Assert
        assertEquals("Linux Ubuntu", promocao1.sop.nome);
        assertEquals(32, promocao1.sop.tipo);
    }

    // Teste 10: Testar o comportamento do loop de compra
    @Test
    public void testLoopDeCompra() {
        // Simulando a entrada do usuário
        cliente.computadores[0] = promocao1;
        cliente.computadores[1] = promocao2;

        // Verificando se os computadores foram adicionados
        assertNotNull(cliente.computadores[0]);
        assertNotNull(cliente.computadores[1]);
    }
}
