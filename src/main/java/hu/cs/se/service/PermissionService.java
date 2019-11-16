package hu.cs.se.service;

import hu.cs.se.model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermissionsById(List<Integer> permissionIds);


    List<Permission> findAllPermissions();
}
