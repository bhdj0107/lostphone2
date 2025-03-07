package lostphone.infra;

import java.util.List;
import lostphone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "memberInfos",
    path = "memberInfos"
)
public interface MemberInfoRepository
    extends PagingAndSortingRepository<MemberInfo, Long> {}
