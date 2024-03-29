package com.roderly.microbiomelabufu.menu.controller;

import com.roderly.microbiomelabufu.consulta.dto.response.ConsultaCompletaResponse;
import com.roderly.microbiomelabufu.menu.dto.response.MenuLateralResponse;
import com.roderly.microbiomelabufu.menu.dto.response.VueRouterResponse;
import com.roderly.microbiomelabufu.menu.service.MenuService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/load")
    public ResponseEntity <List<MenuLateralResponse>> getMenuLateral() {
        var response = menuService.buscarDadosMenu();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/router")
    public ResponseEntity <List<VueRouterResponse>> getRouter() {
        var response = menuService.buscarDadosRouter();
        return ResponseEntity.ok(response);
    }

}
