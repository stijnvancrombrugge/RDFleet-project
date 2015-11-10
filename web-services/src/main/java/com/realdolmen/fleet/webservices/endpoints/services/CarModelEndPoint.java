package com.realdolmen.fleet.webservices.endpoints.services;


import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.services.CarModelService;
import com.realdolmen.fleet.webservices.endpoints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    CarModelService carModelService;

    private static final String NAMESPACE_URI ="http://realdolmen.com/fleet/webservices/endpoints";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarModelRequest")
    @ResponsePayload
    public GetCarModelResponse getCarModel(@RequestPayload GetCarModelRequest request) {
        GetCarModelResponse response = new GetCarModelResponse();
        response.setCarModelXml(createCarModelXml(carModelService.findById(request.getId())));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCarModelCreationRequest")
    @ResponsePayload
    public GetCarModelCreationResponse getCarModelXml(@RequestPayload GetCarModelCreationRequest request)
    {
        GetCarModelCreationResponse response = new GetCarModelCreationResponse();
        CarModel carModel = carModelService.saveNewModel(createCarModelFromXml(request));
        response.setCarModelXml(createCarModelXml(carModel));

        return response;

    }


    private CarModel createCarModelFromXml(GetCarModelCreationRequest model)
    {
        return new CarModelBuilder()
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


    private CarModelXml createCarModelXml(CarModel model)
    {
        return new CarModelXmlBuilder()
                .setId(model.getId())
                .setCategory(model.getCategory().getCategoryClass())
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
