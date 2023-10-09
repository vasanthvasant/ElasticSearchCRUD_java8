package com.elasticSearch.crud.repositiry;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticSearch.crud.entity.Student;
@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,Integer> {

}
