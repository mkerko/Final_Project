package by.epam.training.domain;

import java.io.Serializable;

/**
 * Created by Михаил on 19.06.2016.
 */
public class Room implements Serializable {

    private static final long serialVersionID = 1L;
    private Long ID;
    private String dayPrice;
    private String numberOfCouchettes;
    private String description;
    private String number;

    public Room(Long ID, String dayPrice, String numberOfCouchettes, String description, String number) {
        this.ID = ID;
        this.dayPrice = dayPrice;
        this.numberOfCouchettes = numberOfCouchettes;
        this.description = description;
        this.number = number;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(String dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getNumberOfCouchettes() {
        return numberOfCouchettes;
    }

    public void setNumberOfCouchettes(String numberOfCouchettes) {
        this.numberOfCouchettes = numberOfCouchettes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID=" + ID +
                ", dayPrice='" + dayPrice + '\'' +
                ", numberOfCouchettes='" + numberOfCouchettes + '\'' +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }


}
