package com.gym.springsecurity.service;

import com.gym.objects.Role;
import com.gym.objects.User;
import com.gym.service.RoleService;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service("springSecurityUserService")
public class SpringSecurityUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername : "+login);
        User user;
        try{
            user = userService.readByLogin(login);
            System.out.println("User : "+user);
        } catch (NoSuchElementException nse) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }

        if(!user.isEnabled()) {
            System.out.println("User is not enable");
            //todo: think how better to organize work with absence or unenable user
            //it could be different error403 pages
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                user.isEnabled(), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role : roleService.getRolesByUserId(user.getId())){
            System.out.println("Role : " + role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
