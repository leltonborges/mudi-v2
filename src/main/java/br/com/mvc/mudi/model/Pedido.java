package br.com.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal valorNegociado;

    private LocalDate dataDaEntrega;
    private String urlDoProduto;
    private String urlDaImagem;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private List<Oferta> ofertas;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id, String name, BigDecimal valorNegociado, LocalDate dataDaEntrega, String urlDoProduto, String urlDaImagem, String descricao, User user, StatusPedido status) {
        this.id = id;
        this.name = name;
        this.valorNegociado = valorNegociado;
        this.dataDaEntrega = dataDaEntrega;
        this.urlDoProduto = urlDoProduto;
        this.urlDaImagem = urlDaImagem;
        this.descricao = descricao;
        this.user = user;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getUrlDoProduto() {
        return urlDoProduto;
    }

    public void setUrlDoProduto(String urlDoProduto) {
        this.urlDoProduto = urlDoProduto;
    }

    public String getUrlDaImagem() {
        return urlDaImagem;
    }

    public void setUrlDaImagem(String urlDaImagem) {
        this.urlDaImagem = urlDaImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
}
