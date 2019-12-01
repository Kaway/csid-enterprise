package fr.univparis8.iut.csid;

public class DiskPlayer {

    private DiskReader diskReader;

    public DiskPlayer() {
        this.diskReader = new DvdReader();
    }
}
