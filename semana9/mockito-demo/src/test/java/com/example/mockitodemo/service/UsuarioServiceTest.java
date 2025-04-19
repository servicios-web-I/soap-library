package com.example.mockitodemo.service;

import com.example.mockitodemo.model.Usuario;
import com.example.mockitodemo.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario(1L, "Juan Pérez", "juan@example.com");
    }

    @Test
    void testObtenerUsuarioPorId() {
        // GIVEN: Simulamos el comportamiento del repositorio
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // WHEN: Llamamos al servicio
        Usuario resultado = usuarioService.obtenerUsuarioPorId(1L);

        // THEN: Verificamos el resultado
        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
        assertEquals("juan@example.com", resultado.getEmail());

        // Verificamos que el método se llamó exactamente una vez
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testRegistrarUsuario() {
        // GIVEN: Simulamos que el repositorio guarda correctamente el usuario
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // WHEN: Llamamos al servicio
        Usuario resultado = usuarioService.registrarUsuario(usuario);

        // THEN: Verificamos el resultado
        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
        assertEquals("juan@example.com", resultado.getEmail());

        // Verificamos que el método se llamó exactamente una vez
        verify(usuarioRepository, times(1)).save(usuario);
    }
}
