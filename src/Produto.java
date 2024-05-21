public class Produto {
    private String nome;
    private double preco;
    private int quantidade;


    public Produto(String nome, double preco, int quantidade) {
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "{ "+getNome()+" | R$"+getPreco()+" | Qtde:"+getQuantidade()+" }";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
