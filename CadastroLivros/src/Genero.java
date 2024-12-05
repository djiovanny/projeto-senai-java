enum Genero {
    AUTOAJUDA(1, "Autoajuda"),
    BIOGRAFIAS(2, "Biografias e Histórias Reais"),
    EDUCACAO(3, "Educação e Didáticos"),
    HISTORIA(4, "História"),
    HQS(5, "HQs, Mangás e Graphic Novels"),
    INFANTIL(6, "Infantil"),
    LITERATURA(7, "Literatura e Ficção"),
    RELIGIAO(8, "Religião e Espiritualidade"),
    ROMANCE(9, "Romance"),
    SUSPENSE(10, "Suspense");

    private final int codigo;
    private final String nome;

    Genero(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    Genero(float i, String string, int codigo, String nome) {

        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static Genero getGeneroByCodigo(int codigo) {
        for (Genero g : values()) {
            if (g.getCodigo() == codigo) {
                return g;
            }
        }
        return null;
    }
}