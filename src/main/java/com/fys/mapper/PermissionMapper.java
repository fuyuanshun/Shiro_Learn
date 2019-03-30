package com.fys.mapper;

import com.fys.pojo.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> listPermissionsByUsername(String username);
}
