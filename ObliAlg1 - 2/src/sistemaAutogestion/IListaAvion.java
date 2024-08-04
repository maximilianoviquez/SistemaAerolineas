package sistemaAutogestion;
public interface IListaAvion {
    public void agregarInicio(int identificador,String nombre,int capacidad);
    public void mostrar();
    int cantidadElementos ();
    boolean existeElemento (int elemento);
    nodoAerolinea obtenerElemento(int elemento);
    void eliminarElemento (int elemento);
    void agregarFinal (int identificador, String nombre,int capacidad);
    public boolean esVacia();
    public boolean esLLena();  // agregado para lista con tope
    void vaciar();
    void eliminarInicio();
    void eliminarFinal();
}
