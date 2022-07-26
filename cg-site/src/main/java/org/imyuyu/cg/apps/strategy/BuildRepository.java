package org.imyuyu.cg.apps.strategy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long>, JpaSpecificationExecutor<Build> {

    List<Build> findByStatusAndDeletedFalseAndEnabledTrue(BuildStatus status);

}