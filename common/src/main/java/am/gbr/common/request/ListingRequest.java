package am.gbr.common.request;

import am.gbr.common.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListingRequest {

    private Long id;
    private String title;
    private String description;
    private ListingStatus listingStatus;
    private LocalDateTime createdDateTime;
    private String phoneNumber;
    private User user;
    private Product product;
    private ListingGroup listingGroup;
    private ListingCategory listingCategory;
    private List<Like> likeList;
    private List<Comment> commentList;

}
