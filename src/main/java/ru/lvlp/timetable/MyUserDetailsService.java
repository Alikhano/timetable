package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ru.lvlp.timetable.User user = userDao.findByLogin(login);
        GrantedAuthority authority = buildUserAuthority(user.getRole());

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(authority);
        return buildUserForAuthentication(user,authorities);
    }

    private User buildUserForAuthentication(ru.lvlp.timetable.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private GrantedAuthority buildUserAuthority(Role role) {
        GrantedAuthority result = new SimpleGrantedAuthority("ROLE_" + role.getRole());
        return result;
    }
}
