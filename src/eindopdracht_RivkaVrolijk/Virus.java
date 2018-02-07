package eindopdracht_RivkaVrolijk;
/**
 * Het importeren van de gebruikte modules.
 */
import java.util.Comparator;
import java.util.List;

/**
 * De class virus met het object virus.
 *
 * In de class van het virus bevindt zich de constructor en getters van de
 * variabelen die gedeclareerd zijn.
 *
 * @author Rivka
 * @version 1.0
 */
public class Virus implements Comparable<Virus> {
    private int Id;
    private String name;
    private List<Integer> hostList;
    private String classification;

    /**
     * Constructor van de variabelen in het object virus.
     *
     * @param virusId Het id van de virus
     * @param name De naam van het virus
     * @param hostList Een lijst van hosts die bij het virus horen
     * @param classification De classificatie van het virus
     */
    public Virus(int virusId, String name, List<Integer> hostList, String classification) {
        this.Id = virusId;
        this.name = name;
        this.hostList = hostList;
        this.classification = classification;
    }

    /**
     * Getter van de variabele virusId.
     *
     * @return een int dat het id van het virus representeerd
     */
    public int getVirusId() {
        return Id;
    }

    /**
     * Getter van de variabele Name.
     *
     * @return een string dat de naam van het virus representeerd
     */
    public String getName() {
        return name;
    }

    /**
     * Getter van de variabele HostList.
     *
     * @return een lijst van Integers dat de hosts van het virus representeren
     */
    public List<Integer> getHostList() {
        return hostList;
    }

    /**
     * Getter van de variabele Classification.
     *
     * @return een string dat de classificatie van het virus representeerd
     */
    public String getClassification() {
        return classification;
    }

    /**
     * toSting methode.
     *
     * @return het id en de naam van het virus
     */
    @Override
    public String toString() {
        return Integer.toString(Id);
    }

    /**
     * Methode voor het vergelijken van de virussen op virusID.
     *
     * @return Sortering virus op id
     */
    @Override
    public int compareTo(Virus v) {
        int compareId = v.getVirusId();
        return this.getVirusId() - compareId;
    }

    /**
     * Sortering virus op classificatie.
     *
     */
    public static Comparator<Virus> VirusClassComparator = new Comparator<Virus>() {
        public int compare(Virus virus1, Virus virus2) {
            return virus1.getClassification().compareTo(virus2.getClassification());

        }

    };

    /**
     * Sortering virus op host.
     */
    public static Comparator<Virus> VirusHostComparator = new Comparator<Virus>() {
        @Override
        public int compare(Virus virus1, Virus virus2) {
            return virus1.getHostList().size() - virus2.getHostList().size();
        }
    };

}
