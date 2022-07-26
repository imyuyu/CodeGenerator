package org.imyuyu.cg.apps.datasource;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DataSourceService {

    private DataSourceRepository dataSourceRepository;

    public DataSource getDataSource(Long id) {
        return dataSourceRepository.findById(id).orElseThrow(() -> new DataSourceNotFoundException(id));
    }
}
