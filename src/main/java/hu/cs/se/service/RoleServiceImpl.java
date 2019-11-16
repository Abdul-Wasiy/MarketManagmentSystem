package hu.cs.se.service;

import hu.cs.se.model.Role;
import hu.cs.se.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRolesByIds(List<Integer> roleIds) {
        return roleRepository.findAllById(roleIds);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
