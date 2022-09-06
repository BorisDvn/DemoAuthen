package com.example.demo.service;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    final
    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(ERole role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }
}
