package com.realdolmen.fleet.webservices.endpoints.services;


import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.webservices.endpoints.CarModelXml;
import com.realdolmen.fleet.webservices.endpoints.GetCarModelRequest;
import com.realdolmen.fleet.webservices.endpoints.GetCarModelResponse;
import com.realdolmen.fleet.webservices.endpoints.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 * Created by SDOAX36 on 30/10/2015.
 */
@Endpoint
public class CarModelEndPoint  {

    @Autowired
    CarModelRepository repository;

    private static final String NAMESPACE_URI ="http://realdolmen.com/fleet/webservices/endpoints";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarModelRequest")
    @ResponsePayload
    public GetCarModelResponse getCarModel(@RequestPayload GetCarModelRequest request) {
        GetCarModelResponse response = new GetCarModelResponse();
        response.setCarModelXml(createCarModelXml(repository.findOne(request.getId())));

        return response;
    }


    private CarModelXml createCarModelXml(CarModel model)
    {
        return new CarModelBuilder()
                .setId(model.getId())
                .setCategory(model.getCategory())
                .setCilinder(model.getCilinder())
                .setEmission(model.getEmission())
                .setGears(model.getGears())
                .setLine(model.getLine())
                .setMark(model.getMark())
                .setModel(model.getModel())
                .setMotorType(model.getMotorType())
                .build();
    }
}
