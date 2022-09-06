package com.example.moviedb.entity;

public class Genero {
    private Long id;
    private String name;

    public Genero() {
    }

    public Genero(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
