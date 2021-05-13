package com.listaDesejos.listaDesejos.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="product")
public class Product implements Serializable {

    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private BigDecimal price;

    @Column
    @NotNull
    private String descripcion;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
