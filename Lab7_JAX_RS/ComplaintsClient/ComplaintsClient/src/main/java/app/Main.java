/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;


import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
/**
 *
 * @author NighT_WalRiDeR
 */
public class Main {
    
    public void main()
    {
        Client client = ClientBuilder.newClient();
        String count =
        client.target("http://localhost:8080/Complaints/" +
        "resources/complaints/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);
        System.out.println("Count: " + count);
        client.close();
    }   
}
