//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.01.22 a las 07:29:33 AM PET 
//


package com.example.soap.calculator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="number2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="operation" type="{http://example.com/soap/calculator}operation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "number1",
    "number2",
    "operation"
})
@XmlRootElement(name = "calculatorRequest")
public class CalculatorRequest {

    protected double number1;
    protected double number2;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Operation operation;

    /**
     * Obtiene el valor de la propiedad number1.
     * 
     */
    public double getNumber1() {
        return number1;
    }

    /**
     * Define el valor de la propiedad number1.
     * 
     */
    public void setNumber1(double value) {
        this.number1 = value;
    }

    /**
     * Obtiene el valor de la propiedad number2.
     * 
     */
    public double getNumber2() {
        return number2;
    }

    /**
     * Define el valor de la propiedad number2.
     * 
     */
    public void setNumber2(double value) {
        this.number2 = value;
    }

    /**
     * Obtiene el valor de la propiedad operation.
     * 
     * @return
     *     possible object is
     *     {@link Operation }
     *     
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Define el valor de la propiedad operation.
     * 
     * @param value
     *     allowed object is
     *     {@link Operation }
     *     
     */
    public void setOperation(Operation value) {
        this.operation = value;
    }

}
