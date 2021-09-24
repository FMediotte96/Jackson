package annotations.jackson.polymorphic;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/*
 * @JsonTypeInfo – indicates details of what type information to include in
 * serialization
 * @JsonSubTypes – indicates sub-types of the annotated type
 * @JsonTypeName – defines a logical type name to use for annotated class
 */
public class Zoo {
    public Animal animal;

    public Zoo() {
    }

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Zoo{" +
            "animal=" + animal +
            '}';
    }

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    @JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public static class Animal {
        public String name;

        public Animal() {
        }

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                "name='" + name + '\'' +
                '}';
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog() {
        }

        public Dog(String name) {
            super(name);
        }

        public Dog(String name, double barkVolume) {
            super(name);
            this.barkVolume = barkVolume;
        }

        @Override
        public String toString() {
            return "Dog{" +
                "name='" + name + '\'' +
                ", barkVolume=" + barkVolume +
                '}';
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        public boolean likesCream;
        public int lives;

        public Cat() {
        }

        public Cat(String name) {
            super(name);
        }

        public Cat(String name, boolean likesCream, int lives) {
            super(name);
            this.likesCream = likesCream;
            this.lives = lives;
        }

        @Override
        public String toString() {
            return "Cat{" +
                "name='" + name + '\'' +
                ", likesCream=" + likesCream +
                ", lives=" + lives +
                '}';
        }
    }
}
