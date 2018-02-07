package eindopdracht_RivkaVrolijk;

/**
 * De class Host met het object Host.
 *
 * In de class van het virus bevindt zich de constructor en getters van de
 * variabelen die gedeclareerd zijn.
 *
 * @author Rivka
 * @version 1.0
 */
public class Host {

    private int hostId;
    private String hostName;

    /**
     * Constructor van de variabelen in het object host.
     *
     * @param hostId het ID van de host
     * @param hostName de naam van de host
     */
    public Host(int hostId, String hostName) {
        this.hostId = hostId;
        this.hostName = hostName;
    }

    /**
     * Getter van de variabele hostId.
     * @return hostId het ID van de host
     */
    public int getHostId() {
        return hostId;
    }

    /**
     * Getter van de variabele HostName.
     * @return HostName de naam van de host
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * toString methode.
     * @return hostId + " (" + hostName + ")"
     */
    @Override
    public String toString() {
        return hostId + " (" + hostName + ")";
    }
}
