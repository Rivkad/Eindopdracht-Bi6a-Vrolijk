package eindopdracht_RivkaVrolijk;

/**
 * @author Rivka Vrolijk
 * @version 1.0
 *
 * Deze interface is in staat om als epidemioloog, viroloog, geneticus, bioloog
 * of bioinformaticus snel informatie te halen uit bestanden die afkomstig zijn
 * van genome.jp.
 *
 * Deze applicatie biedt de mogelijkheid om informatie te zoeken met de host in
 * plaats van het virus als uitgangspunt.
 * 
 * Met dank aan Ken Odigwe Gomez die ten alle tijden bereid was mij te helpen
 */

/**
 * Het importeren van de gebruikte modulen
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * VirusGUI wordt apart geimplenteerd en bevat de elementen die gebruikt worden
 * voor de events van de gebruiker op de GUI.
 * @author Rivka
 */
public class VirusGUI extends javax.swing.JFrame {
    ArrayList<String> hostNameList = new ArrayList<>();
    VirusLogica virusLogica;

    /**
     * VirusGui roept de methode initComponents en initialize aan
     */
    public VirusGUI() {
        initComponents();
        initialize();
    }

    /**
     * Deze methode word gevraagd vanuit de constructor voor het initializeren
     * van de form Deze methode is automatisch gegenereerd vanuit de Form Editor
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSort = new javax.swing.ButtonGroup();
        IDLabel1 = new javax.swing.JLabel();
        fileField = new javax.swing.JTextField();
        searchFileButton = new javax.swing.JButton();
        classificationLabel = new javax.swing.JLabel();
        viralDropdown = new javax.swing.JComboBox<>();
        IDLabel = new javax.swing.JLabel();
        ID1Combo = new javax.swing.JComboBox<>();
        ID2Combo = new javax.swing.JComboBox<>();
        openButton = new javax.swing.JButton();
        IDRadio = new javax.swing.JRadioButton();
        ClassificationRadio = new javax.swing.JRadioButton();
        hostsRadio = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        virus1List = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        virus2List = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        virus3List = new javax.swing.JList<>();
        compareButton = new javax.swing.JButton();
        Sort = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        infoText = new javax.swing.JTextArea();
        nbLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IDLabel1.setText("Host ID");

        fileField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        searchFileButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        searchFileButton.setText("Search file");
        searchFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFileButtonActionPerformed(evt);
            }
        });

        classificationLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        classificationLabel.setText("Viral classification");

        viralDropdown.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        viralDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "dsDNA", "ssDNA", "ssRNA", "Retroviridae", "Satellites", "Unclassified", " " }));
        viralDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viralDropdownActionPerformed(evt);
            }
        });

        IDLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IDLabel.setText("Host ID");

        ID1Combo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ID1Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID1ComboActionPerformed(evt);
            }
        });

        ID2Combo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ID2Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID2ComboActionPerformed(evt);
            }
        });

        openButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        buttonGroupSort.add(IDRadio);
        IDRadio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IDRadio.setSelected(true);
        IDRadio.setText("ID");

        buttonGroupSort.add(ClassificationRadio);
        ClassificationRadio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ClassificationRadio.setText("Classification");

        buttonGroupSort.add(hostsRadio);
        hostsRadio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        hostsRadio.setText("Number of hosts");

        virus1List.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        virus1List.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                virus1ListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(virus1List);

        virus2List.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        virus2List.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                virus2ListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(virus2List);

        virus3List.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        virus3List.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                virus3ListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(virus3List);

        compareButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        compareButton.setText("Overeenkomsten");
        compareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareButtonActionPerformed(evt);
            }
        });

        Sort.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Sort.setText("Sort");

        infoText.setColumns(20);
        infoText.setRows(5);
        infoText.setText("\n\n\tKies op een virus om hier meer informatie over te krijgen");
        jScrollPane4.setViewportView(infoText);

        nbLabel.setText("NB: Kies eerst een sorterings methode en vervolgens een lijst, op deze manier is het mogelijk om de twee lijsten onafhankelijk van elkaar te sorteren.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(classificationLabel)
                                .addComponent(ClassificationRadio)
                                .addComponent(IDRadio)
                                .addComponent(hostsRadio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ID1Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(viralDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(IDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(ID2Combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(nbLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(compareButton)
                        .addGap(421, 421, 421))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viralDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classificationLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID1Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDLabel)
                            .addComponent(ID2Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassificationRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostsRadio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compareButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nbLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initialize() {
        virusLogica = new VirusLogica();
    }

    /**
     * Methode die wordt aangeroepen wanneer er in de applicatie op de knop
     * search file is gedrukt.
     *
     * Er verschijnt een filechooser waarin er een file kan worden gekozen, het
     * gekozen path is vervolgens te zien in het textfield.
     *
     * Er verschijnt een messagedialog met de melding dat het bestand geopend
     * kan worden.
     *
     * @param evt event
     */
    private void searchFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFileButtonActionPerformed
        int Path;
        File selectedFile;

        JFileChooser jFileChooser = new JFileChooser();
        Path = jFileChooser.showOpenDialog(this);
        if (Path == JFileChooser.APPROVE_OPTION) {
            File selectedFile1 = jFileChooser.getSelectedFile();
            fileField.setText(selectedFile1.getAbsolutePath());
            JOptionPane.showMessageDialog(null, "Klik op 'Open' om het bestand: " + fileField.getText() + " te laden.", "Melding", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_searchFileButtonActionPerformed

    /**
     * Methode die wordt aangeroepen wanneer er in de applicatie op de knop open
     * is gedrukt.
     *
     * De methode openFile wordt aangeroepen afkomsting uit de virusLogica class
     *
     * Er verschijnt een messagedialog met de melding dat het bestand is geladen
     *
     * @param evt event
     */
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        virusLogica.openFile(fileField.getText());
        JOptionPane.showMessageDialog(null, "Het bestand: " + fileField.getText() + " is geladen.", "Melding", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_openButtonActionPerformed

    /**
     * viralDropdownActionPerformed methode voor het beslissen welke
     * classificatie in het dropdown menu is gekozen.
     *
     * Door middel van een switch case statement word gekeken welke
     * classificatie er door de gebruiker is gekozen. De gekozen classificatie
     * word als argument meegegeven aan de methode fillComboLists die te vinden
     * is in de class virusLogica
     *
     * @param evt event
     */
    private void viralDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viralDropdownActionPerformed
        int selected = viralDropdown.getSelectedIndex();
        switch (selected) {
            case 0:
                ID1Combo.setModel(fillComboLists(""));
                ID2Combo.setModel(fillComboLists(""));
                break;
            case 1:
                ID1Combo.setModel(fillComboLists("dsDNA"));
                ID2Combo.setModel(fillComboLists("dsDNA"));
                break;
            case 2:
                ID1Combo.setModel(fillComboLists("ssDNA"));
                ID2Combo.setModel(fillComboLists("ssDNA"));
                break;
            case 3:
                ID1Combo.setModel(fillComboLists("ssRNA"));
                ID2Combo.setModel(fillComboLists("ssRNA"));
                break;
            case 4:
                ID1Combo.setModel(fillComboLists("Retroviridae"));
                ID2Combo.setModel(fillComboLists("Retroviridae"));
                break;
            case 5:
                ID1Combo.setModel(fillComboLists("Satellites"));
                ID2Combo.setModel(fillComboLists("Satellites"));
                break;
            case 6:
                ID1Combo.setModel(fillComboLists("unclassified"));
                ID2Combo.setModel(fillComboLists("unclassified"));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Selecteer een geldige Classificatie", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viralDropdownActionPerformed

    /**
     * Methode ID1ComboActionPerformed voor het verkrijgen van de lijst met
     * virussen die bij het gekozen host horen.
     *
     * De gekozen host wordt uit de comboBox gehaald en de lijst van virussen
     * die zich eventueel al bevonden in de lijst worden verwijderd.
     *
     * Met behulp van de gekozen host van de gebruiker word de lijst met
     * virussen toegevoegd aan de JList.
     *
     * @param evt event
     */
    private void ID1ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID1ComboActionPerformed
        Host chosenHost1 = (Host) ID1Combo.getSelectedItem();
        virus1List.removeAll();
        getVirusListVirusses(chosenHost1, virus1List);
    }//GEN-LAST:event_ID1ComboActionPerformed

    /**
     * compareButtonActionPerformed methode vergelijkt de twee lijsten met
     * virussen met elkaar.
     *
     * De lijsten van virussen worden opgehaald met de gekozen host uit de twee
     * JListen. Een derde lijst word aangemaakt waar beide lijsten zich in
     * bevinden. Indien er zich overeenkomende virussen in de lijst bevinden
     * worden deze weergegeven in de derder JList. Wanneer er geen
     * overeenkomende virussen zijn verschijnt er een message die de gebruiker
     * verteld dat er geen overeenkomsten zijn gevonden.
     *
     * @param evt event
     */
    private void compareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareButtonActionPerformed
        JList<String> list1 = getVirusListVirusses((Host) ID1Combo.getSelectedItem(), virus1List);
        JList<String> list2 = getVirusListVirusses((Host) ID2Combo.getSelectedItem(), virus2List);

        List<Virus> combined = virusLogica.getCombinedVirusses(list1, list2);
        DefaultListModel combinedVirusses = new DefaultListModel();
        
        if (combined.size() != 0) {
            for (Virus v : combined) {
                combinedVirusses.addElement(v);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Geen overeenkomsten", "Error", JOptionPane.ERROR_MESSAGE);
        }

        virus3List.setModel(combinedVirusses);
    }//GEN-LAST:event_compareButtonActionPerformed

    /**
     * Methode ID2ComboActionPerformed voor het verkrijgen van de lijst met
     * virussen die bij het gekozen host horen.
     *
     * De gekozen host wordt uit de comboBox gehaald en de lijst van virussen
     * die zich eventueel al bevonden in de lijst worden verwijderd.
     *
     * Met behulp van de gekozen host van de gebruiker word de lijst met
     * virussen toegevoegd aan de JList.
     *
     * @param evt event
     */
    private void ID2ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID2ComboActionPerformed
        Host chosenHost2 = (Host) ID2Combo.getSelectedItem();
        virus2List.removeAll();
        getVirusListVirusses(chosenHost2, virus2List);
    }//GEN-LAST:event_ID2ComboActionPerformed
    
    /**
     * virus3ListValueChanged methode geeft extra informatie over een virus.
     *
     * De methode roept de showVirus methode aan met als argument het JList waar
     * het virus zich in bevindt.
     *
     * @param evt event
     */
    private void virus3ListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_virus3ListValueChanged
        showVirus(virus3List);
    }//GEN-LAST:event_virus3ListValueChanged
    
    /**
     * virus1ListValueChanged methode geeft extra informatie over een virus.
     *
     * De methode roept de showVirus methode aan met als argument het JList waar
     * het virus zich in bevindt.
     *
     * @param evt event
     */
    private void virus1ListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_virus1ListValueChanged
        showVirus(virus1List);
    }//GEN-LAST:event_virus1ListValueChanged
    
    /**
     * virus2ListValueChanged methode geeft extra informatie over een virus.
     *
     * De methode roept de showVirus methode aan met als argument het JList waar
     * het virus zich in bevindt.
     *
     * @param evt event
     */
    private void virus2ListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_virus2ListValueChanged
        showVirus(virus2List);
    }//GEN-LAST:event_virus2ListValueChanged

    /**
     * Methode die meer informatie geeft over een virus uit de JListen.
     *
     * Wanneer de gebruiker drukt op een virus die zich in een JList bevind
     * verschijnt er een messageDialog waarin er meer informatie over het virus
     * te vinden is.
     *
     * @param list lijst
     */
    private void showVirus(JList<String> list) {
        Object o = list.getSelectedValue();
        Virus v = (Virus) o;
        infoText.removeAll();
        infoText.setText("ID: "+String.valueOf(v.getVirusId())+ "\n");
        infoText.append("Hosts: "+String.valueOf(v.getHostList())+"\n");
        infoText.append("Classification: "+String.valueOf(v.getClassification()+"\n"));
        infoText.append("Name: "+String.valueOf(v.getName())+" ");
    }

    /**
     * getVirusListVirusses is een methode die een lijst met virussen aanmaakt
     * wanneer de gebruiker een host heeft gekozen.
     * 
     * Wanneer er geen virussen zijn gevonden met de gekozen host word dit
     * weergegeven in een messageDialog
     * In het geval dat er wel virussen zijn worden deze toegevoegd aan de 
     * defaultListModel. Deze kunnen vervolgens eventueel gesorteerd worden
     * met behulp van de methode sortVirussen waar de virussen als argument
     * kunnen worden meegegeven.
     *
     * @param host
     * @param viruslist Lijst met alle virussen
     * @return virusList
     */
    private JList<String> getVirusListVirusses(Host host, JList<String> viruslist) {
        if (host != null) {
            List<Virus> virusFromHost = virusLogica.getAllVirussesFromHost(host.getHostId());
            DefaultListModel virusses2 = new DefaultListModel();
            if (virusFromHost == null) {
                JOptionPane.showMessageDialog(null, "Geen virusen gevonden in bestand met de host: " + host + ".", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (Virus v : virusFromHost) {
                    virusses2.addElement(v);
                }
                sortVirusses(virusses2);
                viruslist.setModel(virusses2);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Geen Virussen gevonden die als gastheer: '" + host + "' hebben.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return viruslist;
    }

    /**
     * Methode voor het vullen van de comboLists.
     * 
     * Deze methode roept de methode fillBox aan en vult de combolijst
     * vervolgens met de juiste waarden.
     * 
     * @param classi
     * @return classes
     */
    private DefaultComboBoxModel fillComboLists(String classi) {
        DefaultComboBoxModel classes = new DefaultComboBoxModel();
        for (Host h : virusLogica.fillBox(classi)) {
            classes.addElement(h);
        }
        return classes;
    }

    /**
     * Methode sortVirussen sorteerd de virussen op gekozen sortering.
     * 
     * Een switch case dat kijkt welke optie er door de gebruiker is gekozen
     * om op te sorteren. Wanneer er een sorteringsmethode is gekozen wordt
     * er een methode aangeroepen in de class virusLogica waarbij de gekozen
     * sortering als argument wordt meegegeven.
     * 
     * @param viruslist Lijst met virussen
     */
    private void sortVirusses(DefaultListModel viruslist) {
        for (Enumeration<AbstractButton> buttons = buttonGroupSort.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "ID":
                        virusLogica.sortList(viruslist, "");
                        break;
                    case "Classification":
                        virusLogica.sortList(viruslist, "class");
                        break;
                    case "Number of hosts":
                        virusLogica.sortList(viruslist, "host");
                        break;
                    default:
                        System.out.println("No sorting selected");
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VirusGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VirusGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VirusGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VirusGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirusGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ClassificationRadio;
    private javax.swing.JComboBox<String> ID1Combo;
    private javax.swing.JComboBox<String> ID2Combo;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel IDLabel1;
    private javax.swing.JRadioButton IDRadio;
    private java.awt.Label Sort;
    private javax.swing.ButtonGroup buttonGroupSort;
    private javax.swing.JLabel classificationLabel;
    private javax.swing.JButton compareButton;
    private javax.swing.JTextField fileField;
    private javax.swing.JRadioButton hostsRadio;
    private javax.swing.JTextArea infoText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nbLabel;
    private javax.swing.JButton openButton;
    private javax.swing.JButton searchFileButton;
    private javax.swing.JComboBox<String> viralDropdown;
    private javax.swing.JList<String> virus1List;
    private javax.swing.JList<String> virus2List;
    private javax.swing.JList<String> virus3List;
    // End of variables declaration//GEN-END:variables
}
