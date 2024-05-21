import java.util.HashMap;
import java.util.Map;

public class Estoque {
    static HashMap<Long, Produto> estoqueProdutos = new HashMap<Long, Produto>();

    public static void main(String[] args) {
        // Adiciona produtos ao estoque
        adicionarProduto(1L, "Notebook", 1500.0, 1);
        adicionarProduto(2L, "Mouse", 25.0, 2);
        adicionarProduto(3L, "Monitor",400.0, 5);
        adicionarProduto(4L, "Teclado", 40.0, 10);

        System.out.println("----------------------------------");
        exibirProdutos();
        System.out.println("----------------------------------");
        System.out.println("Valor Total do estoque: " + calcularValorTotalEstoque());
        System.out.println("----------------------------------");
        System.out.println("Produto mais caro:\n"+obterProdutoMaisCaro());
        System.out.println("----------------------------------");
        System.out.println("Produto mais barato:\n"+obterProdutoMaisBarato());
        System.out.println("----------------------------------");
        System.out.println("Produto com maior valor agregado:\n"+obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }

    static void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        estoqueProdutos.put(cod, new Produto(nome,preco,quantidade));
    }

    static void exibirProdutos() {
        if (estoqueProdutos.isEmpty()) {
            System.out.println("O Estoque está vazio! Por favor, adicione items.");
        } else {
            System.out.println(estoqueProdutos);
        }
    }

    static double calcularValorTotalEstoque() {
        double sum = 0d;

        if (estoqueProdutos.isEmpty()) {
            System.out.println("O Estoque está vazio! Por favor, adicione items.");
        } else {
            for (Produto produto : estoqueProdutos.values()) {
                sum += produto.getPreco() * produto.getQuantidade();
            }
        }

        return sum;
    }

    static Produto obterProdutoMaisCaro() {
        long maisCaro = 0L;
        double valorMaisCaro = 0d;

        if (estoqueProdutos.isEmpty()) {
            System.out.println("O Estoque está vazio! Por favor, adicione items.");
        } else {
            for (Produto produto : estoqueProdutos.values()) {
                if (produto.getPreco() > valorMaisCaro) {
                    valorMaisCaro = produto.getPreco();
                }
            }
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                if (entry.getValue().getPreco() == valorMaisCaro) {
                    maisCaro = entry.getKey();
                }
            }
        }

        return  estoqueProdutos.get(maisCaro);
    }

    static Produto obterProdutoMaisBarato() {
        long maisBarato = 0L;
        double valorMaisBarato = 9999999.0d;

        if (estoqueProdutos.isEmpty()) {
            System.out.println("O Estoque está vazio! Por favor, adicione items.");
        } else {
            for (Produto produto : estoqueProdutos.values()) {
                if (produto.getPreco() < valorMaisBarato) {
                    valorMaisBarato = produto.getPreco();
                }
            }
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                if (entry.getValue().getPreco() == valorMaisBarato) {
                    maisBarato = entry.getKey();
                }
            }
        }

        return  estoqueProdutos.get(maisBarato);
    }

    static Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        long maisEstoque = 0L;
        double valorComMaiorEstoque = 0d;

        if (estoqueProdutos.isEmpty()) {
            System.out.println("O Estoque está vazio! Por favor, adicione items.");
        } else {
            for (Produto produto : estoqueProdutos.values()) {
                if ((produto.getPreco() * produto.getQuantidade()) > valorComMaiorEstoque) {
                    valorComMaiorEstoque = produto.getPreco();
                }
            }
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                if (entry.getValue().getPreco() == valorComMaiorEstoque) {
                    maisEstoque = entry.getKey();
                }
            }
        }

        return  estoqueProdutos.get(maisEstoque);
    }
}