package org.imyuyu.cg.apps.user;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.imyuyu.cg.apps.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public Optional<User> fetchUser(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> fetchUser(String username) {
        return this.userRepository.findByUsername(username);
    }

}
