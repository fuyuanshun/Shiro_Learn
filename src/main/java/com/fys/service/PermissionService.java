package com.fys.service;

import java.util.Set;

public interface PermissionService {
    Set<String> listPermissionsByUsername(String username);
}
