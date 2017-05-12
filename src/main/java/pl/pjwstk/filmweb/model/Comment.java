package pl.pjwstk.filmweb.model;

public class Comment {
    private final Integer id;
    private final String comment;

    public Comment(Integer id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}
