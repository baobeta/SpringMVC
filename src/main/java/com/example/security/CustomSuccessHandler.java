package com.example.security;

import com.example.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        // dinh tuyen url theo role
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url ="";
        // if is ADMIN so redirect to to controller /quan-tri/trang-chu
        // if is USER so redirect to to controller /trang-chu
        List<String> roles = SecurityUtils.getAuthorities();
        if(isAdmin(roles)) {
            url = "/quan-tri/trang-chu";
        } else if (isUser(roles)) {
            url="/trang-chu";

        }
        return url;
    }
    private boolean isAdmin(List<String> roles) {
        if(roles.contains("ADMIN")) {
            return true;
        }
        return false;
    }
    private boolean isUser(List<String> roles) {
        if(roles.contains("USER")) {
            return true;
        }
        return false;
    }
}
