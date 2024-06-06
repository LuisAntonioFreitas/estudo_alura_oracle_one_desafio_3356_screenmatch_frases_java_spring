package net.lanet.screenmatchfrases.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.lanet.screenmatchfrases.dto.FraseDtoResponse;
import net.lanet.screenmatchfrases.entity.Frase;
import net.lanet.screenmatchfrases.service.IFraseService;
import net.lanet.screenmatchfrases.utils.ConvertsDataUtil;
import net.lanet.screenmatchfrases.view.FraseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Frases")
@RequestMapping(path = "${api.config.path}/series/frases")
public class FraseController {
    @Autowired
    private IFraseService service;
    @Autowired
    private ConvertsDataUtil convertsDataUtil;

    @GetMapping(path = {""})
    public ResponseEntity<Object> getFraseAleatoria() {
        FraseDtoResponse response = service.getFraseAleatoria();
        FraseView view = convertsDataUtil.mapDataClassToClass(response, FraseView.class);
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

}
