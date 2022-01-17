package am.gbr.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private ListingStatus listingStatus;
    private final LocalDateTime createdDateTime = LocalDateTime.now();
    private String phoneNumber;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    @ManyToOne
    private ListingGroup listingGroup;
    @ManyToOne
    private ListingCategory listingCategory;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "listing_like",
            joinColumns = {@JoinColumn(name = "listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "like_listing_id")}
    )
    private List<Like> likes;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "listing_comment",
            joinColumns = {@JoinColumn(name = "listing_id")},
            inverseJoinColumns = {@JoinColumn(name = "comment_id")}
    )
    private List<Comment> commentList;


}
