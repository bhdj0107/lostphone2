package lostphone.infra;

import java.util.List;
import lostphone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "deviceInfos",
    path = "deviceInfos"
)
public interface DeviceInfoRepository
    extends PagingAndSortingRepository<DeviceInfo, Long> {}
