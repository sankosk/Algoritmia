
import utils.Estado;

import java.util.ArrayList;


public class Subset1 extends Estado {
    private static int[] v;
    private static int k;
    private static int c;
    private boolean[] marca;
    private int s;
    private int escogidos;

    public Subset1(int n, int k, int c) {
        super();
        Subset1.k = k;
        Subset1.c = c;
        Subset1.v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = i + 1;
        }

        this.marca = new boolean[n];
    }

    private Subset1(Subset1 parent, boolean[] marca, int tos) {
        super();
        idPadre = parent.id;
        this.marca = marca;
        this.s = parent.s + tos;
        this.profundidad = parent.profundidad + 1;
        if (tos != 0) escogidos = parent.escogidos + 1;
        else escogidos = parent.escogidos;
        calcularValorHeuristico();

    }

    @Override
    public void calcularValorHeuristico() {
    	//Estado no válido
        if (escogidos > k || s > c) valorHeuristico = Integer.MAX_VALUE;
        
        //Solucion
        else if (c == s && escogidos == k) valorHeuristico = Integer.MIN_VALUE;
        
        //suma correcta, pero profundidad incorrecta
        else if (c - s == 0 && escogidos != k) valorHeuristico = Integer.MAX_VALUE;
        
        //caso general
        else valorHeuristico = (c - s);

    }

    @Override
    public ArrayList<Estado> expandir() {
        ArrayList<Estado> ret = new ArrayList<>();
        boolean[] marca1 = this.marca.clone();
        Subset1 v1 = new Subset1(this, marca1, 0);
        boolean[] marca2 = this.marca.clone();
        marca2[profundidad] = true;
        Subset1 v2 = new Subset1(this, marca2, v[profundidad]);
        ret.add(v1);
        ret.add(v2);
        return ret;
    }

    @Override
    public int valorInicialPoda() {
        return c + 1;
    }

    @Override
    public boolean solucion() {
        return escogidos == k && s == c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Suma acumulada: " + s).append("\n");
        for (int i = 0; i < marca.length; i++) {
            sb.append(v[i] + ":" + marca[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
