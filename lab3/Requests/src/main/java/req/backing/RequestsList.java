/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package req.backing;

import data.RequestRepository;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import req.entities.Request;

/**
 *
 * @author mateu
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestRepository requestRepository;

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }

    @Size(min = 3, max = 60, message = "{request.size}")
    private String newRequest;

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    private HtmlDataTable requestsDataTable;

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
    
    @Transactional
    public String addRequest() {
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setRequestText(newRequest);
        requestRepository.create(request);
        setNewRequest("");
        return null;
    }
    
    @Transactional
    public String deleteRequest() {
        Request req = (Request) getRequestsDataTable().getRowData();
        requestRepository.remove(req);
        return null;
    }

}
