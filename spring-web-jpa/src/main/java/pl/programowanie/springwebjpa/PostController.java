package pl.programowanie.springwebjpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("posts")
    public ResponseEntity<Iterable<Post>> getAllPosts(){
        Iterable<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post save = postRepository.save(post);


        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(save);
    }
    @DeleteMapping("posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id){
        if(!postRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("posts/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
         return postRepository.findById(post.getId())
                .map(existingPost -> {
                   existingPost.setBody(post.getBody());
                   return postRepository.save(existingPost);
                })
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
    @GetMapping("posts/{id}")
    public ResponseEntity<Post>getOnePost(@PathVariable Integer id){
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }


}
