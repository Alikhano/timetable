package ru.lvlp.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserInfoDao userInfoDao;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUserInfo(login);
        System.out.println("UserInfo= " + userInfo);

        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }

        List<Role> roles = userInfoDao.getRoles(login);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roles != null) {
            for (Role role : roles) {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.toString());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(userInfo.getLogin(), userInfo.getPassword(), grantList);

        return userDetails;
    }
}
