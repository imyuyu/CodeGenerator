package org.imyuyu.cg.apps.directory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DirectoryRepository extends JpaRepository<Directory, Long>, JpaSpecificationExecutor<Directory> {}