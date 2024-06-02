package net.lanet.screenmatchfrases.service;

import net.lanet.screenmatchfrases.entity.Frase;
import net.lanet.screenmatchfrases.dto.FraseDtoResponse;
import net.lanet.screenmatchfrases.repository.IFraseRepository;
import net.lanet.screenmatchfrases.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class FraseService implements IFraseService {

    @Autowired
    private IFraseRepository repository;
    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Override
    @Transactional(readOnly = true)
    public FraseDtoResponse getFraseAleatoria() {

        List<Frase> frases = repository.findAll();
        int randomIndex = 0;
        if (!frases.isEmpty()) {
            Random random = new Random();
            randomIndex = random.nextInt(frases.size());
        }
        Frase frase = frases.get(randomIndex);
        return modelMapperUtil.map(frase, FraseDtoResponse.class);

//        Optional<Frase> frase = repository.getFraseAleatoria();
//        return frase.map(value -> modelMapperUtil.map(value, FraseDtoResponse.class))
//                .orElse(null);

//        Optional<Frase> frase = repository.getFraseAleatoria();
//        return frase.map(
//                value -> new FraseDtoResponse(
//                value.getTitulo(),
//                value.getFrase(),
//                value.getPersonagem(),
//                value.getPoster())
//                ).orElse(null);

//        Optional<Frase> frase = repository.getFraseAleatoria();
//        if (frase.isPresent()) {
//            return new FraseDtoResponse(
//                    frase.get().getTitulo(),
//                    frase.get().getFrase(),
//                    frase.get().getPersonagem(),
//                    frase.get().getPoster());
//        }
//        return null;

    }

}
