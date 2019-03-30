package com.fys.service.impl;

import com.fys.mapper.RoleMapper;
import com.fys.pojo.Permission;
import com.fys.pojo.Role;
import com.fys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired RoleMapper mapper;

    @Override
    public Set<String> listRolesByUsername(String username) {
        List<Role> roles = mapper.listRolesByUsername(username);
        Set<String> roleSet = new HashSet<>();
        for(Role r : roles)
            if(r != null)
            roleSet.add(r.getName());
        return roleSet;
    }
}
