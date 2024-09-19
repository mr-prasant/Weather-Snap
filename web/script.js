function validateForm() {
    var city = document.forms["search-form"]["city"];
    var name = city.value.trim();

    if (name.length == 0) {
        alert("please write a city name and try again...");
        city.value = "";
        city.focus();
        return false;
    }

    city.value = name;

    return true;
}

