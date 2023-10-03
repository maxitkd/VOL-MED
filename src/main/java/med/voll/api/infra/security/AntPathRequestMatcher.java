package med.voll.api.infra.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.RequestVariablesExtractor;

import java.util.Map;

public final class AntPathRequestMatcher
        extends Object
        implements RequestMatcher, RequestVariablesExtractor {
    public AntPathRequestMatcher(String s) {
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return false;
    }

    @Override
    public Map<String, String> extractUriTemplateVariables(HttpServletRequest request) {
        return null;
    }
}