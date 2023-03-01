public class Performance{
    Employees employee;
    public int rating; //valutazioni
    public String review; //commenti
    public int productivityLevel;
    public int skillLevel;
    public int promotions;
    public Performance(Employees employee,int rating, String review, int productivityLevel, int skillLevel, int promotions) {
        this.employee = employee;
        this.rating = rating;
        this.review = review;
        this.productivityLevel = productivityLevel;
        this.skillLevel = skillLevel;
        this.promotions = promotions;
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

