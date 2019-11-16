package hu.cs.se.service;

import hu.cs.se.model.Permission;
import hu.cs.se.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> findAllPermissionsById(List<Integer> permissionIds) {
        return permissionRepository.findAllById(permissionIds);
    }

    @Override
    public List<Permission> findAllPermissions() {
        return permissionRepository.findAll();
    }
}
