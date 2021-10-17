package br.com.mvc.mudi.model;

public enum StatusPedido {
    AGUARDANDO(1),APROVADO(2),ENTREGUE(3);

    private Integer id;

    StatusPedido(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
