package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author NighT_WalRiDeR
 */
@Named(value = "ChartModel")
@RequestScoped
public class ChartModel
{
    private LineChartModel myChartModel;

    /**
     * Creates a new instance of ChartModel
     */
    public ChartModel()
    {
        myChartModel = new LineChartModel();
        
        
        //Utworzenie pustej serii danych. Sinus, cosinus
        LineChartSeries sineVal = new LineChartSeries();
        LineChartSeries cosineVal = new LineChartSeries();
       
        //Wprowadzanie danych do serii
        for (int i = 0; i <= 360; i = i+10)
        {
            sineVal.set(i, Math.sin(Math.toRadians(i)));
            cosineVal.set(i, Math.cos(Math.toRadians(i)));
        }
        
        //Osie wykresu
        Axis xAxis = myChartModel.getAxis(AxisType.X);
        Axis yAxis = myChartModel.getAxis(AxisType.Y);
        
        //Zdefiniowanie osi
        xAxis.setMin(0);
        xAxis.setMax(360);
        yAxis.setMin(-1.0);
        yAxis.setMax(1.0);
        
        //Spięcie i dodanie gotowej serii danych do wykresu
        myChartModel.addSeries(sineVal);
        myChartModel.addSeries(cosineVal);
        
        //Ustawienie etykiet i koloru danych
        sineVal.setLabel("sine");
        cosineVal.setLabel("cosine");
        myChartModel.setLegendPosition("se");//South East Legend
        myChartModel.setSeriesColors("0000FF,FF0000"); //Kolory
        
        //Włączenie funkcji zoomowania
        myChartModel.setZoom(true);
    }
    /**
     * @return the model
     */
    public LineChartModel getMyChartModel()
    {
        return myChartModel;
    }

    /**
     * @param myChartModel the model to set
     */
    public void setMyChartModel(LineChartModel myChartModel)
    {
        this.myChartModel = myChartModel;
    }
    
    public void resetZoom()
    {
        myChartModel.setZoom(false);
    }

}
