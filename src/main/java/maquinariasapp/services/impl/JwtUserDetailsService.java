package maquinariasapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import maquinariasapp.entity.Operario;
import maquinariasapp.repository.OperarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private OperarioRepository operarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operario user = operarioRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });
        UserDetails ud = new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, roles);
        return ud;
    }
}
