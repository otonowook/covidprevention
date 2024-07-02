package covidprevenstion.domain;

import covidprevenstion.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "isolationCamps",
    path = "isolationCamps"
)
public interface IsolationCampRepository
    extends PagingAndSortingRepository<IsolationCamp, Long> {}
