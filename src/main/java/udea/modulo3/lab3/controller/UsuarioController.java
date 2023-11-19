package udea.modulo3.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import udea.modulo3.lab3.DTO.UsuarioDTO;
import udea.modulo3.lab3.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
@Api(value = "Usuario Controller", description = "Operaciones sobre el recurso Usuario")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
      
    @PostMapping("/")
    @ApiOperation(value = "Crear un usuario", response = ResponseEntity.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "El usuario ha sido creado correctamente."),
        @ApiResponse(code = 400, message = "El usuario no ha sido creado correctamente.")
    })

    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            System.out.println(usuarioDTO);
            this.usuarioService.crearUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido creado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
