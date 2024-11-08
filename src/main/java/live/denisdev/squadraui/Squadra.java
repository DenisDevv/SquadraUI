package live.denisdev.squadraui;

public class Squadra {
    protected Giocatore[] giocatori = new Giocatore[11];
    private String nome;
    private String allenatore;
    public Squadra(String nome, String allenatore) {
        setNome(nome);
        setAllenatore(allenatore);
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAllenatore(String allenatore) {
        this.allenatore = allenatore;
    }
    public String getNome() {
        return nome;
    }
    public String getAllenatore() {
        return allenatore;
    }
    public void creaGiocatore(String nome, int goals, int i) {
            giocatori[i] = new Giocatore(nome, goals);
    }
    public void eliminaGiocatore(int i, int x) {
        giocatori[i] = giocatori[x];
        giocatori[x] = null;
    }
}
