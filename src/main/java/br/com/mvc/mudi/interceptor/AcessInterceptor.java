package br.com.mvc.mudi.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AcessInterceptor extends HandlerInterceptorAdapter {

    public static List<Acesso> acessos = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Acesso acesso = new Acesso();
        acesso.path = request.getRequestURI();
        acesso.init = System.currentTimeMillis();
        request.setAttribute("acesso", acesso);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.time = System.currentTimeMillis() - acesso.init;
        acessos.add(acesso);
    }

    public static class Acesso {
        private String path;
        private Long init;
        private Long time;

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Long getInit() {
            return init;
        }

        public void setInit(Long init) {
            this.init = init;
        }
    }
}
