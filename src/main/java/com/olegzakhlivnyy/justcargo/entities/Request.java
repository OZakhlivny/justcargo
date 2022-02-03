package com.olegzakhlivnyy.justcargo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "request_time")
    private OffsetDateTime requestTime;

    @Column(name = "delivery_time")
    private OffsetDateTime deliveryTime;

    @Column(name = "delivery_time_limit")
    private OffsetDateTime deliveryTimeLimit;

    @Column(name = "departure")
    private String departure;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_n")
    private Double departureCoordinateN;

    @Column(name = "departure_e")
    private Double departureCoordinateE;

    @Column(name = "destination_n")
    private Double destinationCoordinateN;

    @Column(name = "destination_e")
    private Double destinationCoordinateE;

    @Column(name = "short_info")
    private String shortInfo;

    @Column(name = "description")
    private String description;

    @Column(name = "packages_number")
    private Integer packagesNumber;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "length")
    private Float length;

    @Column(name = "width")
    private Float width;

    @Column(name = "height")
    private Float height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private RequestStatus status;

    @Column(name = "cost")
    private Integer cost;
}
