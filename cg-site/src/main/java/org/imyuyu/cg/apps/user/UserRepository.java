package org.imyuyu.cg.apps.user;

import org.imyuyu.cg.apps.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 根据姓名模糊查询
     * 
     * @param name
     * @return
     */
    List<User> findByNameLike(@NonNull String name);

    User findByName(@NonNull String name);

    /**
     * 根据账户查询
     * 
     * @param account
     * @return
     */
    Optional<User> findByUsername(@NonNull String username);

    @Query("select u from User u")
    List<User> findBy();

}