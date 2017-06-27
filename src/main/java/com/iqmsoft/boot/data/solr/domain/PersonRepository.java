package com.iqmsoft.boot.data.solr.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Optional;


public interface PersonRepository extends SolrCrudRepository<Person, String>{

    Optional<Person> findOneByName(String name);

    @Query(value = "*:*")
    @Facet(fields = { Person.FIELD_LOCATION })
    FacetPage<Person> findAllAndFacetByLocation(Pageable pageable);
}
