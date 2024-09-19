<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Weather Snap</title>

        <link rel="stylesheet" href="./style.css">
        <script src="./script.js"></script>
        <script>
            const cookies = document.cookie.split(',');
            let key = "found";

            for (let i = 0; i < cookies.length; i++) {
                let cookie = cookies[i].trim();

                if (cookie.indexOf(key + "=") === 0) {
                    let val = cookie.substring((key + "=").length, cookie.length);
                    if (val.localeCompare("failed") === 0) {
                        alert("City not found. Please enter a valid city name...");
                    }

                    break;
                }
            }
        </script> 
    </head>

    <body>

        <form action="Weather" onsubmit="return validateForm()" name="search-form">
            <div class="card">

                <!-- search  -->
                <div class="search">
                    <input type="text" placeholder="enter city name" spellcheck="false" name="city" value="${city}">
                    <button type="submit">
                        <img src="./images/search.png" alt="Q" width="16px">
                    </button>
                </div>

                <!-- weather  -->
                <div class="weather">
                    <img src="./images/${condition}.png" class="weather-icon">
                    <h1 class="temp">${temp}°C</h1>
                    <h2 class="city">${city}</h2>

                    <div class="details">
                        <div class="col">
                            <img src="./images/humidity.png">
                            <div>
                                <p class="humidity">${humidity}%</p>
                                <p>Humidity</p>
                            </div>
                        </div>

                        <div class="col">
                            <img src="./images/wind.png">
                            <div>
                                <p class="wind">${wind} km/h</p>
                                <p>Wind Speed</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>

</html>