package nguyenhuuvu.config;

import nguyenhuuvu.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority: SecurityUtils.getListRoles()) {
            roles.add(authority.getAuthority());
        }

        String urlTarget = null;
        if (roles.contains("ROLE_ADMIN"))
            urlTarget = "/admin";
        else
            urlTarget = "/";
        redirectStrategy.sendRedirect(request, response, urlTarget);
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
