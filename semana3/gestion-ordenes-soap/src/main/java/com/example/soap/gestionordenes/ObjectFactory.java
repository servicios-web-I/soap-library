//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.01.27 a las 09:49:00 AM PET 
//


package com.example.soap.gestionordenes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.soap.gestionordenes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.soap.gestionordenes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearOrdenRequest }
     * 
     */
    public CrearOrdenRequest createCrearOrdenRequest() {
        return new CrearOrdenRequest();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link CrearOrdenResponse }
     * 
     */
    public CrearOrdenResponse createCrearOrdenResponse() {
        return new CrearOrdenResponse();
    }

    /**
     * Create an instance of {@link ListarOrdenesRequest }
     * 
     */
    public ListarOrdenesRequest createListarOrdenesRequest() {
        return new ListarOrdenesRequest();
    }

    /**
     * Create an instance of {@link ListarOrdenesResponse }
     * 
     */
    public ListarOrdenesResponse createListarOrdenesResponse() {
        return new ListarOrdenesResponse();
    }

    /**
     * Create an instance of {@link Orden }
     * 
     */
    public Orden createOrden() {
        return new Orden();
    }

}
