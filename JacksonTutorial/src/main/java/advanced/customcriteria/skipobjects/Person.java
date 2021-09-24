package advanced.customcriteria.skipobjects;

public class Person implements Hidable {
    private String name;
    private Address address;
    private boolean hidden;

    public Person(String name, Address address, boolean hidden) {
        this.name = name;
        this.address = address;
        this.hidden = hidden;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

}
