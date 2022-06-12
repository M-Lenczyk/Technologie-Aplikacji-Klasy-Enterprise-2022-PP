package view.backing;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author NighT_WalRiDeR
 */
@Named(value = "Calculator")
@RequestScoped
public class Calculator
{
    private int firstNumber;
    private int secondNumber;
    private int result;
    private Date date;
    /**
     * Creates a new instance of Calculator
     */
    public Calculator()
    {
        this.firstNumber=0;
        this.secondNumber=0;
        this.result=0;
        this.date = new Date();
    }

    /**
     * @return the firstNumber
     */
    public int getFirstNumber()
    {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber)
    {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber()
    {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber)
    {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the result
     */
    public int getResult()
    {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result)
    {
        this.result = result;
    }
    
    public void calculate()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
        
        setResult(getFirstNumber() + getSecondNumber());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("%d", result)));
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
}
