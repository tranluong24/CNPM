/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.KhoanThuService;
import view.KhoanThuView;

/**
 *
 * @author MY PC
 */
public class KhoanThuController {
    KhoanThuService service;
    KhoanThuView view;
    
    public KhoanThuController(KhoanThuView view) {
        this.service = new KhoanThuService();
        this.view = view;
    }
    
    
    public void getKhoanThuTable(){
      view.hienThiBangKhoanThu(service.getDSKhoanThu());
    }
    
    
}
