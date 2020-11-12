package ir.ac.kntu;

public enum PostingMethod {
    USUAL ("Usual") , CUSTOM ("Custom");

    private String postingMethod;
    PostingMethod(String postingMethod) {
        this.postingMethod=postingMethod;
    }

    @Override
    public String toString() {
        return postingMethod;

    }
}
