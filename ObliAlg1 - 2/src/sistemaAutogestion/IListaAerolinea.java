package sistemaAutogestion;
public interface IListaAerolinea {
    public void agregarInicio(int identificador,String nombre);
    public void mostrar();
    int cantidadElementos ();
    boolean existeElemento (int elemento);
    nodoAerolinea obtenerElemento(int elemento);
    void eliminarElemento (int elemento);
    void agregarFinal (int identificador, String nombre);
    public boolean esVacia();
    public boolean esLLena();  // agregado para lista con tope
    void vaciar();
    void eliminarInicio();
    void eliminarFinal();
}
