let pizze;
let tablePizze = document.querySelector('#pizze_table');

function pizzeList(){
    axios.get('http://localhost:8080/api/pizze').then((response) => {
        //console.log("richiesta OK", response);
        pizze = response.data;
        //console.log(pizze);
        tablePizze.innerHTML ='';
        pizze.forEach(pizza => {
            //console.log(pizza);
            tablePizze.innerHTML += `
            <tr>
                <td>${pizza.id}</td>
                <td><a href="./show.html?id=${pizza.id}">${pizza.nome}</a></td>
                <td>${pizza.descrizione}</td>
                <td>${pizza.prezzo}</td>
          </tr>
            `; 
        });
    }).catch((error) => {
        console.error("richiesta errata", error);
    });
}

pizzeList();
