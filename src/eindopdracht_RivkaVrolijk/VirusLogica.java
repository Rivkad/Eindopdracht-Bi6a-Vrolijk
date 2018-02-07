package eindopdracht_RivkaVrolijk;

/**
 * importeren van de gebruikte modules.
 */
import eindopdracht_RivkaVrolijk.VirusGUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * De class virusLogica bevat de datasetstructruren en de methodes die worden
 * aangeroepen vanuit de virusGui.
 *
 * @author Rivka
 */
public class VirusLogica {

    ArrayList<Integer> hostsInVirus;
    ArrayList<Host> hostList;
    HashMap<String, Virus> map;
    List<Virus> virusList;

    /**
     * VirusLogica initialiseert de variabelen.
     */
    public VirusLogica() {
        hostList = new ArrayList<>();
        map = new HashMap<>();
        virusList = new ArrayList<>();
    }

    /**
     * Getter van de variabele HostList
     *
     * @return hostList
     */
    public List<Host> getHostList() {
        return hostList;
    }

    /**
     * Getter van de variabele Map
     *
     * @return map
     */
    public HashMap<String, Virus> getMap() {
        return map;
    }

    /**
     * Getter van de variabele virusList.
     *
     * @return virusList
     */
    public List<Virus> getVirusList() {
        return virusList;
    }

    /**
     * getHostListsFromVirus maakt een lijst van alle hosts die bij een virus
     * horen.
     * 
     * Er word een arrayList aangemaakt en for elk hostId word er gekeken bij 
     * welk virus dit hoort en dit host word toegevoegd aan de bijbehorende
     * lijst van het virus.
     * 
     * @param v
     * @return hostListFromVirus
     */
    public List<Host> getHostListFromVirus(Virus v) {
        ArrayList<Host> hostListFromVirus = new ArrayList<>();
        for (int hostId : v.getHostList()) {
            for (Host host : hostList) {
                if (host.getHostId() == (hostId)) {
                    hostListFromVirus.add(host);
                }
            }
        }
        System.out.println(hostList);
        return hostListFromVirus;
    }

    /**
     * getAllVirussesFromHost zoekt alle virussen die bij een host horen.
     * 
     * Er word een lijst aangemaakt en vervolgens gekeken of het hostId overeenkomt
     * deze worden toegevoegd aan de lijst.
     * 
     * @param hostId
     * @return VirussesFromHost
     */
    public List<Virus> getAllVirussesFromHost(int hostId) {
        ArrayList<Virus> virussesFromHost = new ArrayList<>();
        for (Virus v : virusList) {
            for (int h : v.getHostList()) {
                if (h == hostId) {
                    virussesFromHost.add(v);
                }
            }
        }
        return virussesFromHost;
    }

    /**
     * OpenFile opent een leest het bestand.
     * 
     * Elke regel wordt gesplit op tab en de nodige variabelen worden uit
     * de kolommen gehaald.
     * Voor elk virus word een nieuw object aangemaakt.
     * 
     * Alle hosts worden aan een list toegevoegd, wanneer een virus nog niet in
     * de map bevind wordt deze toegevoegd.
     * 
     * Exceptions worden afgevangen.
     * @param fileLocation 
     */
    public void openFile(String fileLocation) {
        BufferedReader inFile;
        String line;

        try {
            inFile = new BufferedReader(new FileReader(fileLocation));
            inFile.readLine();

            while ((line = inFile.readLine()) != null) {
                String[] virusses = line.split("\\t");
                int virusId = Integer.parseInt(virusses[0]);
                String name = virusses[1];
                String classification = virusses[2];
                int hostId = Integer.parseInt(virusses[7]);
                String hostName = virusses[8];

                hostsInVirus = new ArrayList<>();
                hostsInVirus.add(hostId);
                Host host = new Host(hostId, hostName);
                
                Virus virus = new Virus(virusId, name, hostsInVirus, classification);

                if (!hostList.contains(host)) {
                    hostList.add(host);
                }

                if (map.containsKey(virus.getName())) {
                    if (!map.get(name).getHostList().contains(hostId)) {
                        map.get(name).getHostList().add(hostId);
                    }
                } else {
                    virusList.add(virus);
                    map.put(virus.getName(), virus);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VirusGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VirusGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * De fillBox methode vult boxList met bijbehorende host uit de gekozen
     * classificatie.
     * 
     * Er word een hashset aangemaakt. Wanneer de gekozen classificatie
     * overeenkomt met de classificatie van het virus word deze toegevoegd
     * aan de boxList.
     * 
     * @param classification
     * @return boxList
     */
    public Set<Host> fillBox(String classification) {
        Set<Host> boxList = new HashSet<>();
        for (Virus v : virusList) {
            if (v.getClassification().contains(classification)) {
                for (Host h : getHostListFromVirus(v)) {
                    boxList.add(h);
                }
            }
        }
        return boxList;
    }

    /**
     * getCombinedVirusses geeft de overeenkomende virussen uit de twee
     * lijsten.
     * 
     * Er worden twee lijsten aangemaakt. Voor de gevonden virussen in beide
     * Jlisten wordt deze toegevoegd aan de hiervoor gedeclareerde lijsten.
     * Met behulp van retainAll worden de overeenkomende virussen eruit 
     * gefilterd.
     * 
     * @param list1
     * @param list2
     * @return virusList1
     */
    public List<Virus> getCombinedVirusses(JList<String> list1, JList<String> list2) {
        ArrayList<Virus> viruslist1 = new ArrayList<>();
        ArrayList<Virus> viruslist2 = new ArrayList<>();
        for (int i = 0; i < list1.getModel().getSize(); i++) {
            Object item = list1.getModel().getElementAt(i);
            viruslist1.add((Virus) item);
        }
        for (int i = 0; i < list2.getModel().getSize(); i++) {
            Object item = list2.getModel().getElementAt(i);
            viruslist2.add((Virus) item);
        }
        viruslist1.retainAll(viruslist2);

        return viruslist1;
    }

    /**
     * SortList sorteerd de elementen op basis van de gekozen volgorde.
     * 
     * Door middel van een switch case statement wordt de gekozen sortering
     * meegegeven aan de collections.sort methode.
     * De elementen worden vervolgens opnieuw in de lijst gezet.
     * 
     * @param dlm
     * @param sort 
     */
    public void sortList(DefaultListModel dlm, String sort) {
        Collection list = Collections.list(dlm.elements());
        switch (sort) {
            case "class":
                Collections.sort((List<Virus>) list, Virus.VirusClassComparator);
                break;
            case "host":
                Collections.sort((List<Virus>) list, Virus.VirusHostComparator);
                break;
            default:
                Collections.sort((List<Virus>) list);
        }
        dlm.clear();
        for (Object v : list) {
            dlm.addElement(v);
        }
    }

}
