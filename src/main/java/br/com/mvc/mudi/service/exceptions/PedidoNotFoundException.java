package br.com.mvc.mudi.service.exceptions;

import java.io.Serializable;

public class PedidoNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1l;

    public PedidoNotFoundException(String msg){
        super(msg);
    }

    public PedidoNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}
