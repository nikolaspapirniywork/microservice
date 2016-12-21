package hello.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hello.model.Quote;
import hello.model.Value;

@RepositoryRestResource(collectionResourceRel = "values", path = "values")
public interface ValueRepository extends PagingAndSortingRepository<Value, Long> {
}
