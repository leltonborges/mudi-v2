package br.com.mvc.mudi.dto;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.model.User;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class RequisicaoNovoPedido {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    @NotBlank
    private String descricaoProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Pedido toPedido(User user) {
        Pedido pedido = new Pedido(null, this.nomeProduto,
                null, LocalDate.now(), this.urlProduto,
                this.urlImagem, this.descricaoProduto, user,StatusPedido.AGUARDANDO);
        return  pedido;
    }
}
