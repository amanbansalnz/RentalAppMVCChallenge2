package com.mvp.studio.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

    public static final String SEQ_RATING_GEN = "SEQ_RATING_GEN";
    private static final String SEQ_NAME = "SEQ_RATING";
    @GenericGenerator(
            name = SEQ_RATING_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = SEQ_NAME),
                    @Parameter(name = "allocation_size", value = "20")
            }
    )
    @Id
    @GeneratedValue(generator = SEQ_RATING_GEN, strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long videoId;
    private Long videoRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getVideoRating() {
        return videoRating;
    }

    public void setVideoRating(Long videoRating) {
        this.videoRating = videoRating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", videoRating=" + videoRating +
                '}';
    }
}
