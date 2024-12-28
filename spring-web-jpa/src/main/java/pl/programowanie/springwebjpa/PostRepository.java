package pl.programowanie.springwebjpa;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
    Integer id(Integer id);
}
