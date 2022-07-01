package br.com.dio.collection.set;

import java.util.*;

public class Exemplo1Set {
    public static void main(String[] args){


        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas.toString());

        System.out.println("Confira se a nota 5.0 está no conjunto: ");
        if (notas.contains(5d)){
            System.out.println("A nota está no conjunto");

        }else {
            System.out.println("A nota não esta no conjunto");
        }

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator= notas.iterator();
        Double soma=0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("A soma do valores é: "+soma);

        System.out.println("Exiba a media das notas: " +soma/ notas.size());

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> menores= notas.iterator();
        while (menores.hasNext()){
            Double next= menores.next();
            if (next<7) menores.remove();

        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas2);

        System.out.println("Exiba todas a notas em ordem crescente: ");
        Set<Double> notas3=new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague o conjunto notas: ");
        notas.clear();

        System.out.println("O conjunto esta vazio?: "+ notas.isEmpty());
        System.out.println("O conjunto esta vazio?: "+ notas2.isEmpty());










    }
}
