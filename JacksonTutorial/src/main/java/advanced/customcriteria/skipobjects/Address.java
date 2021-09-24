package advanced.customcriteria.skipobjects;

public class Address implements Hidable {
    private String city;
    private String country;
    private boolean hidden;

    public Address(String city, String country, boolean hidden) {
        this.city = city;
        this.country = country;
        this.hidden = hidden;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }
}
