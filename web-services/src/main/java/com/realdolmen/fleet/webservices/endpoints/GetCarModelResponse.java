//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 



package com.realdolmen.fleet.webservices.endpoints;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carModelXml" type="{http://realdolmen.com/fleet/webservices/endpoints}carModelXml"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "carModelXml"
})
@XmlRootElement(name = "getCarModelResponse")
public class GetCarModelResponse {

    @XmlElement(required = true)
    protected CarModelXml carModelXml;

    /**
     * Gets the value of the carModelXml property.
     * 
     * @return
     *     possible object is
     *     {@link CarModelXml }
     *     
     */
    public CarModelXml getCarModelXml() {
        return carModelXml;
    }

    /**
     * Sets the value of the carModelXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarModelXml }
     *     
     */
    public void setCarModelXml(CarModelXml value) {
        this.carModelXml = value;
    }

}
