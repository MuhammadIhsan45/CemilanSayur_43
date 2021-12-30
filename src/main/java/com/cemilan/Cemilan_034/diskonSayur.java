/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cemilan.Cemilan_034;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author hp
 */

@Controller
public class diskonSayur {
    
    @RequestMapping("/viewbayar")
    public String inputanuser(HttpServletRequest data, Model sayur){
        String nsayur = data.getParameter("var_namasayur");
        String hsayur = data.getParameter("var_hargakilo");
        Integer chsayur = Integer.valueOf(hsayur);
        String jsayur = data.getParameter("var_jumlahbeli");
        String usayur = data.getParameter("var_uangcustomer");
        Double uang = Double.valueOf(usayur);
        String keterangan = data.getParameter("var_keterangan");
        Double cjsayur = Double.valueOf(jsayur);
        Double jumlahbayar = chsayur * cjsayur;
        Double totalbayar;
        Double kembalian;
        Integer diskon = 0;
        Double hargadiskon;
              

        if(jumlahbayar < 16000){
            totalbayar = jumlahbayar - (jumlahbayar*0/100);
            hargadiskon = jumlahbayar*diskon/100;
            
        }else if( jumlahbayar < 25000){
            diskon = 10;
            totalbayar = jumlahbayar - (jumlahbayar*10/100);
            hargadiskon = jumlahbayar*diskon/100;
        }else {
            diskon = 15;
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        
        
        if(uang > totalbayar){
            kembalian = uang - totalbayar;
            keterangan = "Kembalian anda adalah " + kembalian;
            
            
        }else if( uang < totalbayar){
            kembalian = totalbayar - uang ;
            keterangan = "Uang anda kurang " + kembalian;
            
        }else {
            keterangan = "Uang anda suadah pas ";
        }
        
        sayur.addAttribute("uang",uang);
        sayur.addAttribute("ket",keterangan);
        sayur.addAttribute("name",nsayur);
        sayur.addAttribute("price",chsayur);
        sayur.addAttribute("kilo",cjsayur);
        sayur.addAttribute("tbayar",totalbayar);
        sayur.addAttribute("discountrp",hargadiskon);
        sayur.addAttribute("disc",diskon);
        sayur.addAttribute("total10",jumlahbayar);
        return "Muhihsan";
    }
}