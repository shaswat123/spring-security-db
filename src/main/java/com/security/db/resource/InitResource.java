package com.security.db.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest")
public class InitResource {

    @GetMapping("/all")
    public String iniitalize(){

        return "Initialized";

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedInitialized(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();

        return "secured init --->Hello "+username;
    }
}
