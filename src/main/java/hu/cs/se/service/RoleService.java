package hu.cs.se.service;

import hu.cs.se.model.Role;

import java.util.List;

public interface RoleService  {
     List<Role> findAllRolesByIds(List<Integer> roleIds);


    List<Role> findAllRoles();
}
