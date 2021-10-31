package br.com.mvc.mudi.dto;

import br.com.mvc.mudi.model.Oferta;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequesicaoNovaOferta {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;
    @Pattern(regexp = "^\\d+(?!\\/)(.\\d{2}$)?", message = "Formato invalido (xxx[...].xx) ou (xxxxxx)")
    @NotBlank(message = "Não pode ser nulo")
    @Min(value = 1, message = "Valor minino é R$ 1,00")
    private String valor;

    @NotBlank(message = "Não pode ser nulo")
    @Pattern(regexp = "^\\d{2}\\/\\d{2}\\/\\d{4}$", message = "Formato valido dd/mm/yyyy")
    private String dataDaEntrega;
    private String comentario;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.getComentario());
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
        oferta.setValor(new BigDecimal(this.valor));
        return  oferta;
    }
}
