package com.test.bean;

public class beddata {
    private String id;
    private String building;
    private String  room;
    private String bed;

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "beddata{" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", bed='" + bed + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
