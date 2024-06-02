package net.lanet.screenmatchfrases.service;

import java.time.LocalDateTime;

public interface ISysDbService {
    LocalDateTime findDateOldTable(String databaseName);
    LocalDateTime findDateTable(String tableName);
}
