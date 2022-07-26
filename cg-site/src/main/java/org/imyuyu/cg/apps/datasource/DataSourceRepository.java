package org.imyuyu.cg.apps.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DataSourceRepository extends JpaRepository<DataSource, Long>, JpaSpecificationExecutor<DataSource> {}