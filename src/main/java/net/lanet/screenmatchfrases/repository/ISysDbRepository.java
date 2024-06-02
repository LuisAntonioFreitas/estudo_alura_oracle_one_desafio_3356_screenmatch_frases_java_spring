package net.lanet.screenmatchfrases.repository;

import net.lanet.screenmatchfrases.entity.SysDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ISysDbRepository extends JpaRepository<SysDb, Integer> {
    @Query(nativeQuery = true, value =
            "   SELECT CREATE_TIME " +
            "     FROM information_schema.TABLES " +
            "    WHERE TABLE_SCHEMA = :databaseName " +
            " ORDER BY CREATE_TIME ASC " +
            "    LIMIT 1 "
    )
    LocalDateTime findDateOldTable(String databaseName);

    @Query(nativeQuery = true, value =
            " SELECT CREATE_TIME " +
            "   FROM information_schema.TABLES " +
            "  WHERE TABLE_NAME = :tableName " )
    LocalDateTime findDateTable(String tableName);
}
