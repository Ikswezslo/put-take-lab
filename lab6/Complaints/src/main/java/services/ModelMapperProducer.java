/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

/**
 *
 * @author mateu
 */
public class ModelMapperProducer {
    @Produces
    @RequestScoped
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
