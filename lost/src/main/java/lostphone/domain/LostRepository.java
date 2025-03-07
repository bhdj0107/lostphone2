package lostphone.domain;

import java.util.Date;
import java.util.List;
import lostphone.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "losts", path = "losts")
public interface LostRepository
    extends PagingAndSortingRepository<Lost, Long> {}
