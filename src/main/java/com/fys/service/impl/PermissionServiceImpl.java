package com.fys.service.impl;

import com.fys.mapper.PermissionMapper;
import com.fys.pojo.Permission;
import com.fys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired PermissionMapper permissionMapper;

    @Override
    public Set<String> listPermissionsByUsername(String username) {
        List<Permission> permissions = permissionMapper.listPermissionsByUsername(username);
        Set<String> permissionSet = new HashSet<>();
        for(Permission p : permissions)
            if(p != null)
            permissionSet.add(p.getName());
        return permissionSet;
    }
}
