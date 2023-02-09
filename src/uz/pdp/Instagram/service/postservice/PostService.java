package uz.pdp.Instagram.service.postservice;

import uz.pdp.Instagram.model.post.Post;
import uz.pdp.Instagram.model.post.PostType;
import uz.pdp.Instagram.service.BaseService;

public interface PostService extends BaseService<Post> {
    Post getId(PostType type);

}
