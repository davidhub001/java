public class Poo {
    private int prix = 500;

    public int getprix() {
        return prix;
    }

    public void setprix(int prix) {
        this.prix = prix;
    }

    public static void main(String[] args) {
        Poo objetPoo = new Poo();
        System.out.println(objetPoo.getprix());
    }
}
