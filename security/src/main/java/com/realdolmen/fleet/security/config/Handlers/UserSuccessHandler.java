package com.realdolmen.fleet.security.config.Handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SDOAX36 on 2/11/2015.
 */
@Component
public class UserSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    private RedirectStrategy strategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(authentication);

        System.out.println("targerUrl : " + targetUrl + " response " + response.getStatus());
        if(response.isCommitted())
        {
            System.out.println("Can't redirect!!!");
            return;
        }

        strategy.sendRedirect(request,response,targetUrl);

    }


    protected String determineTargetUrl(Authentication authentication)
    {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String>roles = new ArrayList<>();
        for(GrantedAuthority a : authorities)
        {
            roles.add(a.getAuthority());
        }

        if(roles.contains("USER"))
        {
            url = "/employee";
        }
        else if(roles.contains("ADMIN"))
        {
            url= "/fleet";
        }
        return url;
    }
}
