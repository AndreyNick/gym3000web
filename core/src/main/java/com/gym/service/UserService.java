package com.gym.service;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.objects.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class UserService extends AbstractGenericService<User, Long> {

    private UserDaoImpl udi;

    protected UserService(UserDaoImpl udi) {
        super(udi);
        this.udi = udi;
    }

    @Transactional
    public User readByName(String name) {
        User user = udi.readByName(name);
        return user;
    }

   /* // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getName(),
                user.getPassword(), user.isEnabled(), authorities);
    }


    private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }*/

}
