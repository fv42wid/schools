package com.example.school.bootstrap;

import com.example.school.models.Role;
import com.example.school.services.RoleService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RoleService roleService;

    public Bootstrap(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role role1 = new Role();
        role1.setName("USER");
        roleService.saveRole(role1);

        Role role2 = new Role();
        role2.setName("ADMIN");
        roleService.saveRole(role2);
    }
}
