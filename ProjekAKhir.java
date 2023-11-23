
package Samjek;

import java.util.Scanner;

public class ProjekAKhir {
    static int member = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int kendaraan, jarak, berat, pilihan, tarif, totaltarif;
        
        
        
        do {
            System.out.printf("""
                              Pilihan Layanan (pilih angkanya) :
                              1. Naik Ojek
                              2. Kirim Barang 
                              3. Pesan Makanan
                              4. Ayo jadi Member!!!!
                              0. gak jadi
                              
                              """);
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
        
        System.out.println("");
        
        switch (pilihan){
            
            
            case (1) :
                //program naik ojek
                System.out.printf("""
                                  Hari ini mau naik apa? (pilih nomor nya) :
                                  1. Mobil
                                  2. Motor
                                  
                                  """);
                
                do{
                    System.out.print("Pilihan : ");
                    kendaraan = input.nextInt();
                    if (kendaraan == 1)
                        System.out.println("Hari ini naik Mobil");
                    else if (kendaraan == 2)
                        System.out.println("Hari ini naik motor");
                    else 
                        System.out.printf("""
                                          
                                          Bro masukkin angka yang benar!!!
                                          1. Mobil
                                          2. Motor
                                          """);
                }while (kendaraan != 1 && kendaraan != 2);
                
                System.out.print("\nBerapa kisaran jarak destinasi? (Dalam KM) : ");
                jarak = input.nextInt();
                tarif = 0;
                totaltarif = ongkos(kendaraan,jarak,tarif);
                
                System.out.printf("""
                                  
                                  Bayar pakai apa? (pilih angkanya) :
                                  1. Sampay
                                  2. Ova
                                  3. Cash
                                  
                                  """);
                
                do{
                    System.out.print("Pilihan : ");
                    pilihan = input.nextInt();
                   
                }while (pilihan != 1 && pilihan != 2 && pilihan != 3);
                double harga=0;
                double tarifakhir = pembayaran(totaltarif,pilihan,harga);
                
                String ojek="";
                if (kendaraan == 1)
                    ojek = "Mobil";
                else if (kendaraan == 2)
                    ojek = "Motor";
                
                String metode="";
                if (pilihan == 1)
                    metode = "Sampay";
                else if (pilihan == 2)
                    metode = "OVA";
                else if (pilihan == 3)
                    metode = "cash";
                System.out.printf("""
                                  
                                  ==================================
                                  Bill Naik Ojek
                                  
                                  Transportasi      : %s
                                  Jarak             : %d
                                  Metode pembayaran : %s
                                  ==================================
                                  Harga Normal      : Rp %d.00,-
                                  Tarif             : Rp %.2f,-
                                  ==================================
                                  
                                  """,ojek,jarak,metode,totaltarif,tarifakhir);
                break;
                
                
                
            case (4) :
                System.out.println("Ayo jadi Member");
                System.out.println("""
                                   Apakah anda ingin menjadi member dengan membayar sebanyak Rp 150.000 saja?
                                   1. Iya
                                   2. Tidak
                                   """);
                System.out.print("Pilihan : ");
                int choose = input.nextInt();
                System.out.println("");
                if (choose == 1)
                    member = 1;
                else if (choose == 2)
                    member = 0;
                
        }
        }while (pilihan != 0);
        
        
    }
    static int ongkos(int kendaraan, int jarak, int tarif){
        
        if (jarak <= 2) {
                    if (kendaraan == 1) {
                        tarif = 25000;
                    }else if(kendaraan == 2){
                        tarif = 15000;
                    }
                }else{
                    if (jarak <= 5){
                        if (kendaraan == 1){
                            tarif = 40000;
                        }else{
                            tarif = 20000;
                        } 
                    }else{
                        if (jarak <= 10){
                            if (kendaraan == 1){
                                tarif = 65000;
                            }else{
                                tarif = 30000;
                            }
                        }else{
                            if (kendaraan == 1){
                                tarif = jarak*15000;
                            }else{
                                tarif = jarak*8000;
                            }
                        }
                    }
                }
        return tarif;
    }
    static double pembayaran(int tarif,int metodepembayaran, double bayar){
        
        if (metodepembayaran == 1)
            bayar = tarif*0.9;
        else if (metodepembayaran == 2)
            bayar = tarif*0.95;
        else if (metodepembayaran == 3)
            bayar = tarif;
  
       if (member == 1)
           bayar *= 0.9;
        return bayar;
    }
     
        
   
    
}
