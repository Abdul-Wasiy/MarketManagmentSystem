package hu.cs.se.security;

import hu.cs.se.model.User;
import hu.cs.se.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        UserPrincipal userDetails = new UserPrincipal();
        userDetails.setUser(user);

        return userDetails;
    }
}
