package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}
