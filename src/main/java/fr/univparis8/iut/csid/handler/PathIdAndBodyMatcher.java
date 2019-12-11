package fr.univparis8.iut.csid.handler;

import com.fasterxml.jackson.databind.util.ObjectBuffer;
import fr.univparis8.iut.csid.annotation.IdAndBodyMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PathIdAndBodyMatcher extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod) {
            if(((HandlerMethod) handler).hasMethodAnnotation(IdAndBodyMatcher.class)) {
                Map<String, String> attributes = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                String pathId = attributes.get("id");
            }

        }

        return true;
    }
}
