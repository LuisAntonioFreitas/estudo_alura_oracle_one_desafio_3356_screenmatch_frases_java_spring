package net.lanet.screenmatchfrases.service;

import net.lanet.screenmatchfrases.utils.ApplicationProperties;
import net.lanet.screenmatchfrases.utils.CurrentDateTimeUtils;
import net.lanet.screenmatchfrases.utils.TestIpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Transactional
public class SysStatusService implements ISysStatusService {
    @Autowired
    private ApplicationProperties ap;

    @Autowired
    private ISysDbService service;

    @Transactional(readOnly = true)
    public ResponseEntity<Object> getStatus() {
        // Status
        final String idProfileActive = ap.profileActive.equals(ap.apiProfile)
                ? ap.profileActive : ap.profileActive + "|" + ap.apiProfile;

        boolean connectedDb = false;
        LocalDateTime databaseCreate = null;
        LocalDateTime tableCreate = null;
        try {
            databaseCreate = service.findDateOldTable(ap.databaseName);
            tableCreate = databaseCreate;

            final String catalog = databaseCreate.toString();
            connectedDb = !catalog.trim().equals("");
        } catch(Exception ignored) {};

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("date", CurrentDateTimeUtils.getNow());
        map.put("reference", ap.apiSystemReference);
        map.put("system", ap.apiSystemTagBase);
        map.put("version", ap.apiSystemVersion);
        map.put("status", "up");
        map.put("health", connectedDb ? "up" : "down");
        map.put("type", "java");
        map.put("language", ap.configLanguage);
        map.put("server", idProfileActive);
        map.put("port", ap.serverPort);
        map.put("port-exposed", ap.serverPortExposed);
        map.put("url", ap.apiUrlBase);
        map.put("db-type", ap.databaseType);
        map.put("db-name", ap.databaseName);
        map.put("db-create", databaseCreate);
        map.put("tb-create", tableCreate);
        map.put("db-connected", connectedDb);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    public ResponseEntity<Object> getConnectIpDb() {
        String host = ap.databaseIp;
        Object[] result = TestIpUtils.testIp(host);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("date", CurrentDateTimeUtils.getNow());
        map.put("db", host);
        map.put("result", result[0]);
        map.put("message", result[1]);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
