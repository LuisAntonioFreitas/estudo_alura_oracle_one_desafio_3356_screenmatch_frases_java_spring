package net.lanet.screenmatchfrases.service;

import net.lanet.screenmatchfrases.repository.ISysDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class SysDbService implements ISysDbService {

    @Autowired
    private ISysDbRepository repository;

    @Override
    @Transactional(readOnly = true)
    public LocalDateTime findDateOldTable(String databaseName) {
        LocalDateTime dt = repository.findDateOldTable(databaseName);
        return dt;
    }
    @Override
    @Transactional(readOnly = true)
    public LocalDateTime findDateTable(String tableName) {
        LocalDateTime dt = repository.findDateTable(tableName);
        return dt;
    }

}
