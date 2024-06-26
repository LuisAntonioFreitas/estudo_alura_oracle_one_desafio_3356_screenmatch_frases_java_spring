package net.lanet.screenmatchfrases.repository;

import net.lanet.screenmatchfrases.entity.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFraseRepository extends JpaRepository<Frase, Long> {

    @Query(value =
            "   SELECT f " +
            "     FROM Frase AS f " +
            " ORDER BY function('RAND') " +
            "    LIMIT 1 "
    )
    Optional<Frase> getFraseAleatoria();

}
