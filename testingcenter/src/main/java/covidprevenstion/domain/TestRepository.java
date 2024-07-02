package covidprevenstion.domain;

import covidprevenstion.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "tests", path = "tests")
public interface TestRepository
    extends PagingAndSortingRepository<Test, Long> {}
