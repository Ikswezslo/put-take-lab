/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mateu
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        List<ComplaintDTO> complaints = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComplaintDTO>>() {
                });
        
        System.out.println("All complaints: ");
        System.out.println(complaints);
        
        Optional<ComplaintDTO> openComplaint = complaints.stream()
                .filter(x -> x.getStatus().equals("open"))
                .findFirst();
        
        openComplaint.ifPresent(obj -> {
            ComplaintDTO complaint = client
                .target("http://localhost:8080/Complaints/resources/complaints/" + obj.getId())
                .request(MediaType.APPLICATION_JSON)
                .get(ComplaintDTO.class);
            
            System.out.println("Open complaint: ");
            System.out.println(complaint);
            
            complaint.setStatus("closed");
            client
                .target("http://localhost:8080/Complaints/resources/complaints/" + complaint.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
            
            
            List<ComplaintDTO> openComplaints = client
                .target("http://localhost:8080/Complaints/resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComplaintDTO>>() {
                });
            System.out.println("Open complaints: ");
            System.out.println(openComplaints);
        });

        client.close();
    }
}
