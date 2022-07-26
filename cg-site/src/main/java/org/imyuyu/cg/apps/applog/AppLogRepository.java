package org.imyuyu.cg.apps.applog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLogRepository extends JpaRepository<AppLog, Long> {}