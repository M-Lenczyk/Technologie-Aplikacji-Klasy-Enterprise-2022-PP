package com.mycompany.complaintsclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import entities.Complaint;
import javax.ws.rs.client.Entity;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
/**
 *
 * @author NighT_WalRiDeR
 */
public class ComplaintsClient {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        //Configuration
        ClientConfig myClientConfig = new ClientConfig();
        myClientConfig.register(new ObjectMapper().registerModule(new JavaTimeModule()));
        String myURI = "http://localhost:8080/Complaints/"+"resources/complaints/";
        Client client = ClientBuilder.newClient();//Init
         
        //COMPLAINTS COUNT
        String count =
                client.target(myURI+"count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
                System.out.println("Count: ");
                System.out.println(count);
                //client.close();
        
         //DISPLAY ALL COMPLAINTS
         Complaint[] Complaints = client.target(myURI)
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint[].class);
                System.out.println("Complaints: ");
                System.out.println(Arrays.toString(Complaints));
                 
         //DISPLAY OPEN STATUS COMPLAINT
         Complaint openStatusComplaint = null; //dummy, empty instance to fill later
         for (Complaint x:Complaints)
         {
             if(("open").equals(x.getStatus()))
             {
                openStatusComplaint = client.target(myURI+x.getId())
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);
                break; //get Single one
             }
         }
         System.out.println("Open status complaint X:");
         System.out.println(openStatusComplaint);
         
         //CHANGE TO CLOSED STATUS
         Complaint closedStatusComplaint = openStatusComplaint;
         closedStatusComplaint.setStatus("closed");
         //Refresh JSON
         client.target(myURI+closedStatusComplaint.getId())
                 .request()
                 .put(Entity.entity(closedStatusComplaint, MediaType.APPLICATION_JSON));
         
         System.out.println("Closed status complaint X: ");
         System.out.println(closedStatusComplaint.toString());
         
         //DISPLAY ALL OPEN STATUS COMPLAINTS
         
         Complaint[] openComplaints = client.target(myURI)
                .queryParam("status", "open") //key, value
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint[].class);
                System.out.println("Complaints: ");
                System.out.println(Arrays.toString(openComplaints));            
                //Terminate app
                client.close();
    }
}
