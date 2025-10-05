package org.example;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValidadorPedidoTest {

    @Mock
    private RepositorioCliente repositorioClienteMock;

    @Mock
    private LoggerPort loggerPortMock;

    @InjectMocks
    ValidadorPedido validadorPedido;


    @Test
    public void clientShouldApproved() {
        ValidadorPedido.Pessoa cliente = new ValidadorPedido.Pessoa("Cliente Bom", new BigDecimal("1000.00"));
        ValidadorPedido.Produto produto = new ValidadorPedido.Produto(10, new BigDecimal("600.00"));
        String estado = "RJ";

        String resultado = validadorPedido.validar(produto, cliente, estado);

        assertEquals("APROVADO", resultado);
    }

    @Test
    public void clientShouldErrorCreditLimitExceeded() {
        ValidadorPedido.Pessoa cliente = new ValidadorPedido.Pessoa("Cliente Regular", new BigDecimal("850.00"));
        ValidadorPedido.Produto produto = new ValidadorPedido.Produto(5, new BigDecimal("800.00"));
        String estado = "SP";

        String resultado = validadorPedido.validar(produto, cliente, estado);

        assertEquals("ERRO: Limite de crédito excedido.", resultado);
    }

    @Test
    public void clientShouldErrorBackList() {
        ValidadorPedido.Pessoa cliente = new ValidadorPedido.Pessoa("Cliente Problematico", new BigDecimal("2000.00"));
        ValidadorPedido.Produto produto = new ValidadorPedido.Produto(1, new BigDecimal("100.00"));
        String estado = "MG";

        when(repositorioClienteMock.isClienteNaListaNegra("Cliente Problematico")).thenReturn(true);
        String resultado = validadorPedido.validar(produto, cliente, estado);

        assertEquals("ERRO: Cliente na lista negra.", resultado);
    }


    @Test
    public void clientShouldErrorNonHaveStock() {
        ValidadorPedido.Pessoa cliente = new ValidadorPedido.Pessoa("Cliente Bom", new BigDecimal("1000.00"));
        ValidadorPedido.Produto produto = new ValidadorPedido.Produto(0, new BigDecimal("600.00"));
        String estado = "RJ";

        String resultado = validadorPedido.validar(produto, cliente, estado);

        assertEquals("ERRO: Pedido com estoque zerado.", resultado);

    }

    @Test
    public void clientShouldUseFixTax() {
        ValidadorPedido.Pessoa cliente = new ValidadorPedido.Pessoa("Cliente Bom", new BigDecimal("400.00"));
        ValidadorPedido.Produto produto = new ValidadorPedido.Produto(10, new BigDecimal("334.00"));
        String estado = "RJ";

        String resultado = validadorPedido.validar(produto, cliente, estado);

        assertEquals("APROVADO", resultado);
        verify(loggerPortMock, times(3)).log(anyString());
    }

}