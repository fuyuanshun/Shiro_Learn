package com.fys.service;

import java.util.Set;

public interface RoleService {
    Set<String> listRolesByUsername(String username);
}
