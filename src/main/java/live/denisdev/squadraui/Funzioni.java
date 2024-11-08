package live.denisdev.squadraui;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Funzioni {
    private Squadra squadra = new Squadra("Sconosciuto", "Sconosciuto");
    @FXML
    private Pane inputAggGiocatore;
    @FXML
    private Pane inputEliGiocatore;
    @FXML
    private Pane inputModGiocatore;
    @FXML
    private TextArea numeGoals;
    @FXML
    private TextArea nomeGiocatore;
    @FXML
    private TextArea numeroGiocatore;
    @FXML
    private TextArea numeGoals1;
    @FXML
    private TextArea nomeGiocatore1;
    @FXML
    private TextArea numeroGiocatore1;
    @FXML
    private ListView<String> listaGiocatori;
    @FXML
    private CheckBox capitano;
    private Boolean capitanoAvailable = true;
    @FXML
    protected void aggiungiGiocatore() {
        popIn(inputAggGiocatore);
    }

    @FXML
    protected void confermaGiocatore() {
        String nome = nomeGiocatore.getText();
        int i = ultimoDisponibile();
        if (i != -1) {
            squadra.creaGiocatore(nome, Integer.parseInt(numeGoals.getText()), i);
        }
        nomeGiocatore.setText("");
        numeGoals.setText("");
        popOut(inputAggGiocatore);
    }

    @FXML
    protected void confermaEliGiocatore() {
        int index = Integer.parseInt(numeroGiocatore1.getText());
        int x = ultimoDisponibile()-1;
        if (x != -1) {
            squadra.eliminaGiocatore(index, x);
        }
        numeroGiocatore1.setText("");
        popOut(inputEliGiocatore);
    }

    @FXML
    protected void confermaModGiocatore() {
        int index = Integer.parseInt(numeroGiocatore.getText());
        squadra.giocatori[index].setNome(nomeGiocatore1.getText());
        squadra.giocatori[index].setGoals(Integer.parseInt(numeGoals1.getText()));
        if (squadra.giocatori[index].getCapitano() && !capitano.isSelected()) {
            capitanoAvailable = true;
        }
        squadra.giocatori[index].setCapitano(capitano.isSelected());
        if (capitano.isSelected()) {
            capitanoAvailable = false;
        }

        capitano.setSelected(false);
        nomeGiocatore1.setText("");
        numeGoals1.setText("");
        numeroGiocatore.setText("");
        popOut(inputModGiocatore);
    }

    @FXML
    protected void eliminaGiocatore() {
        popIn(inputEliGiocatore);
    }

    @FXML
    protected void modificaGiocatore() {
        popIn(inputModGiocatore);
        capitano.setDisable(true);
    }

    @FXML
    protected void close() {
        popOut(inputAggGiocatore);
        popOut(inputModGiocatore);
        popOut(inputEliGiocatore);
    }
    @FXML
    protected void capitano() {
        if (numeroGiocatore.getText() == null || numeroGiocatore.getText().equals("")) {
            return;
        }
        if (capitanoAvailable)
            capitano.setDisable(false);
        else {
            capitano.setDisable(!squadra.giocatori[Integer.parseInt(numeroGiocatore.getText())].getCapitano());
        };
    }
    public void popOut(Pane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(100), pane);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0);
        st.setToY(0);
        st.setOnFinished(e -> pane.setVisible(false));
        st.play();
        aggiornaLista();
    }

    public void popIn(Pane pane) {
        pane.setVisible(true);
        ScaleTransition st = new ScaleTransition(Duration.millis(100), pane);
        st.setFromX(0);
        st.setFromY(0);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

    public int ultimoDisponibile() {
        for (int i = 0; i < squadra.giocatori.length; i++) {
            if (squadra.giocatori[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void aggiornaLista() {
        for (Giocatore giocatore : squadra.giocatori) {
            if (giocatore != null) {
                ObservableList<String> items = FXCollections.observableArrayList();
                for (int j = 0; j < squadra.giocatori.length; j++) {
                    if (squadra.giocatori[j] != null) {
                        items.add(j + " - " + squadra.giocatori[j].getNome() + " - " + squadra.giocatori[j].getGoals() + " - " + squadra.giocatori[j].getCapitano());
                    }
                }
                listaGiocatori.setItems(items);
            }
        }
    }
}