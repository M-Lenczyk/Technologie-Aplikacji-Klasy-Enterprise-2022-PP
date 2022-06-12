/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NighT_WalRiDeR
 */
@JMSDestinationDefinition(name = "java:app/jms/NewsQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NewsQueue")
@MessageDriven(activationConfig =
{
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/NewsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewsMDB implements MessageListener
{

    @PersistenceContext
    private EntityManager em;

    public NewsMDB(){
    }

    @Override
    public void onMessage(Message message)
    {
        ObjectMessage msg = null;
        TextMessage textMsg = null;
        try
        {
            if (message instanceof ObjectMessage)
            {
                msg = (ObjectMessage) message;
                NewsItem e = (NewsItem) msg.getObject();
                em.persist(e);
            }
            else if (message instanceof TextMessage)
            {
                textMsg = (TextMessage) message;
                NewsItem e = new NewsItem(textMsg.getText().split("\\|"));
                em.persist(e);
            }
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }

}
