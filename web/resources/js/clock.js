function clock() {
 let date = new Date(),
     hours = (date.getHours() < 10) ? "0" + date.getHours() : date.getHours(),
     minutes = (date.getMinutes() < 10) ? "0" + date.getMinutes() : date.getMinutes(),
     seconds = (date.getSeconds() < 10) ? "0" + date.getSeconds() : date.getSeconds();
 document.getElementById("clock").textContent = `${hours}:${minutes}:${seconds}`;
}
setInterval(clock,9000);
clock();