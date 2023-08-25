package model;

import java.math.BigDecimal;

public class Venda {

    private Long operacao;
    private Long codigoCliente;
    private Integer quantidadeIngressos;
    private BigDecimal valorTotal;
    private String status;

    public Venda() {
    }
    public Venda(Long operacao, Long codigoCliente, Integer quantidadeIngressos, BigDecimal valorTotal, String status) {
        this.operacao = operacao;
        this.codigoCliente = codigoCliente;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getOperacao() {
        return operacao;
    }

    public void setOperacao(Long operacao) {
        this.operacao = operacao;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Integer getQuantidadeIngressos() {
        return quantidadeIngressos;
    }

    public void setQuantidadeIngressos(Integer quantidadeIngressos) {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "operacao=" + operacao +
                ", codigoCliente=" + codigoCliente +
                ", quantidadeIngressos=" + quantidadeIngressos +
                ", valorTotal=" + valorTotal +
                ", status='" + status + '\'' +
                '}';
    }
}
