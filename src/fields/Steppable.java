package fields;

import enums.Direction;
import things.Box;
import things.Player;
import things.Thing;

import java.util.HashMap;
import java.util.Map;

public abstract class Steppable {
    private Map<Direction, Field> neighbours;
    protected Thing thing;
    protected double effect;

    /**
     * Az adott irányba beállítja a szomszédos mezőt.
     * @param d irány
     * @param f szomszédnak szánt Field
     */
    public abstract void SetNeighbour(Direction d, Field f);

    /**
     * Visszaadja abban az irányban lévő szomszédos mezőt
     * @param d Szomszéd iránya
     * @return
     */
    public abstract Field GetNeighbour(Direction d);

    /**
     * Visszaadja a jelenleg eltárolt, rajta lévő tárgy referenciáját
     * @return
     */
    public abstract Thing getThing();

    /**
     * Egy tárgyat hozzácsatol az aktuális mezőhöz.
     * @param t A csatolandó tárgy
     * @return 0
     */
    //public abstract int Add(Thing t);
    public abstract int Add(Player t);
    public abstract int Add(Box t);

    /**
     * Az éppen rajta álló tárgyat eltávolítja a mezőről
     */
    public abstract void Remove(Thing t);

    /**
     * Virtuális függvény, itt nem csinál semmit
     * @param p
     * @return
     */
    public abstract int Interact(Player p);
    public abstract int Interact(Box b);

    /**
     * A mezőn álló játékos ezzel jelzi helyváltoztatási szándékát.
     * @param d A mozgás iránya
     * @param s A játékos maradék ereje
     * @return
     */
    public abstract int TryMove(Direction d, double s);

    /**
     * A szomszédos mező a felőle érkező mozgás igényt ennek meghívásával jelzi.
     * @param d A mozgás iránya
     * @param t Az érkezni kívánó Thing
     * @param s A játékos maradék ereje
     * @return
     */
    public abstract int TryMove(Direction d, Thing t, double s);

    public abstract void SetThing(Thing t);

    /**
     * Beállítja a mezőn adott effektet
     * @param effect  Effekt
     */
    public abstract void setEffect(double effect);
}