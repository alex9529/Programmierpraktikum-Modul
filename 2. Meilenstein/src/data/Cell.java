/*
 * Copyright (c) 2018.
 * Der Code wurde fÃ¼r das Institut fÃ¼r Informatik der UniversitÃ¤t zu KÃ¶ln erstellt.
 * Dieser Code oder Teile des Codes dÃ¼rfen nur fÃ¼r die Lehre verwendet werden.
 * Die VerÃ¶ffentlichung sowie die Weitergabe des Codes ist nur Lehrbeauftragen des Instituts fÃ¼r Informatik gestattet.
 * Autor: Philipp Klinke (klinke@informatik.uni-koeln.de)
 */

package data;

/**
 * Kapselt alle Informationen zu einer Zelle innerhalb des Gitternetzes.
 * Eine Zelle wird zu Beginn in einem Gitternetz platziert und aendert seine Position nicht.
 * Aus diesem Grund sind rIndex und cIndex als final deklariert und es gibt keine Setter.
 * Man kann jedoch den Wert einer Zelle veraendern.
 * @author Philipp Klinke (klinke@informatik.uni-koeln.de)
 */
public class Cell {
    private int value = -1;
    private final int rIndex;
    private final int cIndex;

    /**
     * @param rIndex Zeilenindex an dem sich die Zelle befindet.
     * @param cIndex Spaltenindex an dem sich die Zelle befindet.
     */
    public Cell(int rIndex, int cIndex) {
        this.rIndex = rIndex;
        this.cIndex = cIndex;
    }

    /**
     * Gibt den Nutzwert der Zelle zurueck. Also den Wert den ein Spieler in einem Sudokufeld eintragen wuerde.
     * @return Wert der Zelle [-1.. 9]
     */
    public int getValue() {
        return value;
    }

    /**
     * Setzt den Wert der Zelle den ein Spieler in eine Sudokufeld eintragen wuerde.
     * @param value Wertebereich [-1.. 9]
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Der Zeilenindex der die Position der Zelle angibt.
     * @return Zeilenindex mit Wertebereich [1.. n]
     */
    public int getrIndex() {
        return rIndex;
    }

    public boolean isEmpty(){
        return value == -1 ? true : false;
    }

    /**
     * Der Spaltenindex der die Position der Zelle angibt.
     * @return Spaltenindex mit Wertebereich [1.. n]
     */
    public int getcIndex() {
        return cIndex;
    }

    @Override
    public String toString() {
        return  Integer.toString(value);
    }
}