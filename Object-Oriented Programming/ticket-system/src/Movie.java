public record Movie(String title, int minutes, String rating) {

    @Override
    public String toString() {
        return title + " (" + rating + ", " + minutes + " mins)";
    }
}
