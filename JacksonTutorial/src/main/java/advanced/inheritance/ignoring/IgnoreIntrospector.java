package advanced.inheritance.ignoring;

import advanced.inheritance.inclusion.Car;
import advanced.inheritance.inclusion.Vehicle;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class IgnoreIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return m.getDeclaringClass() == Vehicle.class && m.getName() == "model"
            || m.getDeclaringClass() == Car.class
            || "towingCapacity".equals(m.getName())
            || super.hasIgnoreMarker(m);
    }
}
