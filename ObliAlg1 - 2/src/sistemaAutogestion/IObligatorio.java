package sistemaAutogestion;
public interface IObligatorio {
    //**************** REGISTROS **************************************
        // Método para crear el sistema de gestión
    // Precondiciones: Ninguna
    // Postcondiciones: Se crea un nuevo sistema de gestión, eliminando cualquier aerolínea existente.
    public Retorno crearSistemaDeGestion();
    
    // Método para crear una aerolínea
    // Precondiciones: El nombre, país y cantidad máxima de aviones no deben ser nulos.
    // Postcondiciones: Se registra una nueva aerolínea en el sistema con los detalles proporcionados.
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones); 
    
    // Método para eliminar una aerolínea
    // Precondiciones: El nombre de la aerolínea a eliminar no debe ser nulo.
    // Postcondiciones: Se elimina la aerolínea especificada si no tiene aviones registrados.
    public Retorno eliminarAerolinea(String nombre); 
    
    // Método para registrar un avión
    // Precondiciones: El código, la capacidad máxima y el nombre de la aerolínea no deben ser nulos.
    // Postcondiciones: Se registra un nuevo avión en la aerolínea especificada con los detalles proporcionados.
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea); 
    
    // Método para eliminar un avión
    // Precondiciones: El nombre de la aerolínea y el código del avión a eliminar no deben ser nulos.
    // Postcondiciones: Se elimina el avión especificado si no tiene ningún viaje con pasajes vendidos.
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    
    // Método para registrar un cliente
    // Precondiciones: El pasaporte debe ser un código alfanumérico de 7 caracteres, el nombre no debe ser nulo, y la edad debe ser mayor o igual a 0.
    // Postcondiciones: Se registra un nuevo cliente en el sistema con los detalles proporcionados.
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    //pre:      post:
   
    //**************** GESTIÓN DE VUELOS Y PASAJES **************************************
     // Método para crear un vuelo
    // Precondiciones: Todos los parámetros deben ser válidos y la cantidad de pasajes de cada categoría debe ser múltiplo de 3 y >= 3.
    // Postcondiciones: Se crea un nuevo vuelo en el sistema con los detalles proporcionados.
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    
    // Método para comprar un pasaje
    // Precondiciones: El pasaporte del cliente, el código del vuelo y la categoría del pasaje deben ser válidos.
    // Postcondiciones: Se registra la compra del pasaje para el cliente en el vuelo especificado.
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    
    // Método para devolver un pasaje
    // Precondiciones: El pasaporte del cliente y el código del vuelo deben ser válidos.
    // Postcondiciones: Se realiza la devolución del pasaje comprado anteriormente por el cliente.
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);
    
    //**************** REPORTES Y CONSULTAS **************************************
    
    // Método para listar aerolíneas
    // Precondiciones: Ninguna
    // Postcondiciones: Se listan todas las aerolíneas registradas en el sistema en orden alfabético.
    public Retorno listarAerolineas();
    
    // Método para listar aviones de una aerolínea
    // Precondiciones: El nombre de la aerolínea no debe ser nulo.
    // Postcondiciones: Se listan todos los aviones registrados para la aerolínea especificada.
    public Retorno listarAvionesDeAerolinea(String nombre);
    
    // Método para listar clientes
    // Precondiciones: Ninguna
    // Postcondiciones: Se listan todos los clientes registrados en el sistema en orden de registro, utilizando recursión.
    public Retorno listarClientes();
    
    // Método para listar vuelos
    // Precondiciones: Ninguna
    // Postcondiciones: Se listan todos los vuelos registrados en el sistema.
    public Retorno listarVuelos();
    
    // Método para listar vuelos de un cliente
    // Precondiciones: El pasaporte del cliente debe ser válido.
    // Postcondiciones: Se listan todos los vuelos para los cuales el cliente ha comprado pasajes, indicando las compras y devoluciones.
    public Retorno vuelosDeCliente(String pasaporte);
    
    // Método para listar pasajes devueltos de una aerolínea
    // Precondiciones: El nombre de la aerolínea no debe ser nulo.
    // Postcondiciones: Se listan todos los pasajes devueltos para la aerolínea especificada.
    public Retorno pasajesDevueltos(String nombreAerolinea);
    
    // Método para ver la distribución de pasajeros en un vuelo
    // Precondiciones: El código del vuelo debe ser válido.
    // Postcondiciones: Se muestra la distribución de pasajeros en el avión según las diferentes categorías de pasajes.
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
}
