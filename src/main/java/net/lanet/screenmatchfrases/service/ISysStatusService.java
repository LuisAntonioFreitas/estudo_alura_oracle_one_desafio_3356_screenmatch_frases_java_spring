package net.lanet.screenmatchfrases.service;

import org.springframework.http.ResponseEntity;

public interface ISysStatusService {
    ResponseEntity<Object> getStatus();
    ResponseEntity<Object> getConnectIpDb();
}
