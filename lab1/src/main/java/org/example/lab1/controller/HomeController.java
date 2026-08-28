//ceacion del controlador para poder recibir los datos enviados desde el formulari

package org.example.lab1.controller;
import org.example.lab1.model.Equipo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/equipos")
public class HomeController {
    private static List<Equipo> listaEquipos = new ArrayList<>();
    // contador simple para ir asignando un id distinto a cada equipo que se va  a registra
    private static int contadorId = 1;
    @GetMapping
    public String home() {
        return "redirect:/equipos/registro";
    }
    // esto muestra el formulario html, solo carga la vista, no recibe nada
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro";
    }
    // aca se procesa el envio del formulario
    @PostMapping("/registrar")
    public String registrarEquipo(@RequestParam("nombre") String nombre,
                                  @RequestParam("tipo") String tipo,
                                  @RequestParam("codigoActivo") String
                                          codigoActivo,
                                  @RequestParam("fechaAdquisicion") String
                                          fechaAdquisicion,
                                  Model model) {
        // como pide el enunciado lA instanciO el modelo de forma manual
        Equipo equipo = new Equipo();
        equipo.setId(contadorId);
        equipo.setNombre(nombre);
        equipo.setTipo(tipo);
        equipo.setCodigoActivo(codigoActivo);
        equipo.setFechaAdquisicion(fechaAdquisicion);
        contadorId = contadorId + 1;
        listaEquipos.add(equipo);
        // para que vea que su equipo ya quedo guardado
        return "redirect:/equipos/listado";
    }
    // vista que lista todos los equipos registrados hasta el momento
    @GetMapping("/listado")
    public String listarEquipos(Model model) {
        // aca uso  el objeto Model con addAttribute para mandar la lista a la vista
        model.addAttribute("equipos", listaEquipos);
        return "listado";
    }
    // buscador por codigo de activo
    @GetMapping("/buscar/{codigo}")
    public String buscarPorCodigo(@PathVariable("codigo") String codigo, Model
            model) {
        List<Equipo> resultadoBusqueda = new ArrayList<>();
        for (Equipo e : listaEquipos) {
            if (e.getCodigoActivo().equalsIgnoreCase(codigo)) {
                resultadoBusqueda.add(e);
            }
        }
        model.addAttribute("equipos", resultadoBusqueda);
        model.addAttribute("busqueda", codigo);
        return "listado";
    }
}
