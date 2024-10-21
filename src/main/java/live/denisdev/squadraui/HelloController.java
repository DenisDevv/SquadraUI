package live.denisdev.squadraui;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Arrays;

public class HelloController {
    Giocatore[] giocatori = new Giocatore[11];
    @FXML
    private Pane inputAggGiocatore;
    @FXML
    private TextArea numeGoals;
    @FXML
    private TextArea nomeGiocatore;
    @FXML
    protected void aggiungiGiocatore() {
        popIn(inputAggGiocatore);
    }
    @FXML
    protected void confermaGiocatore() {
        String nome = nomeGiocatore.getText();
        String goals = numeGoals.getText();
        for (int i = 0; i < giocatori.length; i++) {
            if (giocatori[i] == null) {
                giocatori[i] = new Giocatore(nome, Integer.parseInt(goals));
                break;
            }
        }
        popOut(inputAggGiocatore);
        nomeGiocatore.setText("");
        numeGoals.setText("");
    }
    @FXML
    protected void eliminaGiocatore() {
        System.out.println("Rimuovi Giocatore");
    }
    @FXML
    protected void modificaGiocatore() {
        System.out.println("Aggiungi Squadra");
    }
    @FXML
    protected void close() {
        popOut(inputAggGiocatore);
    }
    public void popOut(Pane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(100), pane);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0);
        st.setToY(0);
        st.setOnFinished(e -> pane.setVisible(false));
        st.play();
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
}
