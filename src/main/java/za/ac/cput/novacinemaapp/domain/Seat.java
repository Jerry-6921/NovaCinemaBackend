package za.ac.cput.novacinemaapp.domain;

    /*Seat.java
Entity for Theatre Seats
Author: Daanyaal Isaacs (220094934)
Date: 17 May
 */

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;
    private String seatNumber;
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "Seat_Theatre")
    private Theatre theatre;

    protected Seat() {
    }

    public Seat(Builder builder){
        this.seatID = builder.seatID;
        this.seatNumber = builder.seatNumber;
        this.seatType = builder.seatType;
        this.theatre = builder.theatre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatID, seat.seatID) && Objects.equals(seatNumber, seat.seatNumber) && Objects.equals(seatType, seat.seatType) && Objects.equals(theatre, seat.theatre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatID, seatNumber, seatType, theatre);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatID='" + seatID + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                ", theatre=" + theatre +
                '}';
    }

    public static class Builder{
        private Long seatID;
        private String seatNumber;
        private String seatType;
        private Theatre theatre;

        public Builder setSeatID(Long id){
            this.seatID = id;
            return this;
        }

        public Builder setSeatNumber(String seatNumber){
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setSeatType(String seatType){
            this.seatType = seatType;
            return this;
        }

        public Builder setTheatre(Theatre theatre){
            this.theatre = theatre;
            return this;
        }

        public Builder copy(Seat seat){
            this.seatID = seat.seatID;
            this.seatNumber = seat.seatNumber;
            this.seatType = seat.seatType;
            this.theatre = seat.theatre;
            return this;
        }

        public Seat build(){
            return new Seat(this);
        }
    }
}
