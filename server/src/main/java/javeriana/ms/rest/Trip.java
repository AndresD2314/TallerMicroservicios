package javeriana.ms.rest;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@XmlRootElement
public class Trip {
    @Getter
    private String id;
    @Getter
    @Setter
    private String origin;
    @Getter
    @Setter
    private String destination;
    @Getter
    @Setter
    private double duration;
    @Getter
    @Setter
    private double price;

    public Trip(String origin, String destination, double duration, double price) {
        this.id = String.valueOf(UUID.randomUUID());
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.price = price;
    }

    public Trip() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "Trip to: " + destination + " from: " + origin + ". ETA in hours: " + duration;
    }

}
