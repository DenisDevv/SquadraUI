package live.denisdev.squadraui;

public class Giocatore {
    private String nome;
    private Boolean capitano;
    private int goals;
    public Giocatore (String nome, int goals) {
        setNome(nome);
        capitano = false;
        setGoals(goals);
    }
    public Giocatore () {
        this("Sconosciuto", 0);
    }
    public String getNome() {
        return nome;
    }
    public Boolean getCapitano() {
        return capitano;
    }
    public int getGoals() {
        return goals;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCapitano(Boolean capitano) {
        this.capitano = capitano;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
}
