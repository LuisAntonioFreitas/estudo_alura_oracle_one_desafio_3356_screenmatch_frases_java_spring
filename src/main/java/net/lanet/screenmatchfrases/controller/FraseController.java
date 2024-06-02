package net.lanet.screenmatchfrases.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.lanet.screenmatchfrases.dto.FraseDtoResponse;
import net.lanet.screenmatchfrases.service.IFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Frases")
@RequestMapping(path = "${api.config.path}/series/frases")
public class FraseController {
    @Autowired
    private IFraseService service;

    @GetMapping(path = {""})
    public FraseDtoResponse getFraseAleatoria() {
        return service.getFraseAleatoria();
    }

}
