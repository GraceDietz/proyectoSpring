package com.miprimeraapp.proyecto1.controller;

import com.miprimeraapp.proyecto1.dto.response.ResponseGreetingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.miprimeraapp.proyecto1.dto.PersonaDto;
@RestController
public class Controller {
    @GetMapping("/hola")
    public String saludar(){
        return "Hola mundo estamos en el curso CAC Spring Boot !";
    }
    @GetMapping("/hola2")
    public String saludar2(){
        return "Hola mundo estamos en el curso CAC Spring Boot 2!";
    }
    @GetMapping("/saludar/{name}")
    public String saludarconnombre(@PathVariable String name){
        return "Hola mundo estamos en el curso CAC Spring Boot 2!"+ name;
    }
    @GetMapping("/saludar2/{name}")
    public String saludarconnombre2(@PathVariable String name){
        return "Estamos en el curso CAC Spring Boot 2!"+ name;
    }
    @GetMapping("/saludar6/{name}/{apellido}")
    public String saludarConNombreApellido(@PathVariable String name,@PathVariable String apellido){
        return "Estamos en el curso CAC Spring Boot 2!"+ name+" "+apellido;
    }
    @GetMapping("/calcular/{saldo}/{dto}")
    public String calculoDtoDeLaCompra(@PathVariable double saldo,@PathVariable double dto){
        double totaldto;
        totaldto= saldo - (saldo*dto/100);
        return "El total a abonar con el dto de :"+dto+" es :"+totaldto;
    }

    @GetMapping("/calculardto")
    public String calculoDto(@RequestParam double saldo, @RequestParam double dto){
        double totaldto;
        totaldto= saldo - (saldo*dto/100);
        return "El total a abonar con el dto de :"+dto+" es :"+totaldto;
    }


    @GetMapping("/misaludo")
    public ResponseEntity<?> saludoRequestPararam(@RequestParam String name,@RequestParam String lastName) {
        ResponseGreetingDto respuesta = new ResponseGreetingDto("Hola " + name +" "+ lastName);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }



    @PostMapping("/guardar")
    public PersonaDto guardarPersona(@RequestBody PersonaDto persona){
        System.out.println(persona);
        return persona;

    }
}
