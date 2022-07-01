package br.com.dio.collection.set;
/* Dados as seguintes informaçoes sobre minhas series favoritas,
* crie um conjunto e ordene este conjunto exibindo
* (nome - genero - tempo de episodio)
* Serie 1: Nome: got, genero: fantasia, tempoEpisodio:60
* Serie 2: Nome: dark, genero: drama, tempoEpisodio:60
* Serie 1: Nome: that '70s show, genero: comedia, tempoEpisodio:25 */

import java.util.*;

public class ExemploOrdenaçaoSet {
    public static void main(String[] args) {
        System.out.println("Ordem Aleaotorio: ");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie : minhasSeries)
            System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" + serie.getTempoEpisodio());

//Ordem de inserção
        Set<Serie> minhasSeriesLin = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie : minhasSeriesLin)
            System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" + serie.getTempoEpisodio());
//Ordem natural por tempo de Episodio
        System.out.println("Ordem Natural (tempoEpisodio)");
        Set<Serie> minhasSeriesTree = new TreeSet<>(minhasSeriesLin);
        System.out.println(minhasSeriesTree);
        for (Serie serie : minhasSeriesTree)
            System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" + serie.getTempoEpisodio());


        System.out.println("Ordem Nome/Genero/TempoEpisodio ");
        Set<Serie> minhasSeriesNGT = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());

        for (Serie serie : minhasSeriesTree)
            System.out.println(serie.getNome() + "-" + serie.getGenero() + "-" + serie.getTempoEpisodio());

    }
}


//Primero tenemos que crear una clase pra poder colocar los atributos

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }



    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(),serie.getTempoEpisodio());
        if (tempoEpisodio!=0) return tempoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }
}
class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome!=0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero!=0) return  genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

    }
}