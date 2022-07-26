package org.imyuyu.cg.apps.user;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.template.Template;
import org.imyuyu.cg.apps.template.TemplateDto;
import org.imyuyu.cg.apps.user.User;
import org.imyuyu.cg.apps.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;
import java.util.function.Function;

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

    public Page<User> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

}
