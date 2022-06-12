using WebApiAjax;

var builder = WebApplication.CreateBuilder(args);

var app = builder.Build();

// Add services to the container.
app.MapGet("/math",
(int x, int y) => new CalcResult()
{
    Sum = x + y,
    Difference = x - y,
    Product = x * y,
    Quotient = x / y
});

// Configure the HTTP request pipeline.
//=============================================Uncomment whole block if necessary==========================
/*
var summaries = new[]
{
    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
};

app.MapGet("/weatherforecast", () =>
{
    var forecast = Enumerable.Range(1, 5).Select(index =>
        new WeatherForecast
        (
            DateTime.Now.AddDays(index),
            Random.Shared.Next(-20, 55),
            summaries[Random.Shared.Next(summaries.Length)]
        ))
        .ToArray();
    return forecast;
});
*/
app.UseStaticFiles();
app.Run();

//=============================================Uncomment whole block if necessary==========================
/*
internal record WeatherForecast(DateTime Date, int TemperatureC, string? Summary)
{
    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}
*/