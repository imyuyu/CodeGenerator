package org.imyuyu.cg.apps.path;

import org.imyuyu.cg.apps.path.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PathRepository extends JpaRepository<Path, Long>, JpaSpecificationExecutor<Path> {}