package br.com.mvc.mudi.api;

import br.com.mvc.mudi.interceptor.AcessInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/acessos")
public class AcessosRest {

    @GetMapping
    public List<AcessInterceptor.Acesso> getAcessos(){
        return AcessInterceptor.acessos;
    }
}
