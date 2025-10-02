package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.add(produto);
        } else {
            throw new IllegalStateException("Não é possível adicionar produto em pedido não pendente.");
        }
    }

    public void removerProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.remove(produto);
        } else {
            throw new IllegalStateException("Não é possível remover produto de pedido não pendente.");
        }
    }

    public void pagar() {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Pedido não pode ser pago.");
        }
        if (produtos.isEmpty()) {
            throw new IllegalStateException("Pedido não pode ser pago sem produtos.");
        }
        this.status = StatusPedido.PAGO;
    }

    public void cancelar() {
        if (status == StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido pago não pode ser cancelado.");
        }
        this.status = StatusPedido.CANCELADO;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }
}
