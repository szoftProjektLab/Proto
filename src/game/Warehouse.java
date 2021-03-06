package game;
import enums.Direction;
import fields.Field;
import things.Thing;
import java.util.ArrayList;
import java.util.List;

/**
 * Raktárt viselkedését leíró osztály
 */
public class Warehouse {
    /**
     * Színes dobozok száma
     */
    private int colouredBoxCount;
    /**
     * Játékosok száma
     */
    private int playerCount;

    private Field [][] fields;

    /**
     * Kezdési folyamat
     */
    public void StartingProcess(){
        SetNeighbours();
    }

    /**
     * A pálya méretét beállító függvény
     * @param row       Sorok száma
     * @param column    Oszlopok száma
     */
    public void SetDimensions(int row,int column)
    {
        fields = new Field[row][column];
    }

    /**
     * Sorok számot lekérdező függvény
     * @return
     */
    public int getRow()
    {
        return fields.length;
    }

    /**
     * Oszlopok számát lekérdező függvény
     * @return
     */
    public int getColumn()
    {
        return fields[0].length;
    }

    /**
     * A pályában szereplő egyik mezőt beállító függvény
     * @param row        Sor, ahol van a pályán belül
     * @param column    Oszlop, ahol a pályán van
     * @param field     Mező, amit a pályára helyez el
     */
    public void setField(int row, int column, Field field)
    {
        fields[row][column] = field;
    }

    /**
     A pályában szereplő egyik mezőt visszaadó függvény
     * @param row        Sor koordináta
     * @param column    Oszlop koordináta
     * @return
     */
    public Field getField(int row, int column)
    {
        return fields[row][column];
    }

    /**
     *  A pályán egyik koordinátán álló tárgyat visszaadó függvény
     * @param row       Sor koordináta
     * @param column    Oszlop koordináta
     * @return
     */
    public Thing getThing(int row, int column)
    {
        return fields[row][column].getThing();
    }

    public void setPlayerCount(int szam){
        playerCount = szam;
    }

    /**
     * Beállítja a dobozok számát
     * @param szam szám
     */
    public void setColouredBoxCount(int szam){
        colouredBoxCount = szam;
    }

    /**
     * Meghívják kívülről, és eggyel növeli a dobozok számát
     */
    public void increaseColouredBoxCount()
    {
        setColouredBoxCount(colouredBoxCount+1);
    }

    /**
     * Színes dobozok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void CBDecrease() {
        colouredBoxCount--;
        if (colouredBoxCount==0) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
    }
    /**
     *  Játékosok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void PDecrease(){
        playerCount--;
        if(playerCount==1) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
    }

    /**
     * Beállítja az összes szomszédját a mezőknek
     */
    public void SetNeighbours() {
        //Iteráció sorokra
        for (int curRow = 0; curRow < fields.length; curRow++)
        {
            //Iteráció oszlopokra
            for(int curColumn = 0; curColumn < fields[0].length; curColumn++)
            {
                // Bal oldali szomszéd beállítása
                if(curColumn-1 >= 0)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Left,fields[curRow][curColumn-1]);

                // Jobb oldali szomszéd beállítása
                if(curColumn+1 < fields[0].length)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Right,fields[curRow][curColumn+1]);

                // Felső szomszéd beállítása
                if(curRow-1 >= 0)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Up,fields[curRow-1][curColumn]);

                // Alsó szomszéd beállítása
                if(curRow+1 < fields.length)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Down,fields[curRow+1][curColumn]);
            }
        }
    }
}
