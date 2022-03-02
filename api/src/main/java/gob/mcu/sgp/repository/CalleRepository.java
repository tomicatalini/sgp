package gob.mcu.sgp.repository;

import gob.mcu.sgp.entities.Calle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalleRepository extends PagingAndSortingRepository<Calle, Long> {
}
