package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public int rating; //valutazioni
    public String review; //commenti
    public int productivityLevel;
    public int skillLevel;
    public int promotions;

    public Performance(long id, int rating, String review, int productivityLevel, int skillLevel, int promotions) {
        this.id=id;
        this.rating = rating;
        this.review = review;
        this.productivityLevel = productivityLevel;
        this.skillLevel = skillLevel;
        this.promotions = promotions;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void calculatePromotion(){}
    public void generateEvaluation(){}
    public void addComment(String comment) {}
    public void updatePerformance(){};
    public void getPerformance(){};


}
