package org.imyuyu.cg.apps.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Long>, JpaSpecificationExecutor<FileType> {}