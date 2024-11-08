package live.denisdev.squadraui;

public class GiocatoreStraniero extends Giocatore {
    private String nationality;
    public GiocatoreStraniero(String nome, int goals, String nationality) {
        super(nome, goals);
        setNationality(nationality);
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return nationality;
    }
    @Override
    public String toString() {
        return getNome() + " (" + getNationality() + ")";
    }
}
