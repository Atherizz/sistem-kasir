package com.tutorial;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Latihan {

    public static void main(String[] args) throws IOException {
        
        String[] barang = new String[4];
        int[] harga = new int[4];
        int[] jumlah = new int[4];

        Scanner scanner = new Scanner(System.in);

        System.out.println("SISMA MART");
        System.out.println("SELAMAT DATANG DI SISMA MART \nSelamat Berbelanja!");
        System.out.println("PROMO!! ----- PEMBELIAN DI ATAS 100.000 AKAN MENDAPATKAN DISKON 20%");
        System.out.println("TERIMA KASIH TELAH BERBELANJA");

        for (int i = 0; i < 4; i++) {
            System.out.print("Masukkan Barang " + (i + 1) + ":");
            barang[i] = scanner.nextLine();

            jumlah[i] = getValidIntInput("Masukkan Jumlah barang: " + (i+1) + ":");
            harga [i] = getValidIntInput("Masukkan Harga barang : " + (i+1) + ":");
        }

        String barangBelanja = String.join(",", barang);
        int totalHarga = (harga[0] * jumlah[0]) + (harga[1] * jumlah[1]) + (harga[2] * jumlah[2]) + (harga[3] * jumlah[3]);
        int uangBayar, kembalian;

        if (totalHarga > 100000) {
            totalHarga = totalHarga * 80 / 100;
        }

        StringTokenizer stringToken = new StringTokenizer(barangBelanja, ",");
        System.out.println("\nBARANG BELANJAAN ANDA: ");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + jumlah[i] + " " + stringToken.nextToken() + " ----> " + harga[i] * jumlah[i]);
        }
        System.out.println("\nTotal Harga : " + totalHarga);

        getYesOrNo("Apakah anda yakin ingin melanjutkan pembayaran?");

        System.out.println("Masukkan uang yang dibayarkan: ");
        uangBayar = getValidIntInput("");
        kembalian = uangBayar - totalHarga;

        System.out.println("Pembayaran : " + uangBayar);

        if (uangBayar < totalHarga) {
            System.out.println("Maaf, uang anda tidak cukup");
        } else if (uangBayar > totalHarga) {
            System.out.println("Kembalian anda : " + kembalian);
        } else {
            System.out.println("Terima Kasih sudah memberi uang pas");
        }

        scanner.close();
    }

    private static int getValidIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.err.println("Masukkan nominal angka!");
            }
        }
    }

    private static boolean getYesOrNo(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + message + " (y/n?)");
        String pilihanUser = scanner.nextLine();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.out.println("Maaf pilihan anda bukan y / n \nSilahkan masukkan y/n");
            System.out.println("\n" + message + " (y/n?)");
            pilihanUser = scanner.nextLine();
        }

        if (pilihanUser.equalsIgnoreCase("n")) {
            System.exit(0); // Menghentikan program jika memilih 'n'
        }

        return pilihanUser.equalsIgnoreCase("y");
    }
}
