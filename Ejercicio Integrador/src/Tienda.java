
package ejercicio.integrador;
import javax.swing.JOptionPane;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marip
 */
public class Tienda {

    // Ventas semanales en una matriz de tamaño 7xN
    //Cada fila representa un dia de la semana
    // Cada columna las ventas diarias de un producto
    // Los nombres de los productos estan almacenados en un vector de cadenas de tamaño N.
    private String[] productos;
    private int[][] ventas;
    private String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    //Calcular el total de ventas por producto
    public Tienda(int cantidad) {
        this.productos = new String[cantidad];
        this.ventas = new int[7][cantidad];

    }
    // Para almacenar los productos 

    public void registrarProductos() {
        for (int i = 0; i < productos.length; i++) {
            productos[i] = JOptionPane.showInputDialog("Nombre del producto " + (i + 1) + ":");

        }
    }
    //Para llenar la matrizz de ventas con los valores aleatoriso

    public void generarVentas() {
        Random random = new Random();
        for (int dia = 0; dia < 7; dia++) {
            for (int j = 0; j < productos.length; j++) {
                ventas[dia][j] = random.nextInt(10);

            }
        }
    }

    public void totalPorProducto() {
        String resultado = "Total de ventas por producto:\n";
        for (int c = 0; c < productos.length; c++) {
            int sumaColumna = 0;
            for (int f = 0; f < 7; f++) {
                sumaColumna += ventas[f][c];
            }
            resultado += productos[c] + ": " + sumaColumna + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);

    }
    //Se necesita calcular el dia en el q hubo mas venta.

    public void diaMayorVenta() {
        int mayorVenta = -1;
        String diaMayor = "";

        for (int f = 0; f < 7; f++) {
            int sumaFila = 0;
            for (int c = 0; c < productos.length; c++) {
                sumaFila += ventas[f][c];
            }
            if (sumaFila > mayorVenta) {
                mayorVenta = sumaFila;
                diaMayor = dias[f];
            }
        }
        JOptionPane.showMessageDialog(null, "El día con mayores ventas es " + diaMayor + " con " + mayorVenta + " ventas.");
    }

    public void ProductoMasVendido() {
        int granMayor = -1;
        String productoTop = "";

        for (int c = 0; c < productos.length; c++) {
            int sumaCol = 0;
            for (int f = 0; f < 7; f++) {
                sumaCol += ventas[f][c];
            }
            if (sumaCol > granMayor) {
                granMayor = sumaCol;
                productoTop = productos[c];
            }
        }
        JOptionPane.showMessageDialog(null, "El producto más vendido es: " + productoTop + " (" + granMayor + " unidades) ");
    }

}
