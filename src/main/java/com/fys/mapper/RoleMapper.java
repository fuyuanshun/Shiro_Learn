package com.fys.mapper;

import com.fys.pojo.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> listRolesByUsername(String username);
}
