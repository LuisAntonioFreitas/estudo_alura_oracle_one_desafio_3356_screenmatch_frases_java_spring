package net.lanet.screenmatchfrases.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.lanet.screenmatchfrases.service.ISysDbService;
import net.lanet.screenmatchfrases.service.ISysStatusService;
import net.lanet.screenmatchfrases.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Tag(name = "Status")
@RequestMapping(path = "${api.config.path}/status")
public class SysStatusController {

    @Autowired
    private ISysStatusService service;

    @CrossOrigin(allowedHeaders = "*", origins = "*", methods = {RequestMethod.GET})
    @GetMapping(path = {""})
    public ResponseEntity<Object> getStatus() {
        return service.getStatus();
    }

    @Operation(hidden = true) // Swagger
    @GetMapping(path = {"/db"})
    public ResponseEntity<Object> getConnectIpDb() {
        return service.getConnectIpDb();
    }

}
