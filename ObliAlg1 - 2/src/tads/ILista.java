package tads;

public interface ILista<T> {
    boolean esVacia();
    void agregarInicio(T n);
    void agregarFinal(T n);
    void agregarInicio();
    void borrarInicio();
    void borrarFin();
    void vaciar();
    void mostrar();
    void borrarElemento(T n);
    int cantElemento();
    Nodo<T> obtenerElemento(T n);
    void agregarOrdenado(T n);
    
    // Métodos adicionales para el ejemplo genérico
    void agregar(T dato);
    int tamaño();
    T obtener(int indice);
}