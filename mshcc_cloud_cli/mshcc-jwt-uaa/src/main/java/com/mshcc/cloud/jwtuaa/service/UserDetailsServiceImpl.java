package com.mshcc.cloud.jwtuaa.service;

import com.mshcc.cloud.jwtuaa.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/4 9:52
 * @Description TODO
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TUserRoleService tUserRoleService;
    @Autowired
    private TRolePermissionService tRolePermissionService;
    @Autowired
    private TPermissionService tPermissionService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser user = tUserService.findByName(username);
        if (user==null){
            return null;
        }
        List<Integer> roles = tUserRoleService.getRolesByUser(user.getId());

        List<Integer> permissionIds = tRolePermissionService.getPermissionsByRole(roles);
        Collection<? extends GrantedAuthority> list = tPermissionService.getPermissions(permissionIds);
        if(list == null){
            list = new ArrayList<>();
        }
        return User.withUsername(username).password(user.getPassword()).authorities(list).build();
    }
}
